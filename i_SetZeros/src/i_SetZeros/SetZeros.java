package i_SetZeros;

import java.util.ArrayList;

public class SetZeros {

	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
		ArrayList<Integer> cols = new ArrayList<Integer>();
		int r = a.size();
		boolean flag = false;

		for (int i = 0; i < r; i++) {
			int c = a.get(i).size();
			for (int j = 0; j < c; j++) {
				if (a.get(i).get(j) == 0) {
					System.out.println("setting row to zero: " + i);
					flag = true;
					cols.add(j);
					break;
				}
			}
			if (flag) {
				for (int m = 0; m < c; m++) {
					a.get(i).set(m, 0);
				}
				flag = false;
			}
		}
		int len = cols.size();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < len; j++) {
				a.get(i).set(cols.get(j), 0);
			}
		}
		printMatrix(a);
	}

	private static void printMatrix(ArrayList<ArrayList<Integer>> M) {
		int r = M.size();
		int c = M.get(0).size();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(M.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// int [][] M = {{1,0}, {1, 1}, {1, 1}};
		int[][] M = { { 0, 1 }, { 1, 1 } };
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();

		int r = M.length;
		int c = M[0].length;
		for (int i = 0; i < r; i++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			for (int j = 0; j < c; j++) {
				row.add(M[i][j]);
			}
			A.add(row);
		}
		System.out.println("original matrix: ");
		printMatrix(A);
		System.out.println("after setting zeros: ");
		setZeroes(A);

	}

}
