import java.util.*;
public class MyDeque<E>{

    private E[] data;
    private int length;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (E[])new Object[10];
	length = 0;
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
        data = (E[])new Object[initialCapacity];
	length = 0;
    }

    public int size(){
	return length;
    }

    public void addFirst(E thing){
	if (thing == null){
	    throw new NullPointerException();
	}
    }

    public void addLast(E thing){
	if (thing == null){
	    throw new NullPointerException();
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

}
