public class MazeSolver{
    private Maze maze;
    private Frontier frontier;

    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
    }

    public boolean solve(){
	return solve(0);
    }

    public boolean solve(int mode){
	if(mode == 0){
	    frontier = new FrontierQueue();
	}

	else{
	    frontier = new FrontierStack();
	}

	frontier.add(maze.getStart());
	
	return false;
    }

    public String toString(){
	return maze.toString();
    }

    

}
