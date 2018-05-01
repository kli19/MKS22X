public class RunningMedians{

    private MyHeap<Integer> small;
    private MyHeap<Integer> large;

    @SuppressWarnings("unchecked")
    public RunningMedians(){
	small = new MyHeap();
	large = new MyHeap(false);
    }

    public MyHeap getSmall(){
	return small;
    }

    public MyHeap getLarge(){
	return large;
    }

    public void add(Integer n){
	if (small.size() == 0 || n < small.peek()){
	    small.add(n);
	}
	else{
	    large.add(n);
	}

	if(small.size() - large.size() > 1){
	    large.add(small.remove());
	}

	else if(large.size() - small.size() > 1){
	    small.add(large.remove());
	}
    }

    public static void main(String[]args){
	RunningMedians x = new RunningMedians();

	x.add(1);
	x.add(2);
	x.add(3);
	x.add(7);
	System.out.println("small: " + x.getSmall());
	System.out.println("large: " + x.getLarge());
    }
    
}
