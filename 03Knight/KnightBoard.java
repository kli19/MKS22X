public class KnightBoard{

    private int[][] board;
    private final int[][] displacement = {{-1,-2}, {-1,2}, {1,-2}, {1,2}, {-2,-1}, {-2,1}, {2,-1}, {2,1}};


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
		    str += "__ " ;
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
	return solveH(startingRow, startingCol, 1);
    }

    private boolean solveH(int row, int col, int level){
	/*
	System.out.println(Text.CLEAR_SCREEN);
	System.out.println(Text.go(1,1));
	System.out.println(this);
	Text.wait(5);
	*/
       		
	if (level > board.length*board[0].length){
	    return true;
	}
       
	for (int i[]: displacement){
	    try{
		if (board[row][col] == 0){
		    board[row][col] = level;
		    if(solveH(row+i[0],col+i[1], level + 1)){
			return true;			
		    }

		    else{
			board[row][col] = 0;
		    }
		}
			
	    }catch(Exception e){}
	}
	
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
	return countSolutionsH(startingRow, startingCol, 1);
    }

    public int countSolutionsH(int row, int col, int level){

	int numSolutions = 0;
	board[row][col] = level;
	    
	if (level == board.length*board[0].length){
	    System.out.println(this);

	    return 1; 
	}
	
	for (int i[]: displacement){
	    try{
		if (board[row+i[0]][col+i[1]] == 0){
		    numSolutions += countSolutionsH(row+i[0],col+i[1], level + 1);
		    board[row+i[0]][col+i[1]] = 0;		    
		}
					
	    }catch(Exception e){}
	   
	}
	board[row][col] = 0;
	
	return numSolutions  ;
    }

   
  
    private boolean isInRange(int row, int col){
	return row >= 0 || row < board.length || col >= 0 || col < board[0].length;
  }

    public static void main(String[]args){
	KnightBoard a = new KnightBoard(5,5);
	System.out.println(a.countSolutions(0,0));
	System.out.println(a);
	System.out.println(a.solve(0,0));
	System.out.println(a);
	
    }
}
