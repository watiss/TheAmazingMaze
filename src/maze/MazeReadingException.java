package maze;

public class MazeReadingException extends Exception{
	

	private static final long serialVersionUID = 1L;
	private int line;
	
	public MazeReadingException(String nameOfFile,int lineNumber,String errorMessage){
		super(errorMessage);
		
	}
		

}
