package arr_FloorCeiling;

/*
Floor and Ceiling in a sorted array
Given a sorted array and a value x, the ceiling of x is the smallest element in array greater than or equal to x, and the floor is the greatest element smaller than or equal to x. Assume than the array is sorted in non-decreasing order. Write efficient functions to find floor and ceiling of x.

For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
For x = 0:    floor doesn't exist in array,  ceil  = 1
For x = 1:    floor  = 1,  ceil  = 1
For x = 5:    floor  = 2,  ceil  = 8
For x = 20:   floor  = 19,  ceil doesn't exist in array
In below methods, we have implemented only ceiling search functions. Floor search can be implemented in the same way.
*/
public class FloorCeil {

	public static void main(String[] args) {
		FloorCeil FC = new FloorCeil();
		int [] A = {1, 2, 8, 10, 10, 12, 19};
		int [] x = {3, 11, 17, 20};
		
		for (int i=0; i<x.length; i++) {
			int index = FC.findCeil(A, x[i]);
			if (index != -1) {
				System.out.println("ceil of " + x[i] + ": "+ A[index]);
			} else {
				System.out.println("ceil of " + x[i] + ": -1");
			}
		}
	}
	
	public int findCeil(int [] A, int x) {
		return ceilSearch(A, 0, A.length-1, x);
	}
	
	private int ceilSearch(int [] A, int low, int high, int x) {
		if (x <= A[low]) {
			return low;
		}
		
		if (x > A[high]) {
			return -1;
		}
		
		int mid = low + (high - low)/2;
		
		if (A[mid] == x) {
			return mid;
		}
		
		if (x > A[mid]) {
			if (x <= A[mid+1] && mid+1 <= high) {
				return mid+1;
			} else {
				return ceilSearch(A, mid+1, high, x);
			}
		} else {
			if (x > A[mid-1] && low <= mid-1) {
				return mid;
			} else {
				return ceilSearch(A, low, mid-1, x);
			}
		}
	}
}
