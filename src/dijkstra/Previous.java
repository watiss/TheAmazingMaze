package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

public class Previous implements PreviousInterface {
	private final Hashtable<VertexInterface,VertexInterface> h;
	
	public Previous()
	{
		
		h=new Hashtable<VertexInterface,VertexInterface>();	
	}
	
	public void setValue(VertexInterface vertex,VertexInterface pere){
		h.put(vertex, pere);
	}
	
	public VertexInterface getValue(VertexInterface vertex){
		return h.get(vertex);
	}
	
	
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex){
		ArrayList<VertexInterface> array=new ArrayList<VertexInterface>();
		
		while (vertex!=null){
			array.add(vertex);
			vertex=getValue(vertex);    
	}
		return array;
	}

}
