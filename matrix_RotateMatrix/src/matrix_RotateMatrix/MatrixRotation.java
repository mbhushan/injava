package matrix_RotateMatrix;

public class MatrixRotation {

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = temp;
			}
		}
	}
	
	public void printMatrix(int [][] M) {
		for (int i=0; i<M.length; i++) {
			for (int j=0; j<M[0].length; j++) {
				System.out.print(M[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		MatrixRotation MR = new MatrixRotation();
		
		int [][] M = {
	               {1,   3,  5,  7},
	               {10, 11, 16, 20},
	               {23, 30, 34, 50},
	              };

		System.out.println("before rotation: ");
		MR.printMatrix(M);
		MR.rotate(M);
		System.out.println("after rotation: ");
		MR.printMatrix(M);
	}
}
