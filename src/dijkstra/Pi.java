package dijkstra;

import java.util.Hashtable;

public class Pi implements PiInterface{
	private final Hashtable<VertexInterface,Integer> tab;
	
	public Pi(){
		tab=new Hashtable<VertexInterface,Integer>();
	}
	
	public int getValue(VertexInterface vertex){
		return tab.get(vertex).intValue();
	}
	
	public void setValue(VertexInterface vertex,int value){
		tab.put(vertex,new Integer(value));	
	}
}
