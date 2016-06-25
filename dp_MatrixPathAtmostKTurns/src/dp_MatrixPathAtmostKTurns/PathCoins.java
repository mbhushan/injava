package dp_MatrixPathAtmostKTurns;

/*
Number of paths with exactly k coins
Given a matrix where every cell has some number of coins. Count number of ways to reach bottom right from top 
left with exactly k coins. We can move to (i+1, j) and (i, j+1) from a cell (i, j).

Example:
Input:  k = 12
        mat[][] = { {1, 2, 3},
                    {4, 6, 5},
                    {3, 2, 1}
                  };
Output:  2
There are two paths with 12 coins
1 -> 2 -> 6 -> 2 -> 1
1 -> 2 -> 3 -> 5 -> 1


Time complexity of this solution is O(m*n*k).
*/

public class PathCoins {
	
	public static void main(String[] args) {
		PathCoins pc = new PathCoins();
		
		int mat[][] = { {1, 2, 3},
                {4, 6, 5},
                {3, 2, 1}
              };
		int k = 12;
		
		System.out.println("total paths: " + pc.findPaths(mat, k));
		System.out.println("total paths dp: " + pc.findPaths(mat, k));
	}
	
	public int findPathsDP(int [][] M, int k) {
		int row = M.length;
		int col = M[0].length;
		
		int [][][] dp = new int[row][col][k+1];
		
		return findPathsDP(M, dp, row-1, col-1, k);
				
	}
	
	private int findPathsDP(int [][] M, int [][][] dp, int i, int j, int k) {
		if (i < 0 || j < 0) {
			return 0;
		}
		
		if (i == 0 && j == 0) {
			return k == M[i][j] ? 1: 0;
		}
		
		if (dp[i][j][k] != 0) {
			return dp[i][j][k];
		}
		
		return findPathsDP(M, dp, i-1, j, k - M[i][j]) + findPathsDP(M, dp, i, j-1, k - M[i][j]);
	}
	
	public int findPaths(int [][] M, int k) {
	
		int i = M.length-1;
		int j = M[0].length - 1;
		
		return findPathsUtil(M, i, j, k);
	}
	
	private int findPathsUtil(int [][] M, int i, int j, int k) {
		//base cases
		if (i < 0 || j < 0) {
			return 0;
		}
		
		
		if (i == 0 && j == 0) {
			return k == M[i][j] ? 1 : 0;
		} 
		
		return findPathsUtil(M, i-1, j, k - M[i][j]) + findPathsUtil(M, i, j-1, k - M[i][j]);
	}
}
