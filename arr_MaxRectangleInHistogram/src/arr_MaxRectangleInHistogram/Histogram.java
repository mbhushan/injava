package arr_MaxRectangleInHistogram;

import java.util.Stack;

public class Histogram {

	public static void main(String[] args) {
		Histogram hist = new Histogram();
		
		int [][] A = {
				{2,2,2,6,1,5,4,2,2,2,2},
				{2, 1, 2, 3, 1},
				{1, 2, 4}
		};
		
		for (int i=0; i<A.length; i++) {
			System.out.println("max area: " + hist.maxRectangleHistogram(A[i]));
		}
	}
	
	public int maxRectangleHistogram(int [] A) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int maxArea = 0;
		//stack.push(0);
		int i = 0;
		for (i=0; i < A.length; i++ ) {
			if (stack.isEmpty() || A[i] >= A[stack.peek()]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && A[i] < A[stack.peek()]) {
					int top = stack.pop();
					int len = A[top];
					int area = 0;
					if (stack.isEmpty()) {
						area = len * i;
					} else {
						area = len * (i - stack.peek()-1);
					}
					maxArea = Math.max(maxArea, area);
				}
				stack.push(i);
			}
		}
		
		while (!stack.isEmpty()) {
			int top = stack.pop();
			int len = A[top];
			int area = 0;
			if (stack.isEmpty()) {
				area = len * i;
			} else {
				area = len * (i - stack.peek()-1);
			}
			maxArea = Math.max(maxArea, area);
		}
		
		return maxArea;
	}
}
