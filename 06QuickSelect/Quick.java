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
	/*
	System.out.println (toString(bounds));
	System.out.println("start: " + start);
	System.out.println("end: " + end);
	System.out.println(toString(data));
	System.out.println("=============================\n");
	*/
	
	while (bounds[0] > k || bounds[1]< k){   
			      
	    if (bounds[0] < k){
		start = bounds[1]+1;
	    }
	    else if (bounds[1] > k) {
		end = bounds[0]-1;
	    }
	    bounds = partition(data, start, end);

	    /*
	    System.out.println (toString(bounds));
	    System.out.println("start: " + start);
	    System.out.println("end: " + end);
	    System.out.println(toString(data));
	    System.out.println("=============================\n");
	    */
	}
	return data[k]; 
    }


    public static void quicksort(int[]ary){
	quicksortH(ary, 0, ary.length-1);
    }

    public static void quicksortH(int[]data, int lo, int hi){	
	if (lo < hi){
	    int[] bounds = partition(data, lo, hi);
	    quicksortH(data, lo, bounds[0]-1);
	    quicksortH(data, bounds[1]+1, hi);
	}
	
    }
    public static void main(String[]args){
	/*
	int[] x = new int[]  {61, 61, 61, 47, 93 ,12, 61, 4, 44};
	System.out.println(quickselect(x, 8));
	System.out.println(quickselect(x, 7));
	System.out.println(quickselect(x, 6));
	System.out.println(quickselect(x, 5));
	System.out.println(quickselect(x, 4));
	System.out.println(quickselect(x, 3));
	System.out.println(quickselect(x, 2));
	System.out.println(quickselect(x, 1));
	System.out.println(quickselect(x, 0));
       
	
	int[] y = new int[] {61, 61, 61, 47, 93 ,12, 61, 4, 44};
	quicksort(y);
	System.out.println(toString(y));
	

	  
	int[] a = new int[] {61, 61, 61, 47, 93 ,12, 61, 4, 44};
	System.out.println(toString(a));
	System.out.println(toString(partition(a, 0, a.length-1)));
	System.out.println(toString(a));
	*/
	
	
    }
}
