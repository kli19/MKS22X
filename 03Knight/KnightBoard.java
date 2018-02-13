public class KnightBoard{

    private int[][] board;
    
    public KnightBoard(int startingRows, int startingCols){
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException("Parameters cannot be negative");
	}
	
	board = new int[startingRows][startingCols];
	
	//testing toString
	/*
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board[0].length; c++){
		board[r][c] = c+7;
	    }
	}
	*/
    }

    public String toString(){
	String str = "";
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board[0].length; c++){
		if (board[r][c] == 0){
		    str += "_ " ;
		}
		else if (board[r][c] < 10){
		    str += " " + board[r][c] + " ";
		}
	        else {
		    str += board[r][c]+ " " ;
		}		
	    }
	    str+= "\n";
	}
	return str;
    }

    public static void main(String[]args){
	KnightBoard a = new KnightBoard(5,5);
	System.out.println(a);
    }
}
