package rec_MinCostInMatrix;

/*
Given a 2 dimensional matrix, find minimum cost path to reach bottom 
right from top left provided you can only from down and right.
*/

public class MinCostMatrix {

	public static void main(String[] args) {
		MinCostMatrix mcm = new MinCostMatrix();
		
		int M[][] = {
				{1,2,3},
				{4,8,2},
				{1,5,3},
				{6,2,9}
			};
		System.out.println("min cost: " + mcm.minCost(M));
	}
	
	public int minCost(int [][] M) {
		return minCost(M, 0, 0);
	}
	
	private int minCost(int [][] M, int r, int c) {
		
		if (r >= M.length || c >= M[0].length) {
			return Integer.MAX_VALUE;
		}
		
		if (r == M.length-1 && c == M[0].length-1) {
			return M[r][c];
		}
		
		int x = minCost(M, r+1, c);
		int y = minCost(M, r, c+1);
		
		return M[r][c] + Math.min(x, y);
	}
}
