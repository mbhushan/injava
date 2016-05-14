package matrix_SetZero;

import javax.swing.JTable.PrintMode;

public class Matrix {

	public void setZero(int [][] M) {
		int r = M.length;
		int c = M[0].length;
		
		int [] R = new int[r];
		int [] C = new int[c];
		
	/* Store the rows and columns to be marked as 1 in row[] and col[]
       arrays respectively */
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				if (M[i][j] == 0) {
					R[i] = 1;
					C[j] = 1;
				}
			}
		}

		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				if (R[i] == 1 || C[j] == 1) {
					M[i][j] = 0;
				}
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
		Matrix mat = new Matrix();
		
		int [][] M = { 
				{0, 1, 1, 0},
		        {1, 1, 0, 1},
		        {1, 1, 1, 1},
		    };
		System.out.println("printing input matrix: ");
		mat.printMatrix(M);
		mat.setZero(M);
		System.out.println("printing matrix after setting zero: ");
		mat.printMatrix(M);
	}
}
