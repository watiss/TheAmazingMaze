package maze;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import view.GameWindowPanel;

import dijkstra.Dijkstra;
import dijkstra.GraphInterface;
import dijkstra.Previous;
import dijkstra.VertexInterface;

public class Maze implements GraphInterface {
	
	
	private  int height; 										
	private  int width;
	
	private final MBox[][] tab;
	
	/*public Maze() {    			//default constructor not used
		tab = new MBox[10][10];
	}*/
	
	public Maze(int width,int height){
		tab=new MBox[height][width];
		this.width=width;
		this.height=height;
	}
	
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	

	public final void setTab(int i,int j,MBox mbox){
		this.tab[i][j]=mbox;
	}

	public final MBox returnCase(int i, int j) {
		return tab[i][j];
	}

	public ArrayList<VertexInterface> vertices() {
		ArrayList<VertexInterface> vertices = new ArrayList<VertexInterface>();
		for (int i = 0; i < height; i++) {
			MBox[] tabI = tab[i];
			for (int j = 0; j < width; j++) {
				vertices.add(tabI[j]);
			}
		}
		return vertices;

	}

	public ArrayList<VertexInterface> followers(VertexInterface vertex) {
		ArrayList<VertexInterface> followers = new ArrayList<VertexInterface>(); 
																		
		MBox box = (MBox) vertex; 
									
		int i = box.getLine();
		int j = box.getColumn();
		if (i > 0) {
			MBox neighbour = tab[i - 1][j];
			if (neighbour.isAccessible())
				followers.add(tab[i - 1][j]);
		}

		if (i < width - 1) {
			MBox neighbour = tab[i + 1][j];
			if (neighbour.isAccessible())
				followers.add(tab[i + 1][j]);
		}

		if (j > 0) {
			MBox neighbour = tab[i][j - 1];
			if (neighbour.isAccessible())
				followers.add(tab[i][j - 1]);
		}

		if (j < height - 1) {
			MBox neighbour = tab[i][j + 1];
			if (neighbour.isAccessible())
				followers.add(tab[i][j + 1]);
		}

		return followers;
	}

	public int weight(VertexInterface departureVertex,
			VertexInterface arrivalVertex) {
		return 1;
	}

	public final void initFromFile(String fileName1) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fileName1);
			br = new BufferedReader(fr);

			String line = new String();

			for (int lineL = 0; lineL < height; lineL++) {
				line = br.readLine();

				if (line == null)
					throw new MazeReadingException(fileName1, lineL,
							"text too short");
				if (line.length() < width)
					throw new MazeReadingException(fileName1, lineL,
							"line too short");
				if (line.length() > width)
					throw new MazeReadingException(fileName1, lineL,
							"line too long");

				for (int columnC = 0; columnC < width; columnC++) {
					char c = line.charAt(columnC);

					switch (c) {
					case 'E':
						tab[lineL][columnC] = new EBox(lineL, columnC, this);
						break;
					case 'W':
						tab[lineL][columnC] = new WBox(lineL, columnC, this);
						break;
					case 'D':
						tab[lineL][columnC] = new DBox(lineL, columnC, this);
						break;
					case 'A':
						tab[lineL][columnC] = new ABox(lineL, columnC, this);
						break;
					default:
						throw new MazeReadingException(fileName1, lineL,
								"unknown character");
					}
				}
			}

		} catch (MazeReadingException m) {
			System.err.println(m.getMessage());
		}

		catch (FileNotFoundException e) {
			System.err.println("lolo" + e);
		}

		catch (IOException e) {
			System.err.println(e);
		} catch (Exception e) {
			System.err.println("Unknown error" + e);
			e.printStackTrace(System.err);
		}
		finally {
			if (br != null)
				try {
					fr.close();
				} catch (Exception e) {
				}
			;
			if (fr != null)
				try {
					br.close();
				} catch (Exception e) {
				}
			;
		}

	}

	public final void saveToTextFile(String fileName) {
		
		PrintWriter pw=null;
		
		try {
			
			pw = new PrintWriter(fileName);
			for (int lineL = 0; lineL < height; lineL++) {
				for (int columnC = 0; columnC < width; columnC++) {
					char c = tab[lineL][columnC].boxType();
					pw.print(c);
					
				}
				pw.println();
			}
			

		} catch (Exception e) {System.out.println("ERROR");}
		finally {
			if (pw!=null) try {pw.close();} catch (Exception e){}
		}
		

	}
	
	public ArrayList<VertexInterface> solve() throws MissingCasesException{
		MBox departureBox=null,arrivalBox=null;
		for (VertexInterface vertex : this.vertices()){
			if (vertex instanceof ABox)
				arrivalBox=(MBox) vertex;
			if (vertex instanceof DBox)
				departureBox=(MBox) vertex;
		}
		if (arrivalBox==null || departureBox==null) throw new MissingCasesException("You must enter at least the Departure case AND " +
				"the Arrival case to solve the maze.");
		Previous previous=(Previous) Dijkstra.dijkstra(this,departureBox);
		ArrayList<VertexInterface> arborescence=previous.getShortestPathTo(arrivalBox);
		return arborescence;
	}

}
