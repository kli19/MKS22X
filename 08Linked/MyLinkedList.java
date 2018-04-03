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

    public Integer get(int index){
	if (index >= length || index < 0){
	    throw new IndexOutOfBoundsException();
	}

	Node current = first;
	for (int i = 0; i < index; i++){
	    current = current.getNext();
	}

	return current.getValue();
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
	
	private void setValue(Integer value){
	    data = value;
	}

	private Node getNext(){
	    return next;
	}
	
	private void setNext(Node next){
	    next = this.next;
	}

	private Node getPrev(){
	    return prev;
	}
	
	private void setPrev(Node prev){
	    prev = this.prev;
	}

	public String toString(){
	    String str = "";
	    str += data;
	    return str;
	}
	
    }

}
