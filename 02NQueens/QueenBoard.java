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
	    }

	    for (int i = r+1, j = c+1; i < board.length && j < board.length; i++, j++){
		board[i][j] += 1;
	    }

	    for (int i = r-1, j = c+1; i > 0 && j < board.length; i--, j++){
		board[i][j] += 1;
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

	    for (int i = r-1, j = c+1; i > 0 && j < board.length; i--, j++){
		board[i][j] -= 1;
	    }
	     
	    return true;
	}
	return false;
    }

    public String toString(){
	String str = "";

	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board.length; c++){
		if (board[r][c] == -1){
		    str += "Q ";
		}
		else{
		    str += board[r][c] + " ";
		}
	    }
	    str += "\n";
	}
	
	return str;
    }

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

    public void countSolutionsHelp(int col){
	if(col >= board.length){
	    numSolutions++;
	    return;
	}
	for(int r = 0;r < board.length;r++){
	    if(addQueen(r,col)){
		countSolutionsHelp(col + 1);
		removeQueen(r,col);
	    }
	}
    }

    public static void main(String[]args){
	QueenBoard x = new QueenBoard(4);
	System.out.println(x.countSolutions());
	System.out.println(x.solve());
	System.out.println(x);
	
	
    }
}
