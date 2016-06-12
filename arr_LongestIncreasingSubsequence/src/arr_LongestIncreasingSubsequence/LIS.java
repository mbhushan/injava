package arr_LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Collections;

/*
The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence 
such that all elements of the subsequence are sorted in increasing order. For example, 
length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
*/

public class LIS {

	public static void main(String[] args) {
		LIS obj = new LIS();
		
		int [] A = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		obj.longestIncreasingSubsequence(A);
	}
	
	public ArrayList<Integer> longestIncreasingSubsequence(int [] A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if (A == null || A.length < 1) {
			return result;
		}
		if (A.length == 1) {
			result.add(A[0]);
			return result;
		}
		
		int [] lis = new int[A.length];
		int [] parent = new int[A.length];
		for (int i=0; i<A.length; i++) {
			parent[i] = -1;
		}
		
		for (int i=1; i<A.length; i++) {
			for (int j=0; j<i; j++) {
				if (A[j] < A[i] && lis[j]+1 > lis[i]) {
					lis[i] = lis[j] + 1;
					parent[i] = j;
				}
			}
		}
		
		int max = 1;
		int index = 0;
		for (int i=0; i<lis.length; i++) {
			if (lis[i] > max) {
				max = lis[i];
				index = i;
			}
		}
		
		System.out.println("max sequence length: " + max);
		while (index != -1) {
			System.out.print(A[index] + " ");
			result.add(A[index]);
			index = parent[index];
		}
		System.out.println();
		Collections.reverse(result);
		return result;
	}
}
