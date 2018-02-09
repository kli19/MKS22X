public class QueenBoard{
    private int[][]board;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    private boolean addQueen(int r, int c){
	if (board[r][c] == 0){
	    board[r][c] = -1;

	    for (int i = c + 1; c < board[r].length; c++){
		board[r][i] += 1;
	    }
	    
	    return true;
	}
	return false;
    }

    private boolean removeQueen(int r, int c){
	if (board[r][c] == -1){
	    board[r][c] = 0;
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
		    str += "_ ";
		}
	    }
	    str += "\n";
	}
	
	return str;
    }

    public boolean solve(){
	return true;
    }


    public int countSolutions(){
	return 0;
    }

    public static void main(String[]args){
	QueenBoard x = new QueenBoard(5);
	x.addQueen(2,3);
	
	System.out.println(x.addQueen(2,4));
    }
}
