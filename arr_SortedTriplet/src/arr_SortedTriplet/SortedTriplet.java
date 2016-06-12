package arr_SortedTriplet;

/*
 Find a sorted subsequence of size 3 in linear time
 Given an array of n integers, find the 3 elements such that a[i] < a[j] < a[k] and i < j < k in 0(n) time. 
 If there are multiple such triplets, then print any one of them.

 Examples:

 Input:  arr[] = {12, 11, 10, 5, 6, 2, 30}
 Output: 5, 6, 30

 Input:  arr[] = {1, 2, 3, 4}
 Output: 1, 2, 3 OR 1, 2, 4 OR 2, 3, 4

 Input:  arr[] = {4, 3, 2, 1}
 Output: No such triplet
 */
public class SortedTriplet {

	public static void main(String[] args) {
		SortedTriplet st = new SortedTriplet();

		int[][] A = { 
				{ 12, 11, 10, 5, 6, 2, 30 }, 
				{ 1, 2, 3, 4 },
				{ 4, 3, 2, 1 } 
			};
		
		for (int i=0; i<A.length; i++) {
			st.sortedTriplet(A[i]);
		}

	}
	
	public void sortedTriplet(int [] A) {
		if (A == null || A.length < 3) {
			return;
		}
		
		int [] left = new int[A.length];
		int [] right = new int[A.length];
		
		left[0] = -1;
		right[A.length-1] = -1;
		int min = 0;
		int max = A.length - 1;
		
		for (int i=1; i<A.length; i++) {
			if (A[i] >= A[min]) {
				left[i] = min;
			} else {
				min = i;
				left[i] = -1;
			}
		}
		
		for (int i=A.length-2; i>=0; i--) {
			if (A[i] <= A[max]) {
				right[i] = max;
			} else {
				max = i;
				right[i] = -1;
			}
		}
		
		for (int i=0; i<A.length; i++) {
			if (left[i] != -1 && right[i] != -1) {
				System.out.println("sorted triplets are: " + A[left[i]] + ", " + A[i] + ", " + A[right[i]]);
				return;
			}
		}
		
		System.out.println("no sorted triplets found!");
	}
}
