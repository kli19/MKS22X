import java.util.*;
public class Sorts{

    public static void main(String[]args){
	
	int[]data = new int[10000];
	int[]correctData = new int[10000];
	for(int i = 0; i < 10000; i++){
	    int temp = (int)(Math.random() * 1000);
	    data[i] = temp;
	    correctData[i] = temp;
	}
	
	Arrays.sort(correctData);
	HeapSort(data);

	boolean hasError = false;
	int index = 0;
	for(int x: data){
	    if(!(x == correctData[index])){
		System.out.println("THERE IS AN ERROR");
		System.out.println("Index of error: " + index);
		hasError = true;
	    }
	    index++;
	}
	if (!hasError){
	    System.out.println("YAY");
	}
	
	/*
	int[]data = new int[10];
	for(int i = 0; i < data.length; i++){
	    int temp = (int)(Math.random() * 10);
	    data[i] = temp;
	}
	
	System.out.println(toString(data));
	HeapSort(data);
	System.out.println(toString(data));
	*/
	
    }

    public static void HeapSort(int[]data){

	Heapify(data);
	//System.out.println(toString(data));
	//System.out.println("data has been heapified");
	int length = data.length - 1;
	
	for (int i = 0; i < data.length; i++){

	    int toSwap = data[data.length-1-i];
	    // System.out.println("root " + data[0]);	    	    
	    //System.out.println("to swap with " + toSwap + "\n");

	    swap(data, 0, length);
	    pushDown(data, 0, length);
	    length--;
	    
	    //System.out.println(toString(data));
      	}
    }

    public static int remove(int[]data, int end){
	int s = data[0];
	swap(data, 0, end);	
	pushDown(data, 0, end);	
	return s;
    } 



    public static void pushDown(int[]data, int index, int end){
	int L = index*2+1;	
	int R = index*2+2;
 
	if (L < end && data[index] < data[L] && (R >= end || data[R] <= data[L])){
	    swap(data, index, L);
	    pushDown(data, L, end);	    
	}

	if (R < end && data[index] < data[R] && (L >= end || data[L] < data[R])){
	    swap(data, index, R);
	    pushDown(data, R, end);			     	    
	}
	
    }

    


    public static void Heapify(int[]data){
	for (int i = data.length-1; i >= 0; i--){
	    pushDown(data, i, data.length);
	}
    }
    
    public static void swap (int[]data, int n, int m){
	int temp = data[n];
	data[n] = data[m];
	data[m] = temp;
    }

    public static String toString(int[]data){
	String str = "";
	for (int i = 0; i < data.length ; i++){
	    str += data[i] + "  ";
	}
	return str;
    }

}
