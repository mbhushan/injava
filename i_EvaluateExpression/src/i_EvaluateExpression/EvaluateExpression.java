package i_EvaluateExpression;

import java.util.ArrayList;
import java.util.Stack;

public class EvaluateExpression {
	
	
	public static void main(String[] args) {
		//String [] A = {"2", "1", "+", "3", "*"};
		//String [] A = {"4", "13", "5", "/", "+"};
		String [] A = {"5", "1", "2", "+", "4", "*", "+", "3", "-"};
		ArrayList<String> X = new ArrayList<String>();
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		System.out.println("ans: " + evalRPN(X));
	}

	public static int evalRPN(ArrayList<String> a) {
		String [] operators = {"*", "+", "/", "-"};
		int result = 0;
		int size = a.size();
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=0; i<size; i++) {
			String st = a.get(i);
			boolean opFound = false;
			for (int j=0; j<operators.length; j++) {
				if (st.equals(operators[j])) {
					int x = stack.pop();
					int y = stack.pop();
					int ans = evaluate(y, x, st);
					stack.push(ans);
					opFound = true;
					break;
				}
			}
			if (!opFound) {
				int num = Integer.valueOf(st);
				stack.push(num);
			}
		}
		result = stack.pop();
		
		return result;
	}
	
	private static int evaluate(int x, int y, String op) {
		int result = 0;
		switch (op) {
		case "+":
			result =  x + y;
			break;
		case "-":
			result =  x - y;
			break;
		case "*":
			result = x * y;
			break;
		case "/":
			if (y != 0) {
				result = x / y;
			}
			break;
		default:
			break;
		}
		return result;
	}
}
