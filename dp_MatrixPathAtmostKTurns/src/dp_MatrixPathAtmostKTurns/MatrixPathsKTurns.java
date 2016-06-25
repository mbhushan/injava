package dp_MatrixPathAtmostKTurns;

/*
Count number of paths with at-most k turns
Given a “m x n” matrix, count number of paths to reach bottom right from top left with maximum k turns allowed.

What is a turn? A movement is considered turn, if we were moving along row and now move along column. 
OR we were moving along column and now move along row.

There are two possible scenarios when a turn can occur
at point (i, j):

Turns Right: (i-1, j)  ->  (i, j)  ->  (i, j+1)
                      Down        Right

Turns Down:  (i, j-1)  ->  (i, j)  ->  (i+1, j)
                     Right        Down
Examples:

Input:  m = 3, n = 3, k = 2
Output: 4
See below diagram for four paths with 
maximum 2 turns.

Input:  m = 3, n = 3, k = 1
Output: 2 
 */
public class MatrixPathsKTurns {
	
	public static void main(String[] args) {
		MatrixPathsKTurns mp = new MatrixPathsKTurns();
	
		int row = 3;
		int col = 3;
		int k = 2;
		System.out.println("total paths: " + mp.countPaths(row-1, col-1, k));
	}
	
	public int countPaths(int row, int col, int k) {
		int [][][][] dp = new int[row+1][col+1][k+1][2];
		
		if (row == 0 && col == 0) {
			return 1;
		}
		
		return countPathsUtil(dp, row, col, k, 1) + countPathsUtil(dp, row, col, k, 0);
	}
	
	private int countPathsUtil(int [][][][] dp , int r, int c, int k, int d) {
		
		if (r < 0 || c < 0) {
			return 0;
		}
		
		if (r == 0 && c == 0) {
			return 1;
		}
		
		if (k == 0) {
			if (r == 0 && c == 0) {
				return 1;
			}
			return 0;
		}
		if (dp[r][c][k][d] != 0) {
			return dp[r][c][k][d];
		}
		
		if (d == 0) {
		      return dp[r][c][k][d] = countPathsUtil(dp, r, c-1, k, d) +
		                              countPathsUtil(dp, r-1, c, k-1, 1-d);
		}
		 
		    // Similar to above if direction is column
		return dp[r][c][k][d] =  countPathsUtil(dp, r-1, c, k, d) +
		                             countPathsUtil(dp, r, c-1, k-1, 1-d);
	}
}
