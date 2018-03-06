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
		for (int c = 0; c < C; c++){
		    lake[r][c] = input.nextInt();
		}
	    }

	    for (int n = N; n > 0; n--){
		int R_s = input.nextInt() -1;
		int C_s = input.nextInt() -1;
		int D_s = input.nextInt();
		int[][] cowLocations = new int[][] {
		    {0,0}, {0,1}, {0,2},
		    {1,0}, {1,1}, {1,2},
		    {2,0}, {2,1}, {2,2}
		};

	

		for (int d = D_s; d > 0; d--){
		    int max = 0;
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

	    int totalDepth = 0;
	    for (int r = 0; r < R; r ++){
		for (int c = 0; c < C; c++){
		    if (E > lake[r][c]){
			totalDepth += E - lake[r][c];
		    }
		}
	    }
	   
	    return totalDepth * 72 *72;
	    
	}catch(Exception e){System.exit(1);}
	
	return 0; // so it compiles
    }

    public static void stomp(int[][] lake, int R_s, int C_s, int D_s){

	//for debugging
	//System.out.println(toString(lake));
	
    }
    
    public static int silver(String filename){
	return 0; // so it compiles
    }

    public static String toString(int[][] arr){
	String str = "";
	for (int r = 0; r < arr.length; r++){
	    for (int c = 0; c < arr[r].length; c++){
		str += arr[r][c] + " ";
	    }
	    str += "\n";
	}
	return str;
    }

    public static void main (String[]args){
	System.out.println(bronze("bronzeTest1.txt")); // 342144
	System.out.println(bronze("bronzeTest2.txt")); // 102762432
	
    }
}
