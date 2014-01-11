package maze;
import java.util.ArrayList;

import dijkstra.VertexInterface;


public abstract class MBox implements VertexInterface{
	private final int column;
	private final int line;
	private final Maze maze;
	
	public MBox(int line,int column,Maze maze){
		this.line=line;
		this.column=column;
		this.maze=maze;
	}
	
	public final String getLabel(){
		String str="("+line+","+column+")";
		return str;
	
	}
	
	public int getLine(){
		return line;
	}
	public int getColumn(){
		return column;
	}
	public boolean isAccessible(){
		return true;
	}

	public abstract char boxType();
}
