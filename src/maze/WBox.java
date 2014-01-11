package maze;

public class WBox extends MBox {
	
	public WBox(int line,int column,Maze maze){
		super(line,column,maze);
		
	}
	@Override 
	public boolean isAccessible(){
		return false;
	}
	public char boxType(){
		return 'W';
	}


}
