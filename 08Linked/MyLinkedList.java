public class MyLinkedList{

    private Node start;
    private Node end;
    private int size;

    public MyLinkedList(Node start, Node end, int size){
	start = this.start;
	end = this.end;
	size = 0;
    }

    public boolean add(Integer n){
	return true;
    }

    private class Node{
	private Integer data;
	private Node next;
	private Node prev;

	private Node(Integer n){
	    data = n;
	    next = null;
	    prev = null;
	}

	private Integer getValue(){
	    return data;
	}
	
	private boolean setValue(Integer n){
	    data = n;
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
	
	private boolean setPrev(){
	    return true;
	}

	public String toString(){
	    String str = "";
	    str += data;
	    return str;
	}
	
    }

}
