package arr_PairDifference;

import java.util.Arrays;

/*
Find a pair with the given difference
Given an unsorted array and a number n, find if there exists a pair of elements in the array whose difference is n.

Examples:
Input: arr[] = {5, 20, 3, 2, 50, 80}, n = 78
Output: Pair Found: (2, 80)

Input: arr[] = {90, 70, 20, 80, 50}, n = 45
Output: No Such Pair
 */
public class PairDifference {

	public static void main(String[] args) {
		PairDifference pd = new PairDifference();
		int [][] A= {
				{5, 20, 3, 2, 50, 80},
				{90, 70, 20, 80, 50},
		};
		int [] diffs = {78, 45};
		
		for (int i=0; i<A.length; i++) {
			pd.pairDifference(A[i], diffs[i]);
		}
		
		
	}
	
	public void pairDifference(int [] A, int k) {
		if (A == null || A.length < 2) {
			return ;
		}
		
		Arrays.sort(A);
		int i = 0;
		int j = 1;
		while (i < A.length && j < A.length) {
			if (i != j && (A[j] - A[i]) == k) {
				System.out.println("pair is: " + A[i] + ", " + A[j]);
				return;
			} else if ((A[j] - A[i]) < k) {
				++j;
			} else {
				++i;
			}
		}
		System.out.println("no pair found!");
	}
}
