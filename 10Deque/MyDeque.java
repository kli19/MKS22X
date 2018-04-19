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
	
	else if (size() == data.length){
	    resize();
	}

	else {
	    if(first == 0){
		data[data.length-1] = thing;
	    }
	
	    else{
		data[first-1] = thing;
	    }
	}
    }

    public void addLast(E thing){
	if (thing == null){
	    throw new NullPointerException();
	}
	else if (size() == data.length){
	    resize();
	}
    }

    public E removeFirst(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return null;
    }

    public E removeLast(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return null;
    }

    public E getFirst(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return null;
    }

    public E getLast(){
	if (size() == 0){
	    throw new NoSuchElementException();
	}
	return null;
    }

    @SuppressWarnings("unchecked")
    public void resize(){
	E[] temp = (E[])new Object[size()*2];

	int index = 0;
	for (int i = first; i < data.length; i++){
	    temp[index] = data[i];
	    index++;
	}
	
	if (first > 0){
	    for (int i = 0; i < last; i++){
		temp[index] = data[i];
		index++;
	    }
	}
	
	first = 0;
	last = size()-1;   
    }

    public String toString(){
	String str = "";
	int index = 0;
	for (int i = first; i < data.length; i++){
	    str += data[i];
	    index++;
	}
	
	if (first > 0){
	    for (int i = 0; i < last; i++){
	        str += data[i];
		index++;
	    }
	}
	return str;

	
    }

    public static void main(String[]args){
	MyDeque<Integer>  x = new MyDeque<>();
	x.addFirst(21);
	System.out.println(x);
    }
 
}
