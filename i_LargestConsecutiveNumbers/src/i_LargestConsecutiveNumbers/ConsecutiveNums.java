package i_LargestConsecutiveNumbers;

import java.util.HashSet;

public class ConsecutiveNums {

	public static void main(String[] args) {
		int A[] =  {1, 9, 3, 10, 4, 20, 2};
		
		System.out.println("largest consecutive subsequence: " + largestConsecSubseq(A));
		
	}
	
	public static int largestConsecSubseq(int [] A) {
		int len = A.length;
		
		HashSet<Integer> set = new HashSet<Integer>();
		int ans = Integer.MIN_VALUE; 
		
		for (Integer n: A) {
			set.add(n);
		}
		
		for (int i=0; i<len; i++) {
			
			// first element
			if (!set.contains(A[i]-1)) {
				int j = A[i];
				
				while (set.contains(j)) {
					++j;
				}
				
				if (j - A[i] > ans) {
					ans = j - A[i];
				}
				
			}
		}
		return ans;
	}
}
