public class Location{

    private int row;
    private int col;
    private Location previous;
    private int distanceToStart;

    public Location(int row, int col, Location previous, int distanceToStart){
	this.row = row;
	this.col = col;
	this.previous = previous;
	this.distanceToStart = distanceToStart;
    }
    
}
