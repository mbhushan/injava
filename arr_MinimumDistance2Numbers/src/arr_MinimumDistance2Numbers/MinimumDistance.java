package arr_MinimumDistance2Numbers;
/*
Find the minimum distance between two numbers
Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[]. The array might also contain duplicates. You may assume that both x and y are different and present in arr[].

Examples:
Input: arr[] = {1, 2}, x = 1, y = 2
Output: Minimum distance between 1 and 2 is 1.

Input: arr[] = {3, 4, 5}, x = 3, y = 5
Output: Minimum distance between 3 and 5 is 2.

Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6
Output: Minimum distance between 3 and 6 is 4.

Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2
Output: Minimum distance between 3 and 2 is 1.
*/
public class MinimumDistance {

	public static void main(String[] args) {
		MinimumDistance md = new MinimumDistance();
		
		int [][] A= {
				{1, 2},
				{3, 4, 5},
				{3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3},
				{2, 5, 3, 5, 4, 4, 2, 3}
		};
		
		int [] x = {1, 3, 3, 3};
		int [] y = {2, 5, 6, 2};
		
		for (int i=0; i<A.length; i++) {
			System.out.println("min dist: " + md.minDistance(A[i], x[i], y[i]));
		}
		
	}
	
	public int minDistance(int [] A, int x, int y) {
		int i = 0;
		int minDist = Integer.MAX_VALUE;
		int prev = 0;
		
		for (; i<A.length; i++) {
			if (A[i] == x || A[i] == y) {
				prev = i;
				break;
			}
		}
		for (; i<A.length; i++) {
			if (A[i] == x || A[i] == y) { 
				if (A[i] != A[prev] && (i-prev) < minDist) {
					minDist = i-prev;
				} 
				prev = i;
			}
		}
		
		return minDist;
	}
}
