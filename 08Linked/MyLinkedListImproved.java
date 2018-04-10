import java.util.*;
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{

    private Node first;
    private Node last;
    private int length;

    public MyLinkedListImproved(){
	first = null;
	last = null;
	length = 0;
    }
    
    
    public String toString(){
	String str = "[";
	Node current = first;
	while (current != null){
	    
	    str += current;
	    if (current.getNext() != null){
		str += ", ";
	    }
	    current = current.getNext();
	}
	str += "]";
	return str;
    }

    
    public void clear(){
	first = null;
	last = null;
	length = 0;
    }

    
    public boolean add(T value){
	Node toAdd = new Node(value);

	if (length == 0){
	    first = toAdd;
	}

	else{
	    last.setNext(toAdd);
	    toAdd.setPrev(last);	    
	    
	}
	
	last = toAdd;
	length++;
	return true;
    }

    public int size(){
	return length;
    }

    private Node getNode(int index){
	if(index >= length || index < 0){
	    throw new IndexOutOfBoundsException();      
	}

	Node current = first;
	for (int i = 0; i < index; i++){
	    current = current.getNext();
	}
	
	return current;
    }

    public T get(int index){
	return getNode(index).getValue();
    }

    public T set(int index, T value){
	if(index >= length || index < 0){
	    throw new IndexOutOfBoundsException();      
	}

	Node current = getNode(index);
	T oldValue = current.getValue();
	current.setValue(value);
	return oldValue;
    }
    
    public int indexOf(T value){
	Node current = first;
	for (int i = 0; i < length; i++){
	    if (current.getValue().equals(value)){
		return i;
	    }
	    current = current.getNext();
	}
	return -1;
    }

    public void add (int index, T value){
	Node toAdd = new Node(value);
	
	if(index > length || index < 0){
	    throw new IndexOutOfBoundsException();      
	}

	else if (index == length){
	    add(value);
	    return;
	}	
	
	else if (index == 0){
	    first.setPrev(toAdd);
	    toAdd.setNext(first);
	    first = toAdd;
	}
	
	else{
	    toAdd.setNext(getNode(index));
	    toAdd.setPrev(toAdd.getNext().getPrev());
	    
	    toAdd.getNext().setPrev(toAdd);
	    toAdd.getPrev().setNext(toAdd);	    
	}

	length++;
    }

    public boolean remove(T value){
	Node current = first;
	for (int i = 0; i < length; i++){
	    if(current.getValue().equals(value)){
		remove(i);
		return true;
	    }
	    current = current.getNext();
	}
	
	return false;
    }

    public T remove(int index){
	if(index > length || index < 0){
	    throw new IndexOutOfBoundsException();      
	}

	Node current = getNode(index);
	System.out.println("got node");
	T removed = current.getValue();

	if (length == 1){
	    first = null;
	    last = null;
	}
	
	else if (index == 0){
	    first = first.getNext();
	    first.setPrev(null);
	}

	else if (index == length -1){
	    last = last.getPrev();
	    last.setNext(null);
	}

	else{
	    current.getPrev().setNext(current.getNext());
	    current.getNext().setPrev(current.getPrev());	    
	}
	
	length--;
	return removed;
    }




    //---------------------
    // N O D E  C L A S S
    //---------------------
    
    private class Node{
	private T data;
	private Node next;
	private Node prev;

	private Node(T value){
	    data = value;
	    next = null;
	    prev = null;
	}

	public T getValue(){return data;}	
	public void setValue(T value){data = value;}

	public Node getNext(){return next;}	
	public void setNext(Node newNext){next = newNext;}

	public Node getPrev(){return prev;}	
	public void setPrev(Node newPrev){prev = newPrev;}
	

	public String toString(){
	    return data + "";
	}
	
    }

    

    //---------------------
    // I T E R A T O R
    //---------------------

    private class MyLinkedListIterator implements Iterator<T>{
	private Node next;
	private MyLinkedListIterator(Node start){
	    next = start;
	}

	public T next(){
	    if(hasNext()){		
		T ans = next.getValue();
		next = next.getNext();
		return ans;
	    }

	    else{
	        throw new IndexOutOfBoundsException();		
	    }
	}

	public boolean hasNext(){
	    return next != null;
	}
    }

    public Iterator<T> iterator(){
	return new MyLinkedListIterator(first);
    }


    
	
    public static void main(String[]args){
	
	  MyLinkedListImproved<String> n = new MyLinkedListImproved<>();
	  MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
	
	
	  
	
	  for (int i = 0; i<10; i++){
	      m.add(Integer.valueOf(i)); 
	  }	
	  System.out.println(m);

	  n.add("This");
	  n.add("means");
	  n.add("iterable");
	  n.add("is");
	  n.add("working");
	  System.out.println(n);

	  for(String i: n){
	      System.out.println(i);
	      n.remove(i);
	      System.out.println(n + "\n");
	      
	  }
	
    }
    

}
