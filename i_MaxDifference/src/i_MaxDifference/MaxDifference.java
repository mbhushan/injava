package i_MaxDifference;

/**
 * 
Given an array arr[], find the maximum j – i such that arr[j] > arr[i].

Examples:

  Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  Output: 6  (j = 7, i = 1)

  Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
  Output: 8 ( j = 8, i = 0)

  Input:  {1, 2, 3, 4, 5, 6}
  Output: 5  (j = 5, i = 0)

  Input:  {6, 5, 4, 3, 2, 1}
  Output: -1 
 *
 */
public class MaxDifference {

	public static void main(String[] args) {
		int [] A = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
		System.out.println("max difference: " + maxIndexDiff(A));
		System.out.println("max difference optimized: " + maxIndexDifference(A));
	}
	
	//Time Complexity: O(n)
	//Auxiliary Space: O(n)
	public static int maxIndexDifference(int [] A) {
		int maxDiff = -1;
		int len = A.length;
		
		int [] left = new int[len];
		int [] right = new int[len];
		
		left[0] = A[0];
		for (int i=1; i<len; i++) {
			left[i] = Math.min(A[i], left[i-1]);
		}
		
		right[len-1] = A[len-1];
		for (int i=len-2; i>=0; i--) {
			right[i] = Math.max(A[i], right[i+1]);
		}
		
		int i = 0, j = 0;
		while ((i < len) && (j < len)) {
			if (left[i] < right[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				++j;
			} else {
				++i;
			}
		}
		
		return maxDiff;
	}
	
	//Time Complexity: O(n^2)
	public static int maxIndexDiff(int [] A) {
		int maxDiff = -1;
		
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			for (int j=len-1; j>i; --j) {
				if ((A[j] > A[i]) && ((j-i) > maxDiff)) {
					maxDiff = j - i;
				}
			}
		}
		return maxDiff;
	}
	
}
