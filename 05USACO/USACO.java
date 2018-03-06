import java.io.*;
import java.util.*;

public class USACO {
    public static int bronze(String filename){
	try {
	    File text = new File(filename);
	    Scanner input = new Scanner(text);

	    int R = input.nextInt();
	    int C = input.nextInt();
	    int E = input.nextInt();
	    int N = input.nextInt();

	    int[][] lake = new int[R][C];
	    for (int r = 0; r < R; r++){
		for (int c = 0; c < C; r++){
		    lake[r][c] = input.nextInt();
		}
	    }
	}catch(Exception e){}


	
	return 0; // so it compiles
    }

    public static void stomp(int[][] lake, int R_s, int C_s, int D_s){
	int[][] cowLocations = new int[][] {
	    {0,0}, {0,1}, {0,2},
	    {1,0}, {1,1}, {1,2},
	    {2,0}, {2,1}, {2,2}
	};

	int max = 0;

	for (int d = D_s; d > 0; d --){
	
	    for (int i[]: cowLocations){
		if (lake[R_s + i[0]][C_s + i[1]] > max){
		    max = lake[R_s + i[0]][C_s + i[1]];
		}
	    }

	    for (int i[]: cowLocations){
		if (lake[R_s + i[0]][C_s + i[1]] ==  max){
		    lake[R_s + i[0]][C_s + i[1]]--;
		}
	    }

	}
	
    }
    
    public static int silver(String filename){
	return 0; // so it compiles
    }
}
