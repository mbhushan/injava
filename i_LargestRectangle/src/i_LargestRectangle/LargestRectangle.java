package i_LargestRectangle;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangle {
	
	public static void main(String[] args) {
		int [] A = {2,1,5,6,2,3};
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		int ans = largestRectangleArea(X);
		System.out.println("max area: " + ans);
	}

	public static int largestRectangleArea(ArrayList<Integer> height) {
		if (height == null || height.size() == 0) {
			return 0;
		}
	 
		Stack<Integer> stack = new Stack<Integer>();
	 
		int max = 0;
		int i = 0;
		int size = height.size();
	 
		while (i < size) {
			//push index to stack when the current height is larger than the previous one
			if (stack.isEmpty() || height.get(i).intValue() >= height.get(stack.peek())) {
				stack.push(i);
				i++;
			} else {
			//calculate max value when the current height is less than the previous one
				int p = stack.pop();
				int h = height.get(p).intValue();
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}
	 
		}
	 
		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height.get(p).intValue();
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}
	 
		return max;
	}
}
