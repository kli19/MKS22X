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

    public void pushDown(int index){
	int L = index*2+1;
	int R = index*2+2;
	if (L < size()&& data[index].compareTo(data[L]) < 0 && (R >= size() || data[R].compareTo(data[L]) <= 0)){
	    swap(index, L);
	    pushDown(L);	    
	}

	else if (R < size() && data[index].compareTo(data[R]) < 0 && (L >= size() || data[L].compareTo(data[R]) < 0)){
	    swap(index, R);
	    pushDown(R);			     	    
	}

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
	String s = peek();
	swap(0, size()-1);
	length--;	
	pushDown(0);	
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
        data = temp;	
    }


    public static void main(String[]args){
        MyHeap x = new MyHeap();
	
	for(int i = 0; i < 10; i++){
	    int temp = (int)(Math.random() * 100);
	    x.add("" + temp);
	    System.out.println(x);
	}

	for(int i = x.size(); i>0; i--){
	    x.remove();
	    System.out.println(x);
	    System.out.println("done");
	}
		
    }
}
