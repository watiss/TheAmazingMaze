package dijkstra;


public interface ASetInterface {
	
	public void addElement(VertexInterface element);  //Lets you add a vertex to A which is an array of vertices.
	
	public boolean isInA(VertexInterface element);	   //Checks if a vertex is in A in which case it returns true,else it returns false.
	
}
