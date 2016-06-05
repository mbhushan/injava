package arr_FixedPointArray;

/*
Find a Fixed Point in a given array
Given an array of n distinct integers sorted in ascending order, write a function that returns a Fixed Point in the array, if there is any Fixed Point present in array, else returns -1. Fixed Point in an array is an index i such that arr[i] is equal to i. Note that integers in array can be negative.

Examples:
  Input: arr[] = {-10, -5, 0, 3, 7}
  Output: 3  // arr[3] == 3 

  Input: arr[] = {0, 2, 5, 8, 17}
  Output: 0  // arr[0] == 0 

  Input: arr[] = {-10, -5, 3, 4, 7, 9}
  Output: -1  // No Fixed Point
*/
public class FixedPoint {

	public static void main(String[] args) {
		int [][] A = {
				{-10, -1, 0, 3, 10, 11, 30, 50, 100},
				{-10, -5, 3, 4, 7, 9},
				{0, 2, 5, 8, 17},
				{-10, -5, 0, 3, 7}
		};
		
		FixedPoint fp = new FixedPoint();
		
		for (int i=0; i<A.length; i++) {
			System.out.println("fixed point: " + fp.fixedPoint(A[i]));
		}
	}
	
	public int fixedPoint(int [] A) {
		return binarySearch(A, 0, A.length-1);
	}
	
	private int binarySearch(int [] A, int low, int high) {
		if (low <= high) {
			int mid = low + (high - low)/2;
			if (mid == A[mid]) {
				return mid;
			} else if (mid < A[mid]) {
				return binarySearch(A, low, mid-1);
			} else {
				return binarySearch(A, mid+1, high);
			}
		}
		return -1;
	}
}
