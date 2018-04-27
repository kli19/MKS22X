public class MyHeap{
    private int length;
    private String[] data;
    private boolean isMax;

    public MyHeap(){
	isMax = true;
	data = new String[10];
    }

    public MyHeap(boolean b){
	this();
	if (!b){
	    isMax = false;
	}
    }
   
}
