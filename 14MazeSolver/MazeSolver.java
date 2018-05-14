public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private Boolean aStar;
    

    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
    }

    public boolean solve(){
	return solve(0);
    }

    public boolean solve(int mode){
	aStar = false;
	if(mode == 0){
	    frontier = new FrontierQueue();
	}

	else if (mode == 1){
	    frontier = new FrontierStack();
	}

	else if (mode == 2){
	    frontier = new FrontierPriorityQueue();
	}

	else {
	    frontier = new FrontierPriorityQueue();
	    aStar = true;
	}
	frontier.add(maze.getStart());
	Location end = maze.getEnd();

	while(frontier.hasNext()){	    
	    //System.out.println(maze.toStringColor());
	    Location next = frontier.next();

	    if(!next.equals(maze.getStart())){
		maze.set(next.getX(), next.getY(), '.');
	    }
	    
	    Location[] neighbors = maze.getNeighbors(next, aStar);

	    for (Location L: neighbors){
		if (L != null){
		    if (L.equals(end)){
        
			while (!next.equals(maze.getStart())){


			   
			    maze.set(next.getX(), next.getY(), '@');
			    next = next.getPrev();
			  
			}

			//System.out.println(maze.toStringColor());
			
			
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
	/*
	MazeSolver x = new MazeSolver("test.txt");
	System.out.println(x.solve(1));
	*/
	
	
    }

}
