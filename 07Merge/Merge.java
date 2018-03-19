public class Merge {

    public static void merge(int[] a, int[] b, int[] combined){
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
	    /*
	    System.out.println(toString(combined));
	    System.out.println(toString(a));
	    System.out.println(toString(b));
	    System.out.println("indexA: " + indexA);
	    System.out.println("indexB: " + indexB + "\n\n");
	    */
	}
	
	if (indexA < a.length){
	    while (indexC < combined.length){
		combined[indexC] = a[indexA];
		/*
		indexA++;
		indexC++;
		System.out.println("a: " + toString(combined));
		System.out.println(toString(a));
		System.out.println(toString(b));
		System.out.println("indexA: " + indexA);
		System.out.println("indexB: " + indexB + "\n\n");
		*/
	    }
	}
	
	else if(indexB < b.length){
	    while (indexC < combined.length){
		combined[indexC] = b[indexB];
		indexB++;
		indexC++;
		/*
		System.out.println(toString(combined));
		System.out.println(toString(a));
		System.out.println(toString(b));
		System.out.println("indexA: " + indexA);
		System.out.println("indexB: " + indexB + "\n\n");
		*/
	    }
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
	merge(a,b,combined);
	System.out.println(toString(combined));
	
    }
}
