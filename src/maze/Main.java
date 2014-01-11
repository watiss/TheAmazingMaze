package maze;
import java.util.ArrayList;

import dijkstra.VertexInterface;


public class Main {
	
	public static void main(String[] args) {
		Maze maze=new Maze(10,10);
		maze.initFromFile("data/labyrinthe.txt");
		
		ArrayList<VertexInterface> vertexList = maze.vertices();
		
		for (VertexInterface v : vertexList) {	
		MBox vertexBox=(MBox)v;
		System.out.println(vertexBox.boxType());
		}
		
		maze.saveToTextFile("data/saveMaze.txt");
		

	}

}
