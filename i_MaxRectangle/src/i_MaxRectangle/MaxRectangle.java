package i_MaxRectangle;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxRectangle {
	
	public static void main(String[] args) {
		int [][] matrix = {{1,1,1},
				{0,1,1},
				{1,0,0}
		};
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<matrix.length; i++) {
			ArrayList<Integer> X = new ArrayList<Integer>();
			for (int j=0; j<matrix[i].length; j++) {
				X.add(matrix[i][j]);
			}
			a.add(X);
			
		}
		System.out.println("max area: " + maximalRectangle(a));
	}

	public static int maximalRectangle(ArrayList<ArrayList<Integer>> a) {
		int row = a.size();
		int col = a.get(0).size();
		int [][] matrix = new int [row][col];
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				matrix[i][j] = a.get(i).get(j);
			}
		}
		return maxRectangle(matrix);
	}
	
	private static int maxRectangle(int [][] matrix) {
		int rows = matrix.length;
	    if (rows == 0) return 0;
	     
	    int cols = matrix[0].length;
	    if (cols == 0) return 0;
	     
	    int [][]dp = new int[rows][cols]; 
	    //Arrays.fill(dp, 0);
	    int area = 0;
	 
	    for (int i = 0; i < rows; i++) { 
	        for (int j = 0; j < cols; j++) {
	 
	            if (matrix[i][j] == 1) { 
	 
	                if (j == 0) dp[i][j] = 1;
	                else dp[i][j] = dp[i][j - 1] + 1;
	 
	                int y = 1;
	                int x = cols;
	 
	                while((i - y + 1 >= 0) && (matrix[i - y + 1][j] == 1)) {
	 
	                    x = Math.min(x, dp[i - y + 1][j]);
	                    area = Math.max(area, x * y);
	                    y++;
	                } 
	            }
	        }
	    }
	 
	    return area;
	}
}
