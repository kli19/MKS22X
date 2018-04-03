public class Driver{
    public static void main(String[]args){
	MyLinkedList list = new MyLinkedList();
	
	System.out.println(list);
	System.out.println(list.size());
	list.add(1);
	System.out.println(list);
	System.out.println(list.size());
	list.clear();
	System.out.println(list);
	System.out.println(list.size());
    }
}
