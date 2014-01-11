package maze;

public class EBox extends MBox{
	public EBox(int line,int column,Maze maze){
		super(line,column,maze);
	}
	public char boxType(){
		return 'E';
	}
	
	
}
