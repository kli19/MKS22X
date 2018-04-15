public class Sort{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	if (data.size() > 0){
	    @SuppressWarnings("unchecked") 
	    MyLinkedListImproved<Integer>[] bucket = new MyLinkedListImproved[10];

	    for(int i = 0; i < bucket.length; i++){
                bucket[i] = new MyLinkedListImproved<Integer>();
            }

	    int maxNumDigits = (data.get(data.max()) + "").length();

	    for (int i = 0; i < maxNumDigits; i++){
		for (Integer num: data){
		    int index = (int)(num / Math.pow(10, i)) % 10;
		    //System.out.println ("index: " + index);
		    bucket[index].add(num);		    
		}
		data.clear();
		
		for (int j = 0; j < bucket.length; j++){
		    data.extend(bucket[j]);
		    bucket[j].clear();
		}
		
	    }
	    
	}	

    }

    public static void main(String[]args){
	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();       
	
	for (int i = 10; i>0; i--){
	    m.add(Integer.valueOf(i)); 
	}
	System.out.println(m);

	radixsort(m);
	System.out.println(m);
	
    }
}   
