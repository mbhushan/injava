package in_TriangleTriplets;

import java.util.Arrays;

/*
Given a set of numbers find if a triplet can form a triangle a+b > c , b+c > a and c+a > b. 
The result to display all possible combinations of triplets. [ 10 5 3 4 7 1] [5,3,4 ] is 
one possible triplet and there can be many more.

**********algorithm which takes O(n^2) time in worst case:

Sort numbers (ascending order). We will take triples ai <= aj <= ak, such that i <= j <= k.
For each i, j you need to find largest k that satisfy ak <= ai + aj. Then all triples (ai,aj,al) j <= l <= k is triangle 
(because ak >= aj >= ai we can only violate ak < a i+ aj).

Consider two pairs (i, j1) and (i, j2) j1 <= j2. It's easy to see that k2 (found on step 2 for (i, j2)) >= k1 (found one step 2 for (i, j1)). 
It means that if you iterate for j, and you only need to check numbers starting from previous k. 
So it gives you O(n) time complexity for each particular i, which implies O(n^2) for whole algorithm.
*/

public class TriangleTriplets {
	
	public static void main(String[] args) {
		TriangleTriplets tt = new TriangleTriplets();
		
		int [] A = {10, 21, 22, 100, 101, 200, 300};
		System.out.println("total triangle triplets: " + tt.numOfTriangleTriplets(A));
		
	}
	
	public int numOfTriangleTriplets(int [] A) {
		if (A == null || A.length < 3) {
			return 0;
		}
		int result = 0;
		
		Arrays.sort(A);
		
		for (int i=0; i<A.length-2; i++) {
			int k = i+2;
			
			for (int j=i+1; j < A.length; j++) {
				while (k < A.length && (A[i] + A[j] > A[k])) {
					++k;
				}
				result += (k - j - 1);
			}
		}
		
		return result;
	}
}
