package i_MinPathSumGrid;

import java.util.ArrayList;
import java.util.Collections;

public class MinPath {

	public static void main(String[] args) {
		Integer [] a = {1, 3, 2};
		Integer [] b = {4, 3, 1};
		Integer [] c = {5, 6, 1};
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		ArrayList<Integer> C = new ArrayList<Integer>();
		
		Collections.addAll(A, a);
		Collections.addAll(B, b);
		Collections.addAll(C, c);
		
		ArrayList<ArrayList<Integer>> X = new ArrayList<ArrayList<Integer>>();
		X.add(A);
		X.add(B);
		X.add(C);
		
		System.out.println("min path: " + minPathSum(X));
	}
	public static int minPathSum(ArrayList<ArrayList<Integer>> a) {
		int rw = a.size();
		int col = a.get(0).size();
		
		int[][] sum = new int[rw][2];
		int[][] grid = new int[rw][col];
		
		for (int i=0; i<rw; i++) {
			for (int j=0; j<col; j++) {
				grid[i][j] = a.get(i).get(j).intValue();
			}
		}
		
		sum[0][0] = grid[0][0];  
		   // initialized the first row  
		   int row = 0;  
		   for (int j=1; j<grid.length; ++j) {  
		     sum[j][row] = grid[j][0] + sum[j-1][row];  
		   }  
		   // fill up the rest of table  
		   for (int i=1; i<grid[0].length; ++i) {  
		     // switch the two rows  
		     row = 1 - row;  
		     // initialize the first element in the row  
		     sum[0][row] = grid[0][i] + sum[0][1-row];  
		     for (int j=1; j<grid.length; ++j) {  
		       sum[j][row] = Math.min(sum[j-1][row], sum[j][1-row]);  
		       sum[j][row] += grid[j][i];  
		     }  
		   }  
		   
		   return sum[grid.length-1][row];  
	}
}
