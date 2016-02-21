package i_AdjacentNumberSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AdjacentNums {
	
	private static int [] dp ;//= new int[100000];
	
	public static void main(String[] args) {
		Integer [] A = {1, 2, 3, 4};
		Integer [] B = {2, 3, 4, 5};
		
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> X = new ArrayList<Integer>();
		ArrayList<Integer> Y = new ArrayList<Integer>();
		Collections.addAll(X, A);
		Collections.addAll(Y, B);
		a.add(X);
		a.add(Y);
		
		
		System.out.println("ans: " + adjacent(a));
	}
	
	public static int adjacent(ArrayList<ArrayList<Integer>> a) {
	    int[] mem = new int[a.get(0).size()];
	    
	    
	   mem[0] = Math.max(a.get(0).get(0), a.get(1).get(0));
	   
	   if(mem.length == 1)
	        return mem[0];
	   
		mem[1] = Math.max(a.get(0).get(1), a.get(1).get(1));
		mem[1] = Math.max(mem[0],mem[1]);
		if(mem.length == 2)
		    return Math.max(mem[0],mem[1]);
	
		for(int i=2; i<a.get(0).size(); i++)
		{
			mem[i] = 0;
			int with = Math.max(a.get(0).get(i), a.get(1).get(i)) + mem[i-2];
			int without = mem[i-1];
			mem[i] = Math.max(mem[i], Math.max(with, without));
		}
		return mem[mem.length-1];
	}

	public static int adjacent1(ArrayList<ArrayList<Integer>> a) {
		
		int row = a.size();
		int col = a.get(0).size();
		int [][] arr = new int[row][col];
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				arr[i][j] = a.get(i).get(j).intValue();
			}
		}
		
		dp = new int[col];
		Arrays.fill(dp, -1);

		int ans = getmaxsum(arr, col-1);
		return ans;

	}
	
	public static int  getmaxsum(int arr[][], int c) {
	     
	    if(c < 0) return 0;
	     
	    if(dp[c] != -1) return dp[c];
	     
	    return dp[c] = Math.max(Math.max(arr[0][c], arr[1][c]) + getmaxsum(arr, c-2), getmaxsum(arr, c-1));
	}
}
