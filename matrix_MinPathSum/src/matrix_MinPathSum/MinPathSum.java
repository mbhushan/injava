package matrix_MinPathSum;

/*
 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
 which minimizes the sum of all numbers along its path.
 */
public class MinPathSum {
	
	public int minSumPathDP(int [][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int [][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		
		//init top row.
		for (int i=1; i<n; i++) {
			dp[0][i] = dp[0][i-1] + grid[0][i]; 
		}
		
		//init leftmost col.
		for (int i=1; i<m; i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		
		//fill the DP table
		for (int i=1; i<m; i++) {
			for (int j=1; j<n; j++) {
				if (dp[i-1][j] > dp[i][j-1]) {
					dp[i][j] = dp[i][j-1] + grid[i][j];
				} else {
					dp[i][j] = dp[i-1][j] + grid[i][j];
				}
			}
		}
		
		return dp[m-1][n-1];
	}
	
	public int minSumPath(int [][] grid) {
		return dfs(grid, 0, 0);
	}
	
	private int dfs(int [][] grid, int i, int j) {
		if (i == grid.length-1 && j == grid[0].length-1) {
			return grid[i][j];
		}
		
		if (i < grid.length-1 && j < grid[0].length-1) {
			int r1 = grid[i][j] + dfs(grid, i+1, j);
			int r2 = grid[i][j] + dfs(grid, i, j+1);
			return Math.min(r1, r2);
		}
		
		if (i < grid.length-1) {
			return grid[i][j] + dfs(grid, i+1, j);
		}
		
		if (j < grid[0].length-1) {
			return grid[i][j] + dfs(grid, i, j+1);
		}
		
		return 0;
	}

	public static void main(String[] args) {
		MinPathSum MP = new MinPathSum();
		
		int[][] matrix={
				{0,	100,	1,	1,	1},
				{1,	1,		1, 100,	1},
				{100,100,	100,100, 1}, 
				{100, 100, 100, 100, 1},
				{100, 100, 100, 100, 3}
		};
		
		System.out.println("min path sum, dfs: " + MP.minSumPath(matrix));
		System.out.println("min path sum, DP: " + MP.minSumPathDP(matrix));
	}
}
