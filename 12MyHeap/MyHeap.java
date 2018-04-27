public class MyHeap{
    private int length;
    private String[] data;
    private boolean isMax;

    public MyHeap(){
	this(true);
    }

    public MyHeap(boolean b){
	if (b){
	    isMax = true;
	}
	else{
	    isMax = false;
	}
	data = new String[10];
	length = 0;
    }

    public int size(){
	return length;
    }

    public String peek(){
	return data[0];
    }

    public void pushUp(int index){
	swap(index, (index-1)/2);
    }

    public void pushDownLeft(int index){
	swap(index, index*2+1);
    }

    public void pushDownRight(int index){
	swap(index, index*2+2);
    }

    public void add(String s){
	
	length++;
    }

    public String remove(){
	String s = data[0];

	swap(0, size()-1);
	
	length--;
	return s;
    }

    public void swap (int n, int m){
	String temp = data[n];
	data[n] = data[m];
	data[m] = temp;
    }

    public String toString(){
	String str = "";
	for (int i = 0; i < size(); i++){
	    str += data[i] + "  ";
	}
	return str;
    }
   
}
