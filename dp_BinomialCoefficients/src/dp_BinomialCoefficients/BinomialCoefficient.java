package dp_BinomialCoefficients;

/*
Following are common definition of Binomial Coefficients.
1) A binomial coefficient C(n, k) can be defined as the coefficient of X^k in the expansion of (1 + X)^n.

2) A binomial coefficient C(n, k) also gives the number of ways, disregarding order, that k objects can be chosen 
from among n objects; more formally, the number of k-element subsets (or k-combinations) of an n-element set.

The Problem
Write a function that takes two parameters n and k and returns the value of Binomial Coefficient C(n, k). 
For example, your function should return 6 for n = 4 and k = 2, and it should return 10 for n = 5 and k = 2.


Time Complexity: O(n*k)
Space Complexity: O(n*k)
*/
public class BinomialCoefficient {

	public static void main(String[] args) {
		BinomialCoefficient bc = new BinomialCoefficient();
		
		int n = 5;
		for (int k=0; k<=5; k++) {
			//System.out.println(bc.binomialCoeff(n, k));
			System.out.println(bc.binomialCoeffDP(n, k));
		}
	}
	
	public int binomialCoeffDP(int n, int k) {
		int [][] dp = new int[n+1][k+1];
		
		for (int i=0; i<=n; i++) {
			for (int j=0; j<=Math.min(i, k); j++) {
				if (j == 0 || j == i) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
		}
		return dp[n][k];
	}
	
	public int binomialCoeff(int n, int k) {
		if (k == 0 || k == n) {
			return 1;
		}
		
		return binomialCoeff(n-1, k-1) + binomialCoeff(n-1, k);
	}
}
