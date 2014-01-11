package maze;

public class ABox extends MBox{
	
	public ABox(int line,int column,Maze maze){
		super(line,column,maze);
		
	}
	public char boxType(){
		return 'A';
	}

}
