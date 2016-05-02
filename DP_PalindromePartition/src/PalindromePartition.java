 /*
* Given a string s, partition s such that every substring of the partition is a palindrome.
* Return the minimum cuts needed for a palindrome partitioning of s.
* https://leetcode.com/problems/palindrome-partitioning-ii/
*/

public class PalindromePartition {
	
	public static void main(String [] args) {
		PalindromePartition PP = new PalindromePartition();
		String string = "abcbm";
		int minCut = PP.palindromePartitionMinCut(string);
		System.out.println("min cut: " + minCut);
	}

	public int palindromePartitionMinCut(String string) {
		if (string == null) {
			return 0;
		}
		
		int len = string.length();
		
		if (len < 1) {
			return 0;
		}
		
		int [][] T = new int[len][len];
		// zero splits required for individual character strings.
		for (int i=0; i<len; i++) {
			T[i][i] = 0;
		}
		
		for (int l=1; l<=len; l++) {
			for (int i=0; i<len - (l-1);i++) {
				int j = i + (l-1);
				if (isPalindrome(string, i, j)) {
					T[i][j] = 0;
					continue;
				}
				int min = Integer.MAX_VALUE;
				for (int k=i+1; k<=j; k++) {
					min = Math.min(min, Math.min(T[i][k-1], T[k][j]));
				}
				T[i][j] = 1 + min;
			}
		}
		
		
		return T[0][len-1];
	}
	
	
	
	 private  boolean isPalindrome(String str, int r, int t) {
	        while(r < t) {
	            if (str.charAt(r) != str.charAt(t)) {
	                return false;
	            }
	            r++;
	            t--;
	        }
	        return true;
	    }
	
}
