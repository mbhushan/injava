package rec_ExpressionAddOperators;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Stack;

/*
Given a string that contains only digits 0-9 and a target value, return all possibilities 
to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples:
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
*/

public class AddOperators {
	
	public static void main(String[] args) {
		AddOperators ao = new AddOperators();
		
		String [] inputs = {"123", "232", "105", "00", "3456237490"};
		int [] targets = {6, 8, 5, 0, 9191};
		
		for (int i=0; i<inputs.length; i++) {
			ao.evaluate(inputs[i], targets[i]);
		}
	}
	
	public void evaluate(String input, int target) {
	
		System.out.println("expression: " + input);
		System.out.println("target: " + target);
		String [] operators = {"+", "-", "*"};
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=input.length()-1; i>=0; i--) {
			int val = Character.getNumericValue(input.charAt(i));
			stack.push(val);
		}
		String [] buff = new String[input.length()-1];
		evaluate(stack, target, operators, buff, 0);
	}
	
	private void evaluate(Stack<Integer> stack, int target, String [] operators, String [] sb, int index) {
		if (stack.size() == 1 && stack.peek() == target) {
			System.out.println(Arrays.toString(sb));
		}
		
		if (index == sb.length) {
			return;
		}
		
		if (stack.size() < 2) {
			return;
		}
		
		for (int i=0; i<operators.length; i++) {
			int x = stack.pop();
			int y = stack.pop();
			int ans = eval(x, y, operators[i]);
			if (ans <= target) {
				stack.push(ans);
				sb[index] = operators[i];
				evaluate(stack, target, operators, sb, index+1);
				stack.pop();
			} 
			stack.push(y);
			stack.push(x);
		}
	}
	
	public int eval(int x, int y, String op) {
		if (op.equals("*")) {
			return x * y;
		} else if (op.equals("+")) {
			return x + y;
		} else if (op.equals("-")) {
			return x - y;
		}
		
		return 0;
	}

}
