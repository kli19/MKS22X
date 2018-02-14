public class KnightBoard{

    private int[][] board;
    private int numSolutions;
    private final int[] moveKnightRow = {-1, -1, 1, 1, -2, -2, 2, 2};
    private final int[] moveKnightColumn = {-2, 2, -2, 2, 1, -1, 1, -1};
    
    public KnightBoard(int startingRows, int startingCols){
	if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException("Parameters cannot be negative");
	}
	
	board = new int[startingRows][startingCols];

	numSolutions = 0;

	
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

    public boolean solve(int startingRow, int startingCol){
	if (startingRow >= board.length || startingRow < 0){
	    throw new IllegalArgumentException("Row is not valid");
	}

	if (startingCol >= board[0].length || startingCol < 0){
	    throw new IllegalArgumentException("Column is not valid");
	}
	
	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board.length; c++){
		if (board[r][c] != 0){
		    throw new IllegalStateException("Board contains non-zero values");
		}
	    }
	}
	return solveH(startingRow, startingCol, 0);
    }

    private boolean solveH(int row, int col, int level){
	return false;
    }

    public int countSolutions(int startingRow, int startingCol){
	if (startingRow >= board.length || startingRow < 0){
	    throw new IllegalArgumentException("Row is not valid");
	}

	if (startingCol >= board[0].length || startingCol < 0){
	    throw new IllegalArgumentException("Column is not valid");
	}
	
	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board.length; c++){
		if (board[r][c] != 0){
		    throw new IllegalStateException("Board contains non-zero values");
		}
	    }
	}
	return countSolutionsH(startingRow, startingCol, 0);
    }

    public int countSolutionsH(int row, int col, int level){
	return numSolutions;
    }

    public static void main(String[]args){
	KnightBoard a = new KnightBoard(5,5);
	System.out.println(a);
    }
}
