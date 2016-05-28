package fx_GiftMaximize;

/*
Given a 2D array of gifts, find path from top left to bottom right corner with greatest aggregated gift values.
*/
public class GiftMaximize {

	public static void main(String[] args) {
		int [][] M = {
				{2, 3, 1, 4},
				{1, 3, 2, 1},
				{4, 5, 3, 1},
				{7, 1, 4, 1}
		};
		GiftMaximize GM = new GiftMaximize();
		System.out.println("max gift: " + GM.maxGift(M));
	}
	
	public int maxGift(int [][] M)  {
		int row = M.length;
		int col = M[0].length;
		
		int [][] dp = new int[row][col];
		boolean [][] path = new boolean[row][col];
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (i ==0 && j == 0) {
					dp[i][j] = M[i][j];
					path[i][j] = true;
				} else if (i == 0) {
					dp[i][j] = dp [i][j-1] + M[i][j];
					//path[i][j] = true;
				} else if (j == 0) {
					dp[i][j] = dp [i-1][j] + M[i][j];
					//path[i][j] = true;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + M[i][j];
					if (dp[i-1][j] > dp[i][j-1]) {
						path[i-1][j] = true;
					} else {
						path[i][j-1] = true;
					}
				}
			}
		}
		path[row-1][col-1] = true;
		printMatrix(path);
		System.out.println();
		printMatrix(dp);
		return dp[row-1][col-1];
	}
	
	private void printMatrix(int [][] P) {
		for (int i=0; i<P.length; i++) {
			for (int j=0; j<P[0].length; j++) {
				System.out.print(P[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private void printMatrix(boolean [][] P) {
		for (int i=0; i<P.length; i++) {
			for (int j=0; j<P[0].length; j++) {
				System.out.print(P[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
