public class RunningMedian{

    private MyHeap<Double> small;
    private MyHeap<Double> large;

    @SuppressWarnings("unchecked")
    public RunningMedian(){
	small = new MyHeap<>();
	large = new MyHeap<>(false);
    }

    public MyHeap getSmall(){
	return small;
    }

    public MyHeap getLarge(){
	return large;
    }

    public void add(double n){
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

    public double getMedian(){
	if (small.size()>large.size()){
	    return small.peek();
	}

	else if(large.size()> small.size()){
	    return large.peek();
	}
	
	return (small.peek()+large.peek()) / 2;	
    }

    public static void main(String[]args){
	
	RunningMedian x = new RunningMedian();

	x.add(1);
	x.add(2);
	x.add(10);
	x.add(7);
	x.add(0);
	x.add(5);
	System.out.println("small: " + x.getSmall());
	System.out.println("large: " + x.getLarge());
	System.out.println("median: " + x.getMedian());
	
    }
    
}
