//Author:valeh

package model;

import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dijkstra.VertexInterface;

import maze.ABox;
import maze.DBox;
import maze.EBox;
import maze.MBox;
import maze.Maze;
import maze.MissingCasesException;
import maze.WBox;

public class GameWindowModel extends Observable {
	private InitWindowModel iwm = new InitWindowModel();

	private int heightUser;
	private int widthUser;
	private Maze graphicMaze;
	private String fileName;

	// constructeur "par défaut"
	public GameWindowModel() {

		heightUser = iwm.getHeightUserInit();
		widthUser = iwm.getWidthUserInit();
		fileName = "data/defaultInitFile.txt";
		this.setInitFile(widthUser, heightUser);
		graphicMaze = new Maze(widthUser, heightUser);
		graphicMaze.initFromFile(this.fileName);

	}

	// constructor used to open files
	public GameWindowModel(String filePath) {

		this.fileName = filePath;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			int l = 0;
			String firstLine = br.readLine(); // count the number of lines and
												// columns in the file to open
			widthUser = firstLine.length();
			while (br.readLine() != null) {
				l++;
			}
			heightUser = l + 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		graphicMaze = new Maze(widthUser, heightUser);
		graphicMaze.initFromFile(this.fileName);

	}

	public Maze getGraphicMaze() {
		return this.graphicMaze;
	}

	public void setGraphicMaze(Maze graphicMaze) {
		this.graphicMaze = graphicMaze;
	}

	public int getHeightUser() {
		return heightUser;
	}

	public int getWidthUser() {
		return widthUser;
	}

	public void setHeightUSer() {
		this.heightUser = heightUser;
	}

	public void setWidthUSer() {
		this.widthUser = widthUser;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public final void setInitFile(int width, int height) {

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(this.fileName);
			for (int lineL = 0; lineL < height; lineL++) {
				if (lineL == 0 || lineL == height - 1) {
					for (int columnC = 0; columnC < width; columnC++) {
						pw.print('W');
					}
					pw.println();
				} else {
					pw.print('W');
					for (int columnC = 1; columnC < width - 1; columnC++) {
						pw.print('E');
					}
					pw.print('W');
					pw.println();
				}

			}
		} catch (Exception e) {
			System.out.println("ERROR");
			e.printStackTrace();
		} finally {
			if (pw != null)
				try {
					pw.close();
				} catch (Exception e) {
				}
		}

	}

	public final void actualiseMaze(int i, int j, char caract) {
		switch (caract) {
		case 'w':
			this.graphicMaze.setTab(i, j, new WBox(i, j, this.graphicMaze));
			break;
		case 'e':
			this.graphicMaze.setTab(i, j, new EBox(i, j, this.graphicMaze));
			break;
		case 'd':
			this.graphicMaze.setTab(i, j, new DBox(i, j, this.graphicMaze));
			break;
		case 'a':
			this.graphicMaze.setTab(i, j, new ABox(i, j, this.graphicMaze));
			break;
		default:
			break;
		}
	}

	public final void save() {
		this.graphicMaze.saveToTextFile(this.fileName);
	}

	public final void saveAs(String userFileName) {
		this.graphicMaze.saveToTextFile(userFileName);
	}

	public final void actualiseModel(File file) {
		setChanged();
		notifyObservers(file);

	}

	public final void solveMaze() {

		ArrayList<VertexInterface> graphicArborescence = new ArrayList<VertexInterface>();
		try {
			graphicArborescence = graphicMaze.solve();
		} catch (MissingCasesException mce) {
			JOptionPane.showMessageDialog(null, mce.getMessage(),
					"cases missing", JOptionPane.ERROR_MESSAGE);
			System.out.println(mce.getMessage());
		}
		// System.out.println("youhou");
		for (VertexInterface vertex : graphicArborescence)
			// System.out.println( ((MBox)vertex).getLabel());
			setChanged();
		notifyObservers(graphicArborescence);
	}

	public final void clear() {
		setChanged();
		notifyObservers();
	}

}
