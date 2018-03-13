import java.util.Random;
public class Quick{

    public static int partition (int[] data, int start, int end){
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
	    else if (data[s] > pivot) {
		swap(data, s, e);
		e--;
	    }
	}
	swap(data, start, e);
	return e;
    }

    public static void swap (int[] arr, int n, int m){
	int hold = arr[n];
	arr[n] = arr[m];
	arr[m] = hold;
    }

    public static String toString(int[] data){
	String str = "{";
	for (int i = 0; i < data.length; i ++){
	    str += data[i];
	    if (i < data.length -1){
		str += ", ";
	    }
	}
	str += "}";
	return str;
    }

    public static void main(String[]args){
	//int[] x = new int[] {17, 61, 67, 47, 93 ,12, 20, 4, 44,	68};
	//System.out.println(partition(x, 0, 9));
	//System.out.println(toString(x));
    }
}
