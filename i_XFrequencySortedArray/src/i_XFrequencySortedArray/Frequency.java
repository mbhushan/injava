package i_XFrequencySortedArray;

public class Frequency {

	
	public static void main(String[] args) {
		int [] A = {1,2,3,3,3,3,3,4,4,5 };
		
		int key = 3;
		
		System.out.println("frequency of " + key + ": " + getFrequency(A, key));
		
	}
	
	public static int getFrequency(int [] A, int key) {
		int first = -1;
		int last = -1;
		int len = A.length;
		
		first = firstIndex(A, key, 0, len-1);
		
		if (first == -1) {
			return first;
		}
		
		last = lastIndex(A, key, first, len-1);
		System.out.println("first: " + first);
		System.out.println("last: " + last);
		
		return (last - first + 1);
	}
	
	private static int lastIndex(int [] A, int key, int low, int high) {
		if (high >= low) {
			int mid = low + (high - low)/2;
			if ((mid == A.length-1 || key < A[mid+1]) && A[mid] == key) {
				return mid;
			} else if (key <  A[mid]) {
				return lastIndex(A, key, low, mid-1);
			} else {
				return lastIndex(A, key, mid+1, high);
			}
		}
		return -1;
	}
	
	private static int firstIndex(int [] A, int key, int low, int high) {
		if (high >= low) {
			int mid = low + (high - low)/2;
			if ((mid == 0 || key > A[mid-1]) && A[mid] == key) {
				return mid;
			} else if (key >  A[mid]) {
				return firstIndex(A, key, mid+1, high);
			} else {
				return firstIndex(A, key, low, mid-1);
			}
		}
		return -1;
	}
}
