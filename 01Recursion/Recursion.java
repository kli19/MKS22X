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
	return fibHelper(n);
    }

    public static int fibHelper(int n){
	if (n  <= 1){
	    return n;
	}
	return fibHelper(n-1) + fibHelper(n-2);
    }
    
    public static double sqrt(double n){
	//error
	if (n < 0){
	    throw new IllegalArgumentException();
	}

	if (n == 0){
	    return 0;
	}

	return sqrtHelper (n, 1);
    }

    public static double sqrtHelper(double n, double guess){
	double betterGuess = (n / guess + guess) / 2;
	if ((Math.abs((n - betterGuess*betterGuess)) / n) < 0.00001){
		return betterGuess;
	    }
	return sqrtHelper(n, betterGuess);	    
    }

    public static void main(String[]args){
	//testing fact
	//System.out.println(fact(-1));
	//System.out.println (fact(0)); // 1
	//System.out.println (fact(1)); // 1
	//System.out.println (fact(5)); // 120

	//testing fib
	//System.out.println(fib(-1));
	System.out.println (fib(0)); // 0
	System.out.println (fib(1)); // 1
	System.out.println (fib(9)); // 34

	//testing sqrt
	System.out.println(sqrt(1));
	System.out.println(sqrt(0));
	
    }
}
