public class MyLinkedList{

    private int start;
    private int end;
    private int size;

    public MyLinkedList(int start, int end, int size){
	start = this.start;
	end = this.end;
	size = 0;
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

	private Integer get(){
	    return data;
	}
	
	private boolean set(Integer n){
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
	    return str;
	}
	
    }

}
