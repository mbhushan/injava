package arr_LongestIncreasingSubsequenceSum;
/*
Dynamic Programming | Set 14 (Maximum Sum Increasing Subsequence)
Given an array of n positive integers. Write a program to find the sum of maximum sum subsequence 
of the given array such that the intgers in the subsequence are sorted in increasing order. 
For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100), 
if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and 
if the input array is {10, 5, 4, 3}, then output should be 10
 */
public class MaxSumIncreasingSubsequence {

	public static void main(String[] args) {
		MaxSumIncreasingSubsequence ms = new MaxSumIncreasingSubsequence();
		
		int [][] A = {
				{1, 101, 2, 3, 100, 4, 5},
				{3, 4, 5, 10},
				{10, 5, 4, 3}
		};
		
		for (int i=0; i<A.length; i++) {
			System.out.println("max subsequence increasing sum : " + ms.maxSumIS(A[i]));
		}
		
	}
	
	public int maxSumIS(int [] A) {
		if (A == null || A.length < 1) {
			return 0;
		}
		
		int [] dp = new int[A.length];
		for (int i=0; i<A.length; i++) {
			dp[i] = A[i];
		}
		
		for (int i=1; i<A.length; i++) {
			for (int j=0; j<i; j++) {
				if ((A[i] > A[j]) && (dp[j]+A[i] > dp[i])) {
					dp[i] = dp[j] + A[i];
				}
			}
		}
		
		int max = 0;
		for (int i=0; i<dp.length; i++) {
			if (max < dp[i]) {
				max = dp[i];
			}
		}
		
		return max;
	}
}
