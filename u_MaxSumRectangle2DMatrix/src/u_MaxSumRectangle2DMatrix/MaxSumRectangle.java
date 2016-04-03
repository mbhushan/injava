package u_MaxSumRectangle2DMatrix;

import javax.swing.text.MaskFormatter;

/*
 Dynamic Programming | Set 27 (Maximum sum rectangle in a 2D matrix)
Given a 2D array, find the maximum sum subarray in it. For example, in the following 2D array, 
the maximum sum subarray is highlighted with blue rectangle and sum of this subarray is 29.
{1, 2, -1, -4, -20},
{-8, -3, 4, 2, 1},
{3, 8, 10, 1, 3},
{-4, -1, 1, 7, -6}
 */
public class MaxSumRectangle {

	public static void main(String [] args) {
		int [][] M = {
				{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
		};
		
		MaxSumRectangle MSR = new MaxSumRectangle();
		Result result = MSR.findMaxSum(M);
		System.out.println(result.toString());
	}
	
	public  Result findMaxSum(int [][] M) {
		int rows = M.length;
		int cols = M[0].length;
		int [] temp = new int[rows];
		Result result = new Result();
		
		for (int left=0; left<cols; left++) {
			for (int i=0; i<rows; i++) {
				temp[i] = 0;
			}
			for (int right=left; right<cols; right++) {
				for (int i=0; i<rows; i++) {
					temp[i] += M[i][right];
				}
				KadaneResult KR = kadane(temp);
				if (KR.maxSum > result.maxSum) {
					result.maxSum = KR.maxSum;
					result.leftBound = left;
					result.rightBound = right;
					result.upBound = KR.start;
					result.lowBound = KR.end;
				}
			}
		}
		return result;
	}
	
	class Result {
		int maxSum;
		int leftBound;
		int rightBound;
		int upBound;
		int lowBound;
		
		@Override
		public String toString() {
			return "Result [maxSum=" + maxSum + ", leftBound=" + leftBound
                    + ", rightBound=" + rightBound + ", upBound=" + upBound
                    + ", lowBound=" + lowBound + "]";
		}
	}
	
	class KadaneResult {
		int maxSum;
		int start;
		int end;
		public KadaneResult (int maxSum, int start, int end) {
			this.maxSum = maxSum;
			this.start = start;
			this.end = end;
		}
	}
	 private  KadaneResult kadane(int [] A) {
		if (null == A) {
			return null;
		}
		int maxSoFar = 0;
		int maxEndingHere = 0;
		int startIndex = 0;
		int endIndex = 0;
		int start = 0;
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			maxEndingHere +=  A[i];
			if (maxEndingHere <= 0) {
				maxEndingHere = 0;
				start = i+1;
			}
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
				startIndex = start;
				endIndex = i;
			}
		}
		//System.out.println("start index: " + startIndex);
		//System.out.println("end index: " + endIndex);
		
		return new KadaneResult(maxSoFar, startIndex, endIndex);
	}
}
