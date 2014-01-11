package dijkstra;

import java.util.ArrayList;


public interface GraphInterface {
	public ArrayList<VertexInterface> vertices();  //returns all of the vertices
	public ArrayList<VertexInterface> followers(VertexInterface vertex);  //returns the array of the followers of a vertex
	public int weight(VertexInterface departureVertex,VertexInterface arrivalVertex); //returns the weight of an arc
	
}
