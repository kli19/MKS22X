public class Location implements Comparable<Location>{
    private int x,y,priority;
    private Location previous;

    public Location(int _x, int _y, Location prev, int distance){
	x = _x;
	y = _y;
	previous = prev;
	priority = distance;
    }

    public int compareTo(Location other){
	return getPriority() - other.getPriority();
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
