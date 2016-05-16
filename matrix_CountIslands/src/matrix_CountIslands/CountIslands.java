package matrix_CountIslands;

public class CountIslands {

	public int countIslands(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;

		boolean[][] visited = new boolean[row][col];

		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 1 && !visited[i][j]) {
					dfs(matrix, i, j, visited);
					//dfsUtil(matrix, i, j, visited);
					++count;
				}
			}
		}
		return count;
	}

	private void dfs(int[][] matrix, int row, int col, boolean[][] visited) {
		visited[row][col] = true;

		for (int i = row - 1; i <= row + 1 && i < matrix.length; i++) {
			for (int j = col - 1; j <= col + 1 && j < matrix[0].length; j++) {
				if (i >= 0 && j >= 0 && matrix[i][j] == 1 && !visited[i][j]) {
					dfs(matrix, i, j, visited);
				}
			}
		}
	}

	private boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
		// row number is in range, column number is in range
		// and value is 1 and not yet visited
		return (row >= 0) && (row < M.length) && (col >= 0)
				&& (col < M[0].length)
				&& (M[row][col] == 1 && !visited[row][col]);
	}

	// A utility function to do DFS for a 2D boolean matrix.
	// It only considers the 8 neighbors as adjacent vertices
	private void dfsUtil(int M[][], int row, int col, boolean visited[][]) {
		// These arrays are used to get row and column numbers
		// of 8 neighbors of a given cell
		int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

		// Mark this cell as visited
		visited[row][col] = true;

		// Recur for all connected neighbours
		for (int k = 0; k < 8; ++k)
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
				dfsUtil(M, row + rowNbr[k], col + colNbr[k], visited);
	}

	public static void main(String[] args) {
		CountIslands CI = new CountIslands();
		int M[][] = new int[][] { 
				{ 1, 1, 0, 0, 0 }, 
				{ 0, 1, 0, 0, 1 },
				{ 1, 0, 0, 1, 1 }, 
				{ 0, 0, 0, 0, 0 }, 
				{ 1, 0, 1, 0, 1 } };

		System.out.println("count islands: " + CI.countIslands(M));
	}
}
