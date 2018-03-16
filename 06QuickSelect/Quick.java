import java.util.Random;
public class Quick{

    public static int partition (int[] data, int start, int end){
	Random rand = new Random();
	int n = rand.nextInt(end - start + 1) + start;
	int pivot = data[n];
	swap (data, start, n);
	
	int lt = start ;
	int gt = end;
	int i = start + 1;
	
	while (i <= gt) {
	    System.out.println (pivot);
	    System.out.println (toString(data));
	    System.out.println("lt: " + lt);
	    System.out.println("i: " + i);
	    System.out.println("gt: " + gt);
	    if (data[i] == pivot) {
		i++;
	    }
	    else if (data[i] > pivot){
		swap(data, i, gt);
		gt--;
	    }
	    else{
		swap(data, i, lt);
		i++;
		lt++;
	    }
	}
	
	return lt;
    }

    public static int quickselect(int[] data, int k){
	int start = 0;
	int end = data.length-1;
	int index = partition(data, start, end);
	while (index != k){
	    if (index < k){
		start = index+1;
	    }
	    else {
		end = index-1;
	    }
	    index = partition(data, start, end);
	}
	return data[index]; //so it compiles
    }

    public static void quicksort(int[]ary){
	quicksortH(ary, 0, ary.length-1);
    }

    public static void quicksortH(int[]data, int lo, int hi){	
	if (lo < hi){
	    int index = partition(data, lo, hi);
	    quicksortH(data, lo, index-1);
	    quicksortH(data, index+1, hi);
	}
	
    }

    public static void swap (int[] data, int n, int m){
	int hold = data[n];
	data[n] = data[m];
	data[m] = hold;
    }

    public static String toString(int[] data){
	String str = "{";
	for (int i = 0; i < data.length; i++){
	    str += data[i];
	    if (i < data.length -1){
		str += ", ";
	    }
	}
	str += "}";
	return str;
    }

    public static void main(String[]args){
	/*
	int[] x = new int[] {17, 61, 67, 47, 93 ,12, 20, 4, 44};
	for (int i = 0; i < x.length; i++){
	    System.out.println(quickselect(x, i));
	    System.out.println(toString(x));
	}
	*/

	/*
	int[] y = new int[] {61, 61, 61, 47, 93 ,12, 61, 4, 44};
	quicksort(y);
	System.out.println(toString(y));
	*/

	int[] y = new int[] {61, 61, 61, 47, 93 ,12, 61, 4, 44};
	partition(y, 0, y.length-1);
	System.out.println(toString(y));
	
    }
}
