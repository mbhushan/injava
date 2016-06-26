package in_MaxPalindromicSubsequence;

import java.util.Arrays;

/*
Find the length of a maximum palindrome subset in an array. For example: in 1, 2, 4, 1 the maximum 
palindrome subset is 1, 2, 1 and the answer is 3
*/

public class MaxPalindromicSubsequence {

	public static void main(String[] args) {
		MaxPalindromicSubsequence mp = new MaxPalindromicSubsequence();
		
		int [][] A = {
				{1, 2, 4, 1},
				{1, 5, 3, 7, 3, 1}
		};
		
		for (int i=0; i<A.length; i++) {
			System.out.println(Arrays.toString(A[i]));
			System.out.println("max palindromic subsequence: " + mp.maxPalindromicSubsequence(A[i]));
		}
	}
	
	public int maxPalindromicSubsequence(int [] A) {
		if (A == null || A.length < 1) {
			return 0;
		}
		int [][] dp = new int[A.length][A.length];
		
		for (int i=0; i<A.length; i++) {
			dp[i][i] = 1;
		}
		
		for (int len=2; len<=A.length; len++) {
			for (int i=0; i<=A.length-len; i++) {
				int j = i + len -1;
				if (A[i] == A[j]) {
					dp[i][j] = Math.max(dp[i][j], 2 + dp[i+1][j-1]);
				} else {
					dp[i][j] = Math.max(dp[i][j], dp[i+1][j]);
					dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
				}
			}
		}
		return dp[0][A.length-1];
	}
}
