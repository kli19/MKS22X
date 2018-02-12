public class QueenBoard{
    private int[][]board;
    private int numSolutions;

    public QueenBoard(int size){
	board = new int[size][size];
	numSolutions = 0;
    }

    //adds a Queen to the given row and column & marks danger areas
    private boolean addQueen(int r, int c){
	if (board[r][c] == 0){
	    board[r][c] = -1;

	    for (int i = c + 1; i < board.length; i++){
		board[r][i] += 1;
		//for testing
		//System.out.println(toString());
	    }

	    for (int i = r+1, j = c+1; i < board.length && j < board.length; i++, j++){
		board[i][j] += 1;
		//for testing
		//System.out.println(toString());
	    }

	    for (int i = r-1, j = c+1; i >= 0 && j < board.length; i--, j++){
		board[i][j] += 1;
		//for testing
		//System.out.println(toString());
	    }	    
	    
	    return true;
	}
	return false;
    }

    //removes a Queen from the given row and column & removes one mark from danger areas associated with that Queen
    private boolean removeQueen(int r, int c){
	if (board[r][c] == -1){
	    board[r][c] = 0;

	    for (int i = c + 1; i < board.length; i++){
		board[r][i] -= 1;
	    }

	    for (int i = r+1, j = c+1; i < board.length && j < board.length; i++, j++){
		board[i][j] -= 1;
	    }

	    for (int i = r-1, j = c+1; i >= 0 && j < board.length; i--, j++){
		board[i][j] -= 1;
	    }
	     
	    return true;
	}
	return false;
    }

    /**
     *@return The output string formatted as follows:
     *All numbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     *There are spaces between each symbol:  
     *Q _ _ _
     *_ _ Q _
     * etc.
     */
    public String toString(){
	String str = "";

	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board.length; c++){
		if (board[r][c] == -1){
		    str += "Q ";
		}
		else{
		    //replace with this code for testing
		    //str += board[r][c] + " "
		    str += "_ ";
		}
	    }
	    str += "\n";
	}
	
	return str;
    }

    /**
     *@return false when the board is not solveable and leaves the board filled with zeros; 
     *        true when the board is solveable, and leaves the board in a solved state
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    public boolean solve(){
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board.length; c++){
		if(board[r][c] != 0){
		    throw new IllegalStateException("Board is not empty");
		}
	    }
	}
	return solveHelp(0);
    }

    public boolean solveHelp(int column){
	if (column >= board.length){
	    return true;
	}
	
	for (int r = 0; r < board.length; r++){
	    if (addQueen(r, column)){
		//uncomment this code for testing
		//System.out.println(Text.go(1,1));
		//System.out.println(this);
		//Text.wait(1000);
		if (solveHelp(column + 1)){
		    return true;
		}
		removeQueen(r, column);
	    }			    
	}
      
	return false;
    }

    /**
     *@return the number of solutions found, and leaves the board filled with only 0's
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    public int countSolutions(){
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board.length; c++){
		if (board[r][c] != 0){
		    throw new IllegalStateException("Board is not empty");
		}
	    }
	}
	countSolutionsHelp(0);
	return numSolutions;
    }

    public void countSolutionsHelp(int column){
	if(column >= board.length){
	    numSolutions++;
	    return;
	}
	for(int r = 0;r < board.length;r++){
	    if(addQueen(r,column)){
		countSolutionsHelp(column + 1);
		removeQueen(r,column);
	    }
	}
    }

    public static void main(String[]args){

	
	QueenBoard x = new QueenBoard(3);
	System.out.println(x.countSolutions());
	System.out.println(x.solve());
        System.out.println(x);




    }
}
