public class Sorts{

    public static void main(String[]args){
	int[] data = new int[10];
	for (int i = 0; i < data.length; i++){
	    data[i] = i;
	}
	System.out.println(toString(data));
	Heapify(data);
	//pushDown(data,4);
	System.out.println(toString(data));
    }

    public static void HeapSort(){

    }

    public static void Heapify(int[]data){
	for (int i = data.length-1; i >= 0; i--){
	    pushDown(data, i);
	    System.out.println(toString(data));
	    System.out.println("pushed down: " +i+ "\n -----------------");
	}
    }

    public static void pushDown(int[]data, int index){
	System.out.println("index: " + index);
	int L = index*2+1;
	System.out.println("L: " + L);	
	int R = index*2+2;
	System.out.println("R: " + R);
	/*
	if (L < data.length && R < data.length){
	    if (data[index]<data[L] && data[L] > data[R]){	    
		swap(data, index, L);
		pushDown(data, L);
	    }

	    else if (data[index]<data[R]){	    
		swap(data, index, R);
		pushDown(data, R);
	    }
	}
	else if(L < data.length && R >= data.length){
	    if(data[index]<data[L]){
		swap(data, index, L);
		pushDown(data, L);
	    }
	}

	else if(R < data.length && L >= data.length){
	    if (data[index]<data[R]){	    
		swap(data, index, R);
		pushDown(data, R);
	    }
	}
	*/
	
	//// refactoring code
	
	if (L < data.length && data[index] < data[L] && (R >= data.length || data[R] <= data[L])){
	    swap(data, index, L);
	    pushDown(data, L);	    
	}

	if (R < data.length && data[index] < data[R] && (L >= data.length || data[L] < data[R])){
	    swap(data, index, R);
	    pushDown(data, R);			     	    
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
