package rec_BracketMusings;

import java.util.Stack;

public class BracketMusings {

	public static void main(String[] args) {
		int n = 3;
		BracketMusings BM = new BracketMusings();
		char[] result = new char[n * 2];
		BM.bracketPermutations(result, n, 0, 0, 0);

		String [] brackets = { "[({()}{}[])]", "([)", "[][])(", "[[[(){}]]]" };
		for (int i=0; i<brackets.length; i++) {
			System.out.println("are brackets matching: " + BM.matchingBrackets(brackets[i]));
		}
	}

	public boolean matchingBrackets(String brackets) {
		Stack<Character> stack = new Stack<Character>();
		
		for (Character ch: brackets.toCharArray()) {
			char checkChar = getOpeningChar(ch);
			if (checkChar == 0) {
				stack.add(ch);
			} else {
				if (stack.isEmpty() || stack.peek() != checkChar) {
					return false;
				}
				stack.pop();
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}

	private char getOpeningChar(char ch) {
		switch (ch) {
		case ')':
			return '(';
		case ']':
			return '[';
		case '}':
			return '{';
		default:
			return 0;
		}
	}

	public void bracketPermutations(char[] result, int n, int pos,
			int leftIndex, int rightIndex) {
		if (pos == 2 * n) {
			printArray(result);
			return;
		}
		if (leftIndex < n) {
			result[pos] = '(';
			bracketPermutations(result, n, pos + 1, leftIndex + 1, rightIndex);
		}
		if (rightIndex < leftIndex) {
			result[pos] = ')';
			bracketPermutations(result, n, pos + 1, leftIndex, rightIndex + 1);
		}
	}

	private void printArray(char[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
}
