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
	    if (current != last){
		str += ", ";
	    }
	    current = current.getNext();
	}
	str += "]";
	return str;
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












    
    private class Node{
	private Integer data;
	private Node next;
	private Node prev;

	private Node(Integer value){
	    data = value;
	    next = null;
	    prev = null;
	}

	private Integer getValue(){
	    return data;
	}
	
	private boolean setValue(Integer value){
	    data = value;
	    return true;
	}

	private Node getNext(){
	    return next;
	}
	
	private boolean setNext(Node next){
	    next = this.next;
	    return true;
	}

	private Node getPrev(){
	    return prev;
	}
	
	private boolean setPrev(Node prev){
	    prev = this.prev;
	    return true;
	}

	public String toString(){
	    String str = "";
	    str += data;
	    return str;
	}
	
    }

}
