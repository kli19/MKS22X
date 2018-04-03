public class MyLinkedList{

    private Node first;
    private Node last;
    private int length;

    public MyLinkedList(){
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

    
    public boolean add(Integer value){
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

    public Integer get(int index){
	return getNode(index).getValue();
    }

    public Integer set(int index, Integer value){
	if(index >= length || index < 0){
	    throw new IndexOutOfBoundsException();      
	}

	Node current = getNode(index);
	Integer oldValue = current.getValue();
	current.setValue(value);
	return oldValue;
    }
    
    public int indexOf(Integer value){
	Node current = first;
	for (int i = 0; i < length; i++){
	    if (current.getValue().equals(value)){
		return i;
	    }
	    current = current.getNext();
	}
	return -1;
    }

    public void add (int index, Integer value){
	Node toAdd = new Node(value);
	
	if(index > length || index < 0){
	    throw new IndexOutOfBoundsException();      
	}

	else if (index == length){
	    add(value);
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






    //---------------------
    // N O D E  C L A S S
    //---------------------
    
    private class Node{
	private Integer data;
	private Node next;
	private Node prev;

	private Node(Integer value){
	    data = value;
	    next = null;
	    prev = null;
	}

	public Integer getValue(){return data;}	
	public void setValue(Integer value){data = value;}

	public Node getNext(){return next;}	
	public void setNext(Node newNext){next = newNext;}

	public Node getPrev(){return prev;}	
	public void setPrev(Node newPrev){prev = newPrev;}
	

	public String toString(){
	    return data + "";
	}
	
    }
    
    

}
