public class MyHeap{
    private int length;
    private String[] data;
    private boolean isMax;

    public MyHeap(){
	isMax = true;
	data = new String[10];
    }

    public MyHeap(boolean b){
	this();
	if (!b){
	    isMax = false;
	}
    }

    public int size(){
	return length;
    }

    public String peek(){
	return data[0];
    }

    public void add(String s){
	
    }

    public void swap (int n, int m){
	String temp = data[n];
	data[n] = data[m];
	data[m] = temp;
    }
   
}
