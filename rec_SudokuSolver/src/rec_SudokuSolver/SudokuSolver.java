package rec_SudokuSolver;

/*
Sudoku Solver:
Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'.
You may assume that there will be only one unique solution.
*/
public class SudokuSolver {

	public static void main(String[] args) {
		SudokuSolver ss = new SudokuSolver();
        char[][] input = new char[9][9];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                input[i][j] = '.';
            }
        }

        input[0] = "..9748...".toCharArray();
        input[1] = "7........".toCharArray();
        input[2] = ".2.1.9...".toCharArray();
        input[3] = "..7...24.".toCharArray();
        input[4] = ".64.1.59.".toCharArray();
        input[5] = ".98...3..".toCharArray();
        input[6] = "...8.3.2.".toCharArray();
        input[7] = "........6".toCharArray();
        input[8] = "...2759..".toCharArray();
        
        if (ss.solveSudoku(input)) {
        	
        	System.out.println("sudoku solved");
        	for (int i=0; i<input.length; i++) {
        		for (int j=0; j<input[0].length; j++) {
        			System.out.print(input[i][j] + " ");
        		}
        		System.out.println();
        	}
        } else {
        	System.out.println("no solution for sudoku!");
        }
	}
	
	public boolean solveSudoku(char [][] input) {
	
		int row = input.length;
		int col = input[0].length;
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (input[i][j] == '.') {
					for (char num='1'; num<='9'; num++) {
						if (isValidConfig(input, i, j, num)) {
							input[i][j] = num;
							if (solveSudoku(input)) {
								return true;
							} else {
								input[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isValidConfig(char [][] input, int i, int j, char ch) {
		//check col
		for (int row=0; row<input.length; row++) {
			if (input[row][j] == ch) {
				return false;
			}
		}
		
		//check row
		for (int col=0; col<input[0].length; col++) {
			if (input[i][col] == ch) {
				return false;
			}
		}
		
		//check block
		int lowRow = (i/3)*3;
		int highRow = (i/3)*3 + 3;
		int lowCol = (j/3)*3;
		int highCol = (j/3)*3 + 3;
		for (int row=lowRow; row<highRow; row++) {
			for (int col=lowCol; col<highCol; col++) {
				if (input[row][col] == ch) {
					return false;
				}
			}
		}
		return true;
	}
}
