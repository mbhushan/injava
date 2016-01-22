package i_MinStack;

import java.util.Stack;

public class MinStack {
	
	public MinStack() {
		// TODO Auto-generated constructor stub
	}

	private static Stack<Integer> stack;
	private static Stack<Integer> minStack;

	public static void main(String[] args) {

		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int x) {
		if (stack.isEmpty() || (x <= minStack.peek())) {
			minStack.push(x);
		} else {
			minStack.push(minStack.peek());
		}
		stack.push(x);
	}

	public void pop() {
		if (stack.isEmpty()) {
			return;
		}
		if (stack.peek() == minStack.peek()) {
			minStack.pop();
		}
		stack.pop();

	}

	public int top() {
		if (stack.isEmpty()) {
			return -1;
		}
		return stack.peek();

	}

	public int getMin() {
		if (minStack.isEmpty()) {
			return -1;
		}
		return minStack.peek();

	}
}
