import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{
    private Location start,end;
    private char[][] board;

    public Maze(String filename) throws FileNotFoundException{
	
	String str = "";
	int col = 0;
	int row = 0;
	int startX = 0;
	int startY = 0;
	int endX = 0;
	int endY = 0;

	File text = new File(filename);
	Scanner inputFile = new Scanner(text);
	while(inputFile.hasNextLine()){
	    String line = inputFile.nextLine();
	    str += line + "\n";
	    col = line.length();
	    row++;
	}
        

	board = new char[row][col];

	int charNum = 0;
	int SCount = 0;
	int ECount = 0;
	for (int r = 0; r < row; r++){
	    for (int c = 0; c < col; c++){
		if (str.charAt(charNum)=='S'){
		    startX = c;
		    startY = r;
		    SCount++;
		}
		if (str.charAt(charNum)=='E'){
		    startY = c;
		    startX = r;
		    ECount++;
		}

		if (str.charAt(charNum)=='\n'){
		    charNum++;
		}
		board[r][c] = str.charAt(charNum);
		charNum++;
	    }
	}

	start = new Location(startX, startY, null);
	end = new Location(endX, endY, null);
	if (SCount != 1 || ECount != 1){
	    throw new IllegalArgumentException("Needs exactly one S and one E");
}
    }

    // '#' - wall 
    // ' ' - open space
    // '?' - frontier space
    // '.' - visited space
    // 'E' - end space (do not replace this)
    // '@' - part of solution
    // 'S' - starting space (do not replace this)
    public String toString(){
	String str = "";
	for (int r = 0; r < board.length; r++){
	    for (int c = 0; c < board[r].length; c++){
	        str += board[r][c];
	    }
	    str += "\n";
	}

	return str;
    }
   
    // Work on this method as a group! 
    public String toStringColor(){
	String str = "";
	return str;
    }

    //return a list of Locations that are:
    // adjacent to n and  not visited
    // all the Locations in this list should have their previous set to n.
    public Location[] getNeighbors(Location n){
	Location[] l = new Location[4];
	int[][]moves = {{1,0}, {0,1}, {-1, 0}, {0, -1}};
	int index = 0;
	for (int i[]:moves){
	    
	}
	return l;
    }

    public Location getStart(){
	return start;
    }

    public Location getEnd(){
	return end;
    }



}
