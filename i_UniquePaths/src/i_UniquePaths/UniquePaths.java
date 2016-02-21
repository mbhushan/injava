package i_UniquePaths;

import java.util.ArrayList;
import java.util.Collections;

public class UniquePaths {
	
	public static void main(String[] args) {
		Integer [] A = {0,0,0};
		Integer [] B = {0,1,0};
		Integer [] C = {0,0,0};
		
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> X = new ArrayList<Integer>();
		ArrayList<Integer> Y = new ArrayList<Integer>();
		ArrayList<Integer> Z = new ArrayList<Integer>();
		Collections.addAll(X, A);
		Collections.addAll(Y, B);
		Collections.addAll(Z, C);
		a.add(X);
		a.add(Y);
		a.add(Z);
		System.out.println("ans: " + uniquePathsWithObstacles(a));
	}

	public static int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
		int row = a.size();
		int col = a.get(0).size();
		int [][] uniquePaths = new int[row + 1][col + 1];
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				uniquePaths[i][j] = a.get(i).get(j).intValue();
			}
		}
		
		for (int i = 0; i < row; i++) {
	        for (int j = 0; j < col; j++) {
	  
	            uniquePaths[i][j] = 0;
	             
	            if (a.get(i).get(j).intValue() == 1) {
	            	continue;
	            }
	            if (i == 0 && j == 0) {
	            	uniquePaths[i][j] = 1;
	            }
	            if (i > 0) {
	            	uniquePaths[i][j] += uniquePaths[i-1][j];
	            }
	            if (j > 0) {
	            	uniquePaths[i][j] += uniquePaths[i][j-1];
	            }
	        }
	    }
	  
	    return uniquePaths[row-1][col-1];
	}
}
