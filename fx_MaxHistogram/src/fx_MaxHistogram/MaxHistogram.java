package fx_MaxHistogram;

import java.util.Stack;

public class MaxHistogram {

	public static void main(String[] args) {
		MaxHistogram mh = new MaxHistogram();
		int [] A = {2,2,2,6,1,5,4,2,2,2,2};
		
		System.out.println("max area: " + mh.maxHistogramArea(A));
	}
	
	public int maxHistogramArea(int [] A) {
		Stack<Integer> stack = new Stack<Integer>();
		
		int maxArea = 0;
		int top = 0;
		int area = 0;
		int i = 0;
		while (!stack.isEmpty() || i<A.length ) {
			if (stack.isEmpty() || (i < A.length && A[stack.peek()] <= A[i])) {
				stack.push(i++);
			} else {
				top = stack.pop();
				if (stack.isEmpty()) {
					area = A[top]*i;
				} else {
					area = A[top] * (i - stack.peek() - 1);
				}
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		
//		while (!stack.isEmpty()) {
//			top = stack.pop();
//			if (stack.isEmpty()) {
//				area = A[top]* i;
//			} else {
//				area = A[top] * (i - stack.peek() - 1);
//			}
//			if (area > maxArea) {
//				maxArea = area;
//			}
//		}
		
		return maxArea;
	}
}
