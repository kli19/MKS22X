public class Merge {

    public static void merge0(int[] a, int[] b, int[] combined){
	int indexA = 0;
	int indexB = 0;
	int indexC = 0;

	while (indexA < a.length && indexB < b.length){
	    int A = a[indexA];
	    int B = b[indexB];

	    if(A <= B){
		combined[indexC] = A;
		indexA++; indexC++; 		    
	    }

	    else if(B < A){
		combined[indexC] = B;
		indexB++; indexC++; 		    
	    }
	}
	
	if (indexA < a.length){
	    while (indexC < combined.length){
		combined[indexC] = a[indexA];
	    }
	}
	
	else if(indexB < b.length){
	    while (indexC < combined.length){
		combined[indexC] = b[indexB];
		indexB++;
		indexC++;
	    }
	}
	
    }

    public static void merge(int[] data, int[] temp, int lo, int mid, int hi){
	int index = lo;
    
	int low1 = lo;
	int high1 = mid;
	int low2 = mid + 1;
	int high2 = hi;

	while (low1 <= high1 && low2 <= high2){
	    if(data[low1] <= data[low2]){
		temp[index] = data[low1];
		index++;
		low1++;
	    }
	    else if(data[low1] > data[low2]){
		temp[index] = data[low2];
		index++;
		low2++;
	    }
	}

	while (low1 <= high1){
	    temp[index] = data[low1];
	    index++;
	    low1++;
	}

	while (low2 <= high2){
	    temp[index] = data[low2];
	    index++;
	    low2++;
	}
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
	int[] a = new int[]{1,1,3,5,7};
	int[] b = new int[]{1,2,4,12};

	int[]combined = new int[a.length+b.length];
	merge0(a,b,combined);
	System.out.println(toString(combined));

	int[] x = new int[] {0,2,4,1,3,5};
	int[] temp = new int[x.length];
	merge(x,temp,0,2,5);
	System.out.println(toString(temp));
	
    }
}
