package i_LongestConsecutive;

import java.util.HashSet;

public class LongestConsecutive {

	
	public static void main(String[] args) {
		int [][] A = {
				{36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42},
				{1, 9, 3, 10, 4, 20, 2}
		};
		
		for (int i=0; i<A.length; i++) {
			System.out.println("longest consecutive elements: " + longestConsecutive(A[i]));
		}
	}
	
	public static int longestConsecutive(int [] A) {
		int ans = 1;
		HashSet<Integer> hset = new HashSet<Integer>();
		
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			hset.add(A[i]);
		}
		
		for (int i=0; i<len; i++) {
			if (!hset.contains(A[i]-1)) {
				//A[i] is the starting element
				int j = A[i];
				while (hset.contains(j)) {
					++j;
				}
				if (ans < (j - A[i])) {
					ans = j - A[i];
				}
			}
		}
		
		return ans;
	}
}
