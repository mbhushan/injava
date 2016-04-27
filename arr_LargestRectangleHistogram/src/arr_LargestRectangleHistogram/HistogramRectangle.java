package arr_LargestRectangleHistogram;

import java.util.Stack;

public class HistogramRectangle {
	
	public static void main(String [] args) {
		HistogramRectangle HR = new HistogramRectangle();
//		System.out.println(HR.largestRectangleArea(new int[]{2,1,5,6,2,3}));
//		System.out.println(HR.largestRectangleArea(new int[]{2,1,0,6,2,3}));
//		System.out.println(HR.largestRectangleArea(new int[]{2,1,2,6,1,7,1,0,6,2,3}));

		System.out.println("largest rectangle in histogram with DP:");
		System.out.println(HR.largestAreaDP(new int[]{2,1,5,6,2,3}));
//		System.out.println(HR.largestAreaDP(new int[]{2,1,0,6,2,3}));
//		System.out.println(HR.largestAreaDP(new int[]{2,1,2,6,1,7,1,0,6,2,3}));
	}
	
	public  int largestAreaDP(int[] bar)   {
        //parameter check
        assert (bar != null && bar.length > 0);

        //initialization
        int[] maxLeft = new int[bar.length];
        int[] maxRight = new int[bar.length];
        maxLeft[0] = -1;
        maxRight[bar.length-1] = bar.length;

        int maxArea = -1;

        //calculate maxLeft
        for(int i = 1; i < bar.length; ++i) {
            int leftCur = i-1;
            while(leftCur >= 0) {
                if (bar[i] > bar[leftCur]) {
                    break;
                }
                else    {
                    leftCur = maxLeft[leftCur];
                }
            }
            maxLeft[i] = leftCur;
        }
        //calculate maxRight
        for(int i = bar.length-2; i >= 0; --i)  {
            int rightCur = i+1;
            while(rightCur < bar.length)    {
                if(bar[i] > bar[rightCur]) {
                    break;
                }
                else    {
                    rightCur = maxRight[rightCur];
                }
            }
            maxRight[i] = rightCur;
        }
        //find max
        for(int i = 0; i < bar.length; ++i) {
            int curSize = bar[i] * (maxRight[i]-maxLeft[i]-1);
            if(curSize > maxArea) maxArea = curSize;
        }

        return maxArea;
    }

	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
	 
		Stack<Integer> stack = new Stack<Integer>();
	 
		int max = 0;
		int i = 0;
	 
		while (i < height.length) {
			//push index to stack when the current height is larger than the previous one
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
			//calculate max value when the current height is less than the previous one
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}
	 
		}
	 
		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}
	 
		return max;
	}
}
