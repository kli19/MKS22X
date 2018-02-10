public class QueenBoard{
    private int[][]board;

    public QueenBoard(int size){
	board = new int[size][size];
    }

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

	for (int i = 0; i < board.length; i ++){
	    for (int j = 0; j < board[i].length; j++){
		if (board[i][j] == -1){
		    str += "Q ";
		}
		else{
		    str += board[i][j] + " ";
		}
	    }
	    str += "\n";
	}
	
	return str;
    }

    public boolean solve(){
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board.length; j++){
		if(board[i][j] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return solveHelp(0);
    }

    public boolean solveHelp(int column){
	if (column >= board.length){
	    return true;
	}

	for (int i = 0; i < board.length; i++){
	    if (addQueen(i, column)){
		if (solveHelp(column + 1)){
		    return true;
		}
		removeQueen(i, column);
	    }			    
	}

	return false;
    }




    public int countSolutions(){
	int num = 0;
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board.length; j++){
		if (board[i][j] != 0){
		    throw new IllegalStateException("Board is not empty");
		}
	    }
	}
	return num;
    }

    public static void main(String[]args){
	QueenBoard x = new QueenBoard(3);
	System.out.println(x.solve());
	System.out.println(x);
	
    }
}
