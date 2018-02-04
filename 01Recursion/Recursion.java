public class Recursion{
    public static int fact(int n){
	//error
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	
	//base case
	if (n == 0){
	    return 1;
	}
	
	//recursive case
	return fact(n-1) * n;
    }

    public static int fib(int n){
	//error
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	
	//base case 0
	if (n  <= 1){
	    return n;
	}
	
	//recursive case
	return fib(n-1) + fib(n-2);
    }

    public static void main(String[]args){
	//testing fact
	//System.out.println (fact(0)); // 1
	//System.out.println (fact(1)); // 1
	//System.out.println (fact(5)); // 120

	//testing fib
	//System.out.println (fib(0)); // 0
	//System.out.println (fib(1)); // 1
	//System.out.println (fib(9)); // 34
	
    }
}
