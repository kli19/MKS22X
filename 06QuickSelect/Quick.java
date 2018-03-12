import java.util.Random;
public class Quick{

    public static int partition (int[] data, int start, int end){
	Random rand = new Random();
	int n = rand.nextInt(end - start + 1) + start;
	return 0;
    }

    public static void main(String[]args){
	int[] x = new int[] {17, 61, 67, 47, 93 ,12, 20, 4, 44,	68};
	System.out.println(partition(x, 0, 9)); // 
    }
}
