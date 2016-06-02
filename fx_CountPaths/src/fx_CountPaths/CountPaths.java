package fx_CountPaths;

/*
Count all possible paths from top left to bottom right of a mXn matrix
The problem is to count all the possible paths from top left to bottom 
right of a mXn matrix with the constraints that from each cell you can either move only to right or down
*/

public class CountPaths {
	
	public static void main(String[] args) {
		int row = 3;
		int col = 3;
		
		System.out.println("num of paths: " + new CountPaths().numPaths(row, col));
	}
	
	public int numPaths(int row, int col) {
		int [][] dp = new int[row][col];
		
		for (int i=0; i<col; i++) {
			dp[0][i] = 1;
		}
		
		for (int i=0; i<row; i++) {
			dp[i][0] = 1;
		}
		
		for (int i=1; i<row; i++) {
			for (int j=1; j<col; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		return dp[row-1][col-1];
	}
}
