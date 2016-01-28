package i_SudokuValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuValidation {
	
	public static void main(String[] args) {
		String [] S = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
		List<String> A = new ArrayList<String>();
		
		for (int i=0; i<S.length; i++) {
			A.add(S[i]);
		}
		
		System.out.println("valid sudoku: " + isValidSudoku(A));
		
	}

	public static int isValidSudoku(final List<String> a) {
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			String s = a.get(i);
			for (int j = 0; j < 9; j++) {
				board[i][j] = s.charAt(j);
			}
		}

		boolean[] used = new boolean[9];
		for (int i = 0; i < 9; i++) {
			Arrays.fill(used, false);
			for (int j = 0; j < 9; j++) {
				if (check(board[i][j], used) == false)
					return 0;
			}
			Arrays.fill(used, false);
			for (int j = 0; j < 9; j++) {
				if (check(board[j][i], used) == false)
					return 0;
			}
		}

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				Arrays.fill(used, false);
				for (int i = r * 3; i < r * 3 + 3; i++) {
					for (int j = c * 3; j < c * 3 + 3; j++) {
						if (check(board[i][j], used) == false)
							return 0;
					}
				}
			}
		}
		return 1;
	}

	private static boolean check(char ch, boolean[] used) {
		if (ch == '.')
			return true;
		if (used[ch - '1'])
			return false;
		used[ch - '1'] = true;
		return true;
	}
}
