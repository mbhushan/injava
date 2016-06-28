package rec_PrintMatrixPaths;

import java.util.Arrays;

/*
 Print all possible paths from top left to bottom right of a mXn matrix
 The problem is to print all the possible paths from top left to bottom right 
 of a mXn matrix with the constraints that from each cell you can either move only to right or down.

 The algorithm is a simple recursive algorithm, from each cell first print all 
 paths by going down and then print all paths by going right. Do this recursively for each cell encountered.
 */

public class PrintMatrixPaths {

	public static void main(String[] args) {
		PrintMatrixPaths mp = new PrintMatrixPaths();

		int[][] M = { 
				{ 1, 2, 3 }, 
				{ 4, 5, 6 }, 
				{ 7, 8, 9 } };
		mp.printMatrixPaths(M);
	}

	public void printMatrixPaths(int[][] M) {
		//printMatrixPaths(M, 0, 0, new int[M.length + M[0].length - 1]);
		solveMatrixPaths(M, 0, 0, new int[M.length + M[0].length - 1]);
	}
	
	private void solveMatrixPaths(int[][] M, int row, int col, int [] path) {
		if (row == M.length-1 && col == M[0].length-1) {
			path[row+col] = M[row][col];
			System.out.println(Arrays.toString(path));
			return;
		}
		if (row >= M.length || col >= M[0].length) {
			return;
		}

		path[row+col] = M[row][col];
		solveMatrixPaths(M, row, col + 1, path);
		solveMatrixPaths(M, row + 1, col, path);
	}

	private void printMatrixPaths(int[][] M, int row, int col, int[] path) {

		if (row == M.length || col == M[0].length) {
			return;
		}

		if (path[path.length - 1] == M[M.length - 1][M[0].length - 1]) {
			System.out.println(Arrays.toString(path));
		}

		path[row + col] = M[row][col];
		printMatrixPaths(M, row, col + 1, path);
		printMatrixPaths(M, row + 1, col, path);
	}
}
