package arr_IncreasingDecreasingSlopePoint;

/*
Find the maximum element in an array which is first increasing and then decreasing
Given an array of integers which is initially increasing and then decreasing, find the maximum value in the array.

Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}
Output: 500

Input: arr[] = {1, 3, 50, 10, 9, 7, 6}
Output: 50

Corner case (No decreasing part)
Input: arr[] = {10, 20, 30, 40, 50}
Output: 50

Corner case (No increasing part)
Input: arr[] = {120, 100, 80, 20, 0}
Output: 120
*/

public class MaximumPeak {

	public static void main(String[] args) {
		MaximumPeak mp = new MaximumPeak();
		
		int [][] A = {
				{8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1},
				{1, 3, 50, 10, 9, 7, 6},
				{10, 20, 30, 40, 50},
				{120, 100, 80, 20, 0}
		};
		
		for (int i=0; i<A.length; i++) {
			System.out.println("max point: " + mp.findMaxPoint(A[i]));
		}
	}
	
	public int findMaxPoint(int [] A) {
		if (A == null || A.length < 1) {
			return -1;
		}
		
		return findMaxPoint(A, 0, A.length-1);
	}
	
	private int findMaxPoint(int [] A, int low, int high) {
		if (low == high) {
			return A[low];
		}
		
		if ((high == low+1) && (A[low] >= A[high])) {
			return A[low];
		}
		
		if ((high == low+1) && (A[high] > A[low])) {
			return A[high];
		}
		
		int mid = low + (high - low)/2;
		
		if ((A[mid] > A[mid+1]) && (A[mid] > A[mid-1])) {
			return A[mid];
		}
		
		if (A[mid] > A[mid+1] && A[mid] < A[mid-1]) {
			return findMaxPoint(A, low, mid-1);
		} else {
			return findMaxPoint(A, mid+1, high);
		}
	}
	
	
}
