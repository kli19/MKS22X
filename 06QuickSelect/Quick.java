import java.util.Random;
public class Quick{

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
    
    //less efficient----------------------------------------------------------------
    public static int part (int[] data, int start, int end){
	Random rand = new Random();
	int n = rand.nextInt(end - start + 1) + start;

	int pivot = data[n];
	swap (data, start, n);
	
	int s = start + 1;
	int e = end;
	
	while (s <= e) {
	    //System.out.println (pivot);
	    //System.out.println (toString(data));
	    if (data[s] < pivot) {
		s++;
	    }
	    else {
		swap(data, s, e);
		e--;
	    }
	}
	swap(data, start, e);
	return e;
    }

    public static int quickselect0(int[] data, int k){
	int start = 0;
	int end = data.length-1;
	int index = part(data, start, end);
	while (index != k){
	    if (index < k){
		start = index+1;
	    }
	    else {
		end = index-1;
	    }
	    index = part(data, start, end);
	}
	return data[index]; //so it compiles
    }

    public static void quicksort0(int[]ary){
	quicksortH0(ary, 0, ary.length-1);
    }

    public static void quicksortH0(int[]data, int lo, int hi){	
	if (lo < hi){
	    int index = part(data, lo, hi);
	    quicksortH0(data, lo, index-1);
	    quicksortH0(data, index+1, hi);
	}
	
    }

    //more efficient-------------------------------------------------------------
    public static int[] partition (int[] data, int start, int end){
	Random rand = new Random();
	int n = rand.nextInt(end - start + 1) + start;
	int pivot = data[n];
	//System.out.println("pivot: " + pivot);
	swap (data, start, n);
	
	int i = start + 1;
	int lt = start;
	int gt = end;
	
	while (i <= gt) {
	    //System.out.println (pivot);
	    //System.out.println (toString(data));
	    if (data[i] == pivot) {
		i++;
	    }
	    if (data[i] > pivot) {
		swap(data, i, gt);
		gt--;
	    }
	    if (data[i] < pivot){
		swap(data, i, lt);
		i++;
		lt++;
	    }
	}
	int[] bounds = new int[]{lt,gt};
	return bounds;
    }

   
    public static int quickselect(int[] data, int k){
	int start = 0;
	int end = data.length-1;
	int[] bounds = partition(data, start, end);

		    System.out.println (toString(bounds));
	    System.out.println("start: " + start);
	    System.out.println("end: " + end);
	    System.out.println(toString(data));
	    System.out.println("=============================\n");
	
	while (bounds[0] > k || bounds[1]< k){   
			      
	    if (bounds[0] < k){
		start = bounds[1]+1;
	    }
	    else if (bounds[1] > k) {
		end = bounds[0]-1;
	    }
	    bounds = partition(data, start, end);

	    System.out.println (toString(bounds));
	    System.out.println("start: " + start);
	    System.out.println("end: " + end);
	    System.out.println(toString(data));
	    System.out.println("=============================\n");
	}
	return data[bounds[0]]; 
    }
    public static void main(String[]args){
	
	int[] x = new int[]  {61, 61, 61, 47, 93 ,12, 61, 4, 44};
	System.out.println(quickselect(x, 8));
	
	

	/*
	  int[] y = new int[] {61, 61, 61, 47, 93 ,12, 61, 4, 44};
	  quicksort(y);
	  System.out.println(toString(y));
	

	
	int[] y = new int[] {61, 61, 61, 47, 93 ,12, 61, 4, 44};
	System.out.println(toString(y));
	System.out.println(toString(partition(y, 0, y.length-1)));
	System.out.println(toString(y));
	
	*/
	
    }
}
