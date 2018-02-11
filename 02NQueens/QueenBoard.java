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
		    str += "_" + " ";
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



	//--------------thanks for the test cases Crystal---------------
	QueenBoard b = new QueenBoard(4);

	System.out.println(b.solve()); //prints true
	System.out.println(b); //prints a valid solution


	try{
	    b.solve();
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"


	 try{
      b.countSolutions();
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
	 } //prints "Error: The board contains non-zero values"

	 for (int i = 0; i < 12; i++){
	     QueenBoard a = new QueenBoard(i);
	     System.out.println("# of Solutions for " + i + ": " + a.countSolutions());
	     /*          Expected Values
			 i --> # of Solutions   i --> # of Solutions
			 0 --> 1                      6 --> 4
			 1 --> 1                      7 --> 40
			 2 --> 0                      8 --> 92
			 3 --> 0                      9 --> 352
			 4 --> 2                    10 --> 724
			 5 --> 10                  11 --> 2680
	     */
	     System.out.println(a); //prints out an empty i by i grid of underscores
	 }
    
    }
}
