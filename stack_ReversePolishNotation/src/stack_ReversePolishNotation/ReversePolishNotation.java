package stack_ReversePolishNotation;

import java.util.Stack;

/*
 Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
 Valid operators are +, -, *, /. Each operand may be an integer or another expression. For example:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class ReversePolishNotation {

	private final String OPERATORS = "+-*/";
	
	public static void main(String [] args) {
		String [][] tokens = {
				{"2", "1", "+", "3", "*"},
				{"4", "13", "5", "/", "+"}
		};
		
		ReversePolishNotation RPN = new ReversePolishNotation();
		
		for (int i=0; i<tokens.length; i++) {
			System.out.println("result: " + RPN.evalRPN(tokens[i]));
		}
	}
	
	public int evalRPN(String [] tokens) {
		int result = 0;
		Stack<String> stack = new Stack<String>();
		
		for (String tok: tokens) {
			if (!OPERATORS.contains(tok)) {
				stack.push(tok);
			} else {
				int x = Integer.valueOf(stack.pop());
				int y = Integer.valueOf(stack.pop());
				int opIndex = OPERATORS.indexOf(tok);
				switch (opIndex) {
				case 0:
					stack.push(String.valueOf(x+y));
					break;
				case 1:
					stack.push(String.valueOf(y-x));
					break;
				case 2:
					stack.push(String.valueOf(x*y));
					break;
				case 3: //assumes x != 0
					stack.push(String.valueOf(y/x));
					break;
				default:
					break;
				}
			}
		}
		result = Integer.valueOf(stack.pop());
		return result;
	}
	
}
