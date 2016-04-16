package str_RotateArray;
/*
 * Problem: Rotate an array of n elements to the right by k steps. For example, with n = 7 and k = 3, 
 * the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. 
 * How many different ways do you know to solve this problem?
 */
public class RotateArray {

/*
* Reversal
Can we do this in O(1) space and in O(n) time? The following solution does.
Assuming we are given {1,2,3,4,5,6} and order 2. The basic idea is:
1. Divide the array two parts: 1,2,3,4 and 5, 6
2. Reverse first part: 4,3,2,1,5,6
3. Reverse second part: 4,3,2,1,6,5
4. Reverse the whole array: 5,6,1,2,3,4
*/
	
	public void rotate(int [] A, int K) {
		if (A == null || K < 0 || A.length == 0) {
			throw new IllegalArgumentException("Illegal Arguments!");
		}
		if (K > A.length) {
			K = K % A.length;
		}
		int first = A.length - K;
		reverse(A, 0, first-1);
		reverse(A, first, A.length-1);
		reverse(A, 0, A.length-1);
	}
	
	private void reverse(int [] A, int start, int end) {
		if (A == null || A.length == 1) {
			return;
		}
		while (start < end) {
			int temp = A[start];
			A[start] = A[end];
			A[end] = temp;
			++start;
			--end;
		}
	}
	
	
	
	//Bubble Rotate - time complexity: O(N*K)
	public void rotateArray(int [] A, int K) {
		if (A == null || K <= 0 ) {
			return;
		}
		
		int len = A.length;
		for (int i=0; i<K; i++) {
			for (int j=len-1; j > 0; j--) {
				int temp = A[j];
				A[j] = A[j-1];
				A[j-1] = temp;
			}
		}
	}
	
	public static void main(String [] args) {
		RotateArray RA = new RotateArray();

		int [] A = {1,2,3,4,5,6};
		int [] B = {1,2,3,4,5,6};
		int K = 2;
		
		RA.rotateArray(A, K);
		for (int n : A) {
			System.out.print(n + " ");
		}
		System.out.println();
		RA.rotate(B, K);
		for (int n : B) {
			System.out.print(n + " ");
		}
	}
}
