public class Calculator{

    public static double eval(String expression){
	@SuppressWarnings("unchecked")
	    Stack<String> stack = new Stack();
	String temp = "";
	for (int i = 0; i < expression.length(); i++){
	    if(expression.charAt(i) == ' '){
		if (temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/") || temp.equals("%")){
		    double num1 = Double.parseDouble(stack.pop());
		    double num2 = Double.parseDouble(stack.pop());
		    stack.push(solve(temp, num1, num2));
		}
		else{
		    stack.push(temp);
		}
		temp = "";
	    }

	    else{
		temp += expression.charAt(i);
	    }
	}
	double num1 = Double.parseDouble(stack.pop());
	double num2 = Double.parseDouble(stack.pop());
	return Double.parseDouble(solve(temp, num1, num2));
	
    }

    public static String solve(String operator, double num1, double num2){
	if (operator.equals("+")){
	    return (num2 + num1) + "";
	}

	else if (operator.equals("-")){
	    return (num2 - num1) + "";
	}
		
	else if (operator.equals("*")){
	    return (num2 * num1) + "";
	}
		
	else if (operator.equals("/")){
	    return (num2 / num1) + "";
	}
		
	else{
	    return (num2 % num1) + "";
	}			
    }

    public static boolean isOperator(String s){
	return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%");
    }

    /*
    public static void main(String[] args) {
	System.out.println(eval("6 6 +"));
	System.out.println(eval("11 3 - 4 + 2.5 *"));
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }
   */
    

}
