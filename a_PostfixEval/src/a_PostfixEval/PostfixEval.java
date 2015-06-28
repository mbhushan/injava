package a_PostfixEval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixEval {

	public static void main(String [] args) {
		
		System.out.println("Enter postfix expression, tokens separated by space");
		String expression = readInput();
		String [] tokens = expression.split(" ");
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=0; i<tokens.length; i++) {
			String tok = tokens[i];
			if (tok.equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (tok.equals("*")) {
				stack.push(stack.pop() * stack.pop());
			} else if (tok.equals("-")) {
				stack.push(stack.pop() - stack.pop());
			} else if (tok.equals("/")) {
				// divide by zero case not handled.
				stack.push(stack.pop() / stack.pop());
			} else {
				// assumes integer token.
				Integer num = Integer.parseInt(tok);
				stack.push(num);
			}
		}
		System.out.println("Result: " + stack.pop());
	}
	
	public static String readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String expression  = null;
		try {
			expression = br.readLine().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return expression;
	}
}
