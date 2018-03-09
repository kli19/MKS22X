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

    
    public static int silver(String filename){
	int numSolutions = 0;
	try{
	    
	    File text = new File(filename);
	    Scanner input = new Scanner(text);

	    int N = input.nextInt();
	    int M = input.nextInt();
	    int T = input.nextInt();

	    input.nextLine();
	    char[][] pasture = new char[N][M];
	    
	    for (int r = 0; r < N; r++){
		String line = input.nextLine();
		for (int c = 0; c < M; c++){
		    pasture[r][c] = line.charAt(c);
		    //System.out.println(toString(pasture));
		}
		
	    }

	    int R1 = input.nextInt() - 1;
	    int C1 = input.nextInt() - 1;
	    int R2 = input.nextInt() - 1;
	    int C2 = input.nextInt() - 1;

	    int[][] arr1 = new int[N][M];
	    int[][] arr2 = new int[N][M];

	    for (int r = 0; r < N; r++){
		for (int c = 0; c < M; c++){
		    if (pasture[r][c] == '*'){
			arr1[r][c] = -1;
			arr2[r][c] = -1;
		    }
		    else {
			arr1[r][c] = 0;
			arr2[r][c] = 0;
		    }
		}
	    }

	    arr1[R1][C1] = 1;
	    arr2[R1][C1] = 1;
	    
	    //System.out.println(toString(arr1) + "\n\n" + toString(arr2));
	    for (int t = 0; t < T; t++){
		if (t%2 == 0){
		    move(arr1, arr2);		    
		}
		else{
		    move(arr2, arr1);
		}
		System.out.println(toString(arr1) + "\n" + toString(arr2));
		System.out.println("--------------------------------");
	    
	    
	    }
	    
	    if (T % 2 == 0){
		//System.out.println(toString(arr1) + "\n\n" + toString(arr2));
		return arr1[R2][C2];
	    }
	    //System.out.println(toString(arr1) + "\n\n" + toString(arr2));
	    return arr2[R2][C2];
	    
	}catch(Exception e){System.exit(1);}
	    
	return 0; // so it compiles
    }

    public static void move(int[][] arr1, int[][]arr2){
	int[][] moves = new int[][] {
	    {-1, 0},
	    {0, -1},
	    {1, 0},
	    {0, 1}
	};
	for (int r = 0; r < arr1.length; r++){
	    for (int c = 0; c < arr1[0].length; c++){
		if (arr1[r][c] > 0){
		    arr2[r][c] = 0;
		}		
		if(arr1[r][c] == 0){
		    arr2[r][c] = 0;
		    for (int[] i: moves){
			int row = r + i[0];
			int col = c + i[1];

			if (isValid(arr1, row, col) ) {			    
			    arr2[r][c] += arr1[row][col];
			}
		    }
		}
	    }
	   
	}	
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

    public static String toString(char[][] arr){
	String str = "";
	for (int r = 0; r < arr.length; r++){
	    for (int c = 0; c < arr[r].length; c++){
		str += arr[r][c] + " ";
	    }
	    str += "\n";
	}
	return str;
    }

    public static boolean isValid(int[][] arr, int r, int c){
	return (r < arr.length && r >= 0 && c < arr[0].length && c >= 0 && arr[r][c] != -1);
    }

    //public static void main (String[]args){
	//System.out.println(bronze("bronzeTest1.txt")); // 342144
	//System.out.println(bronze("bronzeTest2.txt")); // 102762432
	// System.out.println(silver("silverTest4.txt"));
    //}
}
