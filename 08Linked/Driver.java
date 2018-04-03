public class Driver{
    public static void main(String[]args){
	MyLinkedList list = new MyLinkedList();
	
	System.out.println(list);
	System.out.println(list.size());
	list.add(0);
	list.add(10);
	//list.add(20);
	//System.out.println(list);
	//System.out.println(list.size());
	//list.clear();
	
	System.out.println(list.get(1));
	//System.out.println(list.size());
    }
}
