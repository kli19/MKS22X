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
	int parent = (index-1)/2;
	if (isMax && data[index].compareTo(data[parent]) > 0 ||
	    !isMax && data[index].compareTo(data[parent]) < 0){	    
	    swap(index, parent);
	    pushUp(parent);
	}
    }

    public void pushDownLeft(int index){
	swap(index, index*2+1);
    }

    public void pushDownRight(int index){
	swap(index, index*2+2);
    }

    public void add(String s){
	if (size() == data.length){
	    resize();
	}

	data[size()] = s;
	pushUp(size());
	
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

    public void resize(){
	String[] temp = new String[size()*2];
	for (int i = 0; i < size(); i++){
	    temp[i] = data[i];
	}
	temp = data;	
    }


    public static void main(String[]args){
	/*
	int x = -1 / 2;
	System.out.println(x);
	*/
    }
}
