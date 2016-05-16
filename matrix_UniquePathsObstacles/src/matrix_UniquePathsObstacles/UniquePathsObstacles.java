package matrix_UniquePathsObstacles;

/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid. For example, 
there is one obstacle in the middle of a 3x3 grid as illustrated below,

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
the total number of unique paths is 2.
*/
public class UniquePathsObstacles {

	public int uniquePathObstacles(int [][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		
		int row = grid.length;
		int col = grid[0].length;
		
		if (grid[0][0] == 1 || grid[row-1][col-1] == 1) {
			return 0;
		}
		
		int [][] dp = new int[row][col];
		
		dp[0][0] = 1;
		
		for (int i=1; i<row; i++) {
			if (grid[i][0] == 1) {
				dp[i][0] = 0;
			} else {
				dp[i][0] = dp[i-1][0];
			}
		}
		
		for (int i=1; i<col; i++) {
			if (grid[0][i] == 1) {
				dp[0][i] = 0;
			} else {
				dp[0][i] = dp[0][i-1];
			}
		}
		
		for (int i=1; i<row; i++) {
			for (int j=1; j<col; j++) {
				if (grid[i][j] == 1) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
		}
		
		return dp[row-1][col-1];
	}
	
	public static void main(String[] args) {
		UniquePathsObstacles UP = new UniquePathsObstacles();
		
		int [][] matrix = {
				{0,0,0},
				{0,1,0},
				{0,0,0}
		};
		
		System.out.println("unique paths in obstacle matrix: " + UP.uniquePathObstacles(matrix));
		
	}
}
