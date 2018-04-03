public class Driver{
    public static void main(String[]args){
	MyLinkedList list = new MyLinkedList();
	
	System.out.println(list);
	list.add(0);
	list.add(10);
	list.add(20);
	list.set(1, 15);
	System.out.println("the index of 10 is: " + list.indexOf(10));
	System.out.println("length: " + list.size());
	System.out.println(list);
	//list.clear();
	
	//System.out.println(list.get(-1));
	//System.out.println(list.size());
    }
}
