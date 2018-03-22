public class Merge {

   

    public static void merge(int[] data, int[] temp, int lo1, int hi1, int lo2, int hi2){
	int index = lo1;
    
	while (lo1 <= hi1 && lo2 <= hi2){
	    if(data[lo1] <= data[lo2]){
		temp[index] = data[lo1];
		index++;
		lo1++;
	    }
	    else if(data[lo1] > data[lo2]){
		temp[index] = data[lo2];
		index++;
		lo2++;
	    }
	}

	while (lo1 <= hi1){
	    temp[index] = data[lo1];
	    index++;
	    lo1++;
	}

	while (lo2 <= hi2){
	    temp[index] = data[lo2];
	    index++;
	    lo2++;
	}
  }

    public static void mergesort(int[]data){
	int[] temp = new int[data.length];
	msort(data,temp,0,data.length-1);
    }

    public static void msort(int[]data, int[]temp, int lo, int hi){

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
	int[] a = new int[]{1,1,3,5,7};
	int[] b = new int[]{1,2,4,12};

	int[]combined = new int[a.length+b.length];
	merge0(a,b,combined);
	System.out.println(toString(combined));
	*/

	int[] x = new int[] {0,2,4,7,3,5,7,9};
	int[] temp = new int[x.length];
	merge(x,temp,0,3,4,x.length-1);
	System.out.println("--------------------------------------------");
	System.out.println(toString(x));
	System.out.println(toString(temp));
	
    }
}
