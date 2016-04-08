package u_MaxRectangleHistogram;

import java.util.Stack;

public class Histogram {

	public int getLargestRectangleInHistogram(int [] histogram) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = Integer.MIN_VALUE;
		int area = 0;
		
		int index = 0;
		int len  = histogram.length;
		int tp = 0; //top of the stack index;
		while (index < len) {
			if (stack.isEmpty() || histogram[stack.peek()] <= histogram[index]) {
				stack.push(index++);
			} else {
				tp = stack.pop();
				area = histogram[tp] * ( stack.isEmpty() ? index: index - stack.peek() - 1);
				
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		
		while (!stack.isEmpty()) {
			tp = stack.pop();
			area = histogram[tp] * ( stack.isEmpty() ? index: index - stack.peek() - 1);
			
			if (area > maxArea) {
				maxArea = area;
			}
		}
		
		return maxArea;
	}
}
