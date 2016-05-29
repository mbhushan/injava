package arr_SearchElementPivotedArray;

/*
Search an element in a sorted and rotated array
An element in a sorted array can be found in O(log n) time via binary search. 
But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. 
So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.
 */
public class SortedRotated {

	public static void main(String[] args) {
		int [] A = {4, 5, 6, 7, 8, 9, 1, 2, 3};
		int key = 6;
		
		System.out.println("search index: " + new SortedRotated().search(A, 0, A.length-1, key));
	}
	
	public int search(int [] A, int low, int high, int key) {
		if (low > high) {
			return -1;
		}
		int mid = low + (high - low)/2;
		if (A[mid] == key) {
			return mid;
		}
		
		if (A[low] <= A[mid]) {
			if (key >= A[low] && key <= A[mid-1]) {
				return search(A, low, mid-1, key);
			}
			return search(A, mid+1, high, key);
		}
		
		if (key >= A[mid+1] && key <= A[high]) {
			return search(A, mid+1, high, key);
		}
		
		return search(A, low, mid-1, key);
	}
}
