import java.util.*;
public class Sort{
  
    public static void radixsort(MyLinkedListImproved<Integer> data){
	if (data.size() > 0){
	    @SuppressWarnings("unchecked")
		MyLinkedListImproved<Integer>[] positiveBucket = new MyLinkedListImproved[10];
	    @SuppressWarnings("unchecked")
		MyLinkedListImproved<Integer>[] negativeBucket = new MyLinkedListImproved[10];

	    for(int i = 0; i < 10; i++){
                positiveBucket[i] = new MyLinkedListImproved<Integer>();
		negativeBucket[i] = new MyLinkedListImproved<Integer>();
            }

	    int max = Math.abs(data.get(data.max()));		
	    int min = Math.abs(data.get(data.min()));
	    int maxNumDigits = (Math.max(max, min) + "").length();

	    for (int i = 0; i < maxNumDigits; i++){		
		for (Integer num: data){
		    if(num >= 0){	    
			int index = (int)(num / Math.pow(10, i)) % 10;
			positiveBucket[index].add(num);
		    }

		    else{
			int index = Math.abs(9-(int)(num*-1 / Math.pow(10, i)) % 10);
			negativeBucket[index].add(num);
		    }
		}
		data.clear();
		
		for (int j = 0; j < negativeBucket.length; j++){
		    data.extend(negativeBucket[j]);
		    //System.out.println(data);
		}
		for (int j = 0; j < positiveBucket.length; j++){
		    data.extend(positiveBucket[j]);
		    //System.out.println(data);
		}		

		
	    }
	    
	}	

    }

    /*
    public static void main(String[]args){
	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();       
	
	for (int i = 10; i>0; i--){
	    m.add(Integer.valueOf(i)); 
	}
	m.add(-5);
	m.add(-1);
	System.out.println(m);

	radixsort(m);
	System.out.println(m);
	
    }
    */

}   
