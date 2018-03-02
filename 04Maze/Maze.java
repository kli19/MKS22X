import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze{

    private char[][]maze;
    private boolean animate;//false by default
    private int[][]moves = {{1,0}, {0,1}, {-1, 0}, {0, -1}};

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: print a meaningful error and exit the program.
    */
    public Maze(String filename) throws FileNotFoundException{
	animate = false;

	String str = "";
	int col = 0;
	int row = 0;

	File text = new File(filename);
	Scanner inputFile = new Scanner(text);
	while(inputFile.hasNextLine()){
	    String line = inputFile.nextLine();
	    str += line + "\n";
	    col = line.length();
	    row++;
	}
        

	maze = new char[row][col];

	int charNum = 0;
	int SCount = 0;
	int ECount = 0;
	for (int r = 0; r < row; r++){
	    for (int c = 0; c < col; c++){
		if (str.charAt(charNum)=='S'){
		    SCount++;
		}
		if (str.charAt(charNum)=='E'){
		    ECount++;
		}

		if (str.charAt(charNum)=='\n'){
		    charNum++;
		}
		maze[r][c] = str.charAt(charNum);
		charNum++;
	    }
	}
	if (SCount != 1 || ECount != 1){
	    throw new IllegalArgumentException("Needs exactly one S and one E");
	}
    }

    
    public String toString(){
	String str = "";
	for (int r = 0; r < maze.length; r++){
	    for (int c = 0; c < maze[r].length; c++){
	        str += maze[r][c];
	    }
	    str += "\n";
	}

        return str;
	
    }
   
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
	//find the location of the S.
	int row = 0;
	int col = 0;
	for (int r = 0; r < maze.length; r++){
	    for (int c = 0; c < maze[r].length; c++){
		if (maze[r][c] == 'S'){
		    row = r;
		    col = c;
		}
	    }
	}

	//erase the S
	maze[row][col] = ' ';

	//and start solving at the location of the s.
	return solve(row, col, 0);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int counter){ //you can add more parameters since this is private
        //automatic animation! You are welcome.
        if(animate){	    
            clearTerminal();
            System.out.println(this);
            wait(200);
        }

        //COMPLETE SOLVE
	if (maze[row][col] == 'E'){	    
	    return counter;	    
	}

	
	for (int i[]: moves){
	    maze[row][col] = '@';	    
	    if (maze[row+i[0]][col+i[1]] == ' ' || maze[row+i[0]][col+i[1]] == 'E' ){
		int ans = solve(row + i[0], col + i[1], counter + 1);
		if ( ans != -1){
		    return ans;
		}
	    }
	    maze[row][col] = '.';
	}
		
	return -1; 
    }

}
