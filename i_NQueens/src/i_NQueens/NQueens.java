package i_NQueens;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {

	public static void main(String[] args) {
		int n = 4;
		ArrayList<ArrayList<String>> result = solveNQueens(n);
		for (ArrayList<String> S : result) {
			System.out.println(S);

		}
	}

	public static ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();

		if (n < 1) {
			return ans;
		}

		String[] rows = new String[n];

		int row = 0;

		solutions(row, n, rows, result);

		for (String[] S : result) {
			ArrayList<String> board = new ArrayList<String>();
			for (String st : S) {
				board.add(st);
			}
			ans.add(board);
		}

		return ans;
	}

	// DFS soluve question
	private static void solutions(int stRow, int n, String[] rows,
			ArrayList<String[]> result) {
		if (stRow >= n) {
			result.add(rows.clone());
			return;
		}

		for (int col = 0; col < n; col++) {
			if (!isValid(col, stRow, rows)) {
				continue;

			}

			char[] chars = new char[n];
			Arrays.fill(chars, '.');
			chars[col] = 'Q';

			rows[stRow] = String.copyValueOf(chars);
			solutions(stRow + 1, n, rows, result);

		}

	}

	// check if current col has conflit with previous Q
	private static boolean isValid(int col, int stRow, String[] rows) {
		// checkColumn
		for (int i = 0; i < stRow; i++) {
			int qCol = rows[i].indexOf("Q");

			if (qCol == col) {
				return false;
			}

			int rowDistance = Math.abs(stRow - i);
			int colDistance = Math.abs(col - qCol);

			if (rowDistance == colDistance) {
				return false;
			}

		}

		return true;

	}
}
