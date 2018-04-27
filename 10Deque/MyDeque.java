import java.util.*;
public class MyDeque<E>{

    private E[] data;
    private int length, first, last;
    

    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[])new Object[10];
	length = 0;
	first = 0;
	last = 0;
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
        data = (E[])new Object[initialCapacity];
	length = 0;
	first = 0;
	last = 0;
    }

    public int size(){
	return length;
    }

    public void addFirst(E thing){		
	if (thing == null){
	    throw new NullPointerException();
	}

	else if (size() == 0){
	    data[first] = thing;
	}
	
	else{
	    if (size() == data.length){
		resize();
		//System.out.println("doubled length");
	    }

	    first = Math.floorMod(first - 1, data.length);
	    data[first] = thing;
	}
	//System.out.println(this);
	length++;
    }

    public void addLast(E thing){
	if (thing == null){
	    throw new NullPointerException();
	}
	else if (size() == 0){
	    data[last] = thing;
	}
	
	else{
	    if (size() == data.length){
		resize();
		//System.out.println("doubled length");
	    }
	    
	    last = Math.floorMod(last + 1, data.length);
	    data[last] = thing;
	}
	//System.out.println(this);
	length++;
    }

    public E removeFirst(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	E thing = getFirst();
        first = Math.floorMod(first + 1, data.length);
	length--;
	return thing;
    }

    public E removeLast(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	E thing = getLast();
        last = Math.floorMod(last - 1, data.length);
	length--;
	return thing;
    }

    public E getFirst(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return data[first];
    }

    public E getLast(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return data[last];
    }

    @SuppressWarnings("unchecked")
    public void resize(){
	E[] temp = (E[])new Object[size()*2];

	int index = first;
	int i = 0;
	while(index != last){
	    temp[i] = data[index];
	    index = Math.floorMod(index+1, data.length);
	    i++;
	}
	temp[i] = data[index];
	data = temp;
	first = 0;
	last = size()-1;   
    }

    public String toString(){
	String str = "";
	int index = first;
	while(index != last){	    
	    str += data[index] + ", ";
	    index = Math.floorMod(index+1, data.length);
	}
	str += data[index];
	return str;	
    }

    public static void main(String[]args){
	
	  MyDeque<Integer>  x = new MyDeque<>(5);
	  //x.addLast(25);
	  // x.addLast(28);
	  x.addFirst(21);
	  //x.addLast(30);
	  x.addFirst(19);
	  //System.out.println(x);
	  x.addLast(31);
	  x.removeLast();
	  x.removeLast();
	  x.removeLast();
			
	  
	

	/*
	MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
	ArrayList<String> b = new ArrayList<>();

	int size = Integer.parseInt(args[0]);
	for(int i = 0; i < size; i++){
	    int temp = (int)(Math.random() * 1000);
	    if(temp % 2 == 0){
		a.addFirst("" + temp);
		a1.addFirst("" + temp);
		b.add(0, "" + temp);
	    }
	    else{
		a.addLast("" + temp);
		a1.addLast("" + temp);
		b.add("" + temp);
	    }
	}

	int index = 0;
	boolean hasError = false;
	String errorEvaluation = "Errors found at these indices: ";
	for (String x : b){
	    if (!(x.equals(a.getFirst()))){
		System.out.println("The getFirst() function is incorrect at index " + index);
		hasError = true;
	    }
	    if (!(x.equals(a.removeFirst()))){
		System.out.println("There is an error at index " + index);
		errorEvaluation += index + ", ";
		hasError = true;
	    }
	    index++;
	}


	if(hasError){
	    errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
	    System.out.println(errorEvaluation);
	    System.out.println("MyDeque: " + a1);
	    System.out.println("Actual Deque: " + b);
	}
	else{
	    System.out.println("Your deque is bug-free!");
	}
	*/
    }
 
}
