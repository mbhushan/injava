package arr_MaxProductSubarray;

/*
Maximum Product Subarray
Given an array that contains both positive and negative integers, find the product of the maximum product subarray. Expected Time complexity is O(n) and only O(1) extra space can be used.

Examples:

Input: arr[] = {6, -3, -10, 0, 2}
Output:   180  // The subarray is {6, -3, -10}

Input: arr[] = {-1, -3, -10, 0, 60}
Output:   60  // The subarray is {60}

Input: arr[] = {-2, -3, 0, -2, -40}
Output:   80  // The subarray is {-2, -40}
 */
public class MaxProductSubarray {

	public static void main(String[] args) {
		MaxProductSubarray mps = new MaxProductSubarray();
		
		int [][] A = {
				{6, -3, -10, 0, 2},
				{-1, -3, -10, 0, 60},
				{-2, -3, 0, -2, -40}
		};
		for (int i=0; i<A.length; i++) {
			System.out.println("max product: " + mps.maxProductSubarray(A[i]));
		}
		
	}
	
	public long maxProductSubarray(int [] A) {
		if (A == null || A.length < 1) {
			return 0;
		}
		
		long maxEndingHere = 1;
		long minEndingHere = 1;
		long maxSoFar = 1;
		
		for (int i=0; i<A.length; i++) {
			
			if (A[i] > 0) {
				maxEndingHere = A[i]*maxEndingHere;
				minEndingHere = Math.min(A[i]*minEndingHere, 1);
			} else if (A[i] == 0) {
				maxEndingHere = 1;
				minEndingHere = 1;
			} else {
				long temp = maxEndingHere;
				maxEndingHere = Math.max(A[i]*minEndingHere, maxEndingHere);
				//maxEndingHere = Math.max(Math.max(A[i]*minEndingHere, maxEndingHere), 1);
				minEndingHere = temp * A[i];
			}
			
			if (maxEndingHere > maxSoFar) {
				maxSoFar = maxEndingHere;
			}
		}
		return maxSoFar;
	}
	
}
