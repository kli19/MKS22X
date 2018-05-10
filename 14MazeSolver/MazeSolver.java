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

	else if (mode == 1){
	    frontier = new FrontierStack();
	}

	else{
	    frontier = new FrontierPriorityQueue();
	}

	frontier.add(maze.getStart());
	Location end = maze.getEnd();

	while(frontier.hasNext()){	    
	    //System.out.println(maze);
	    Location next = frontier.next();
	    if(next.equals(end)){
		return true;
	    }

	    if(!next.equals(maze.getStart())){
		maze.set(next.getX(), next.getY(), '.');
	    }
	    
	    Location[] neighbors = maze.getNeighbors(next);

	    for (Location L: neighbors){
		if (L != null){
		    if (L.equals(end)){
			return true;
		    }
		    frontier.add(L);
		    maze.set(L.getX(), L.getY(), '?');
		}
		
	    }
	}
	
	return false;
    }

    public String toString(){
	return maze.toString();
    }

    public static void main(String[]args){
	MazeSolver x = new MazeSolver("test.txt");
	System.out.println(x.solve(2));
	
	
    }

}
