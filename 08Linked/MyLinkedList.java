public class MyLinkedList{

    private Node first;
    private Node last;
    private int length;

    public MyLinkedList(){
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
