package rec_ChessQueenPlacements;

import java.util.ArrayList;

/**
 * Given nxn board place n queen on this board so that they dont attack each other. One solution is to find
 * any placement of queens which do not attack each other. Other solution is to find all placements of queen
 * on the board.
 *
 * Time complexity O(n*n)
 * Space complexity O(n*n)
 */

public class ChessQueen {

	public static void main(String[] args) {
		ChessQueen cq = new ChessQueen();
		
		int n = 4;
		cq.nQueen(n);
	}
	
	
	public boolean nQueen(int n) {
		
		Position [] positions = new Position[n];
		int row = 0;
		boolean ans = nQueen(n, row, positions);
		
		System.out.println(n + " queen placement possible: " + ans);
		System.out.println("positions are: ");
		for (Position p: positions) {
			System.out.println(p.row +"," + p.col);
		}
		return ans;
	}
	
	private boolean nQueen(int n, int row, Position [] positions) {
		if (row == n) {
			return true;
		}
		
		for (int col=0; col<n; col++) {
			boolean found = true;
			
			for (int queen=0; queen<row; queen++) {
				if (positions[queen].col == col || positions[queen].row + positions[queen].col == row + col ||
						positions[queen].row - positions[queen].col == row-col) {
					found = false;
					break;
				}
			}
			
			if (found) {
				positions[row] = new Position(row, col);
				if(nQueen(n, row+1, positions)) {
					return true;
				}
			}
		}
		
		return false;
	}
}

class Position {
    int row, col;
    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}