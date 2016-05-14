package matrix_RobotPaths;

public class RobotPaths {

	public int uniquePathsDP(int row, int col) {
		if (row == 0 || col == 0) {
			return 0;
		}
		
		if (row == 1 || col == 1) {
			return 1;
		}
		
		int [][] dp = new int[row][col];
		
		for (int i=0; i<row; i++) {
			dp[i][0] = 1;
		}
		
		for (int i=0; i<col; i++) {
			dp[0][i] = 1;
		}
		
		for (int i=1; i<row; i++) {
			for (int j=1; j<col; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}

		return dp[row-1][col-1];
	}
	
	public int uniquePaths(int row, int col) {
		return dfs(row, col, 0, 0);
	}
	
	private int dfs(int row, int col, int i, int j) {
		if (i == row-1 && j == col-1) {
			return 1;
		}
		
		if (i < row-1 && j < col-1) {
			return dfs(row, col, i+1, j)  +dfs(row, col, i, j+1);
		}
		
		if (i < row-1) {
			return dfs(row, col, i+1, j);
		}
		
		if (j < col-1) {
			return dfs(row, col, i, j+1);
		}
		
		return 0;
	}
	public static void main(String[] args) {
		RobotPaths RP = new RobotPaths();
		
		int row = 4;
		int col = 5;
		System.out.println("unique paths - dfs: " + RP.uniquePaths(row, col));
		System.out.println("unique paths, dp: " + RP.uniquePathsDP(row, col));
	}
}
