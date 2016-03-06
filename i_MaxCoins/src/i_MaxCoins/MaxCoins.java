package i_MaxCoins;

import java.util.ArrayList;
import java.util.Collections;

public class MaxCoins {
	
	private static int[][] memo;
	
	public static void main(String[] args) {
		Integer [] C = {3, 2, 2, 3, 1, 2};
		ArrayList<Integer> a = new ArrayList<Integer>();
		Collections.addAll(a, C);
		
		System.out.println("max coin: " + maxcoin(a));
	}

	 public static int maxcoin(ArrayList<Integer> a) {
	        int size = a.size();
	        memo = new int[size][size];
	        for (int i = 0; i < memo.length; i++) {
	            for (int j = 0; j < memo.length; j++) {
	                memo[i][j] = -1;
	            }
	        }
	        return maxcoin(0, size - 1, a);
	    }
	    
	    private static int maxcoin(int start, int end, ArrayList<Integer> a) {
	        if (start > end) {
	            return 0;
	        } else if (start == end) {
	            return a.get(start);
	        } else if (memo[start][end] != -1) {
	            return memo[start][end]; 
	        }
	        
	        int min1 = a.get(start) + Math.min(maxcoin(start + 2, end, a), maxcoin(start + 1, end - 1, a));
	        int min2 = a.get(end) + Math.min(maxcoin(start + 1, end - 1, a), maxcoin(start, end - 2, a));
	        int max = Math.max(min1, min2);
	        memo[start][end] = max;
	        return max;
	    }
}
