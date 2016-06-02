package arr_MaxDifference;

/*
Maximum difference between two elements such that larger element appears after the smaller number
Given an array arr[] of integers, find out the difference between any two elements such that larger 
element appears after the smaller number in arr[].

Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). 
If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)
*/
public class MaxDifference {

	public static void main(String[] args) {
		int [][] A = {
				{2, 3, 10, 6, 4, 8, 1},
				{7, 9, 5, 6, 3, 2 }
		};
		MaxDifference MD = new MaxDifference();
		for (int i=0; i<A.length; i++) {
			System.out.println("max difference: " + MD.maxDifference(A[i]));
		}
	}
	
	public int maxDifference(int [] A) {
		if (A == null || A.length <= 1) {
			return 0;
		}
		int len = A.length;
		int maxDiff = A[1] - A[0];
		int min = A[0];
		for (int i=1; i<len; i++) {
			if (A[i] - min > maxDiff) {
				maxDiff = A[i] - min;
			} 
			if (A[i] < min) {
				min = A[i];
			}
		}
		return maxDiff;
	}
}
