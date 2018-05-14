public class Location implements Comparable<Location>{
    private int x,y,priority,stepsFromStart;
    private Location previous;

    public Location(int _x, int _y, Location prev, int pri, int steps){
	x = _x;
	y = _y;
	previous = prev;
	priority = pri;
	stepsFromStart = steps;
    }

    public int compareTo(Location other){
	return  getPriority() - other.getPriority();
    }

    public int getStepsFromStart(){
	return stepsFromStart;
    }
    
    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public void setPrev(Location prev){
	previous = prev;
    }

    public Location getPrev(){
        return previous;
    }

    public boolean equals(Location other){
	return x == other.getX() && y == other.getY();
    }

    public int getPriority(){
	return priority;
    }
}
