package i_RedundantBraces;

import java.util.Stack;

public class Braces {

	public static void main(String[] args) {
		String[] st = { "(a+(a+b))", "(a)", "(a+b)" };
		for (int i = 0; i < st.length; i++) {
			System.out.println("input: " + st[i]);
			System.out.println("extra braces: " + braces(st[i]));
		}
	}

	public static int braces(String a) {
		int len = a.length();
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < len; i++) {
			char ch = a.charAt(i);

			if (ch == ')') {
				int count = 0;
				while ((char) stack.peek() != '(') {
					stack.pop();
					++count;
				}
				stack.pop();
				if (count < 2) {
					return 1;
				}

			} else {
				stack.push(ch);
			}
		}
		if (!stack.isEmpty() && stack.peek() == ')') {
			return 1;
		}
		return 0;
	}

}
