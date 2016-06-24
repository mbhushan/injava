package in_LongestIncreasingSubsequence;

/*
Given an array find longest increasing subsequence in this array.
*/

public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int [] A = {3, 4, -1, 0, 6, 2, 3};
		System.out.println("lis: " + lis.longestIncreasingSubsequence(A));
		
	}
	
	public int longestIncreasingSubsequence(int [] A) {
		int result = 0;
		if (A == null || A.length < 1) {
			return 0;
		}
		
		int [] T = new int[A.length];
		for (int i=0; i<T.length; i++) {
			T[i] = 1;
		}
		
		for (int i=1; i<A.length; i++) {
			for (int j=0; j<i; j++) {
				if (A[j] < A[i]) {
					T[i] = Math.max(T[i], T[j] + 1);
				}
			}
		}
		
		for (int x : T) {
			if (x > result) {
				result = x;
			}
		}
		return result;
	}
}
