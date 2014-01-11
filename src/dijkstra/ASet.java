package dijkstra;

import java.util.HashSet;
import java.util.Set;

public class ASet implements ASetInterface{   
	
	private final HashSet<VertexInterface> s;
	
	public ASet(){
	s=new HashSet<VertexInterface>(); 
	}
	
	public void addElement(VertexInterface element){
		s.add(element);
	}
	
	public boolean isInA(VertexInterface element){
		return s.contains(element);
		
	}
	
}
