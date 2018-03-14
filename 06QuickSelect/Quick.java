import java.util.Random;
public class Quick{

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
	    else if (data[s] > pivot) {
		swap(data, s, e);
		e--;
	    }
	}
	swap(data, start, e);
	return e;
    }

    public static int quickselect(int[] data, int k){
	int start = 0;
	int end = data.length-1;
	int index = part(data, start, end);
	while (index != k){
	    if (index < k){
		start = index+1;
	    }
	    else if (index > k){
		end = index-1;
	    }
	    index = part(data, start, end);
	}
	return data[index]; //so it compiles
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
	int[] x = new int[] {17, 61, 67, 47, 93 ,12, 20, 4, 44};
	//System.out.println(part(x, 0, 9));
	for (int i = 0; i < x.length; i++){
	    System.out.println(quickselect(x, i));
	    System.out.println(toString(x));
	}
	
	
    }
}
