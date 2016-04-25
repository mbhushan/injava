package backtrack_NQueens;

class Position {
	int row;
	int col;
	
	public Position(int r, int c) {
		this.row = r;
		this.col = c;
	}
}

public class NQueens {
	
	public Position [] solveNQueen(int n) {
		Position [] positions = new Position[n];
		if (solveNQueenUtil(n, 0, positions)) {
			return positions;
		} else {
			return new Position[0];
		}
	}
	
	private boolean solveNQueenUtil(int n, int row, Position [] positions) {
		if (n == row) {
			return true;
		}
		for (int col=0; col<n; col++) {
			boolean isSafe = true;
			//check if this row and col is not under attack from any previous queen.
			for (int queen=0; queen<row; queen++) {
				if (positions[queen].col == col || positions[queen].row - positions[queen].col == row - col ||
						positions[queen].row + positions[queen].col == row + col) {
					isSafe = false;
					break;
				}
			}
			if (isSafe) {
				positions[row] =  new Position(row, col);
				if (solveNQueenUtil(n, row+1, positions)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String [] args) {
		NQueens NQ = new NQueens();
		int n = 4;
		Position [] positions = NQ.solveNQueen(n);
		System.out.println("Possible Queen positions:");
		for (Position P : positions) {
			System.out.println(P.row + ", " + P.col);
		}
		System.out.println();
	}

}
