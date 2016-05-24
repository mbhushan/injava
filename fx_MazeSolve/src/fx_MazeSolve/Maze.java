package fx_MazeSolve;

public class Maze {

	public static void main(String[] args) {
		int maze[][] = {
				{1, 0, 0, 0},
	            {1, 1, 0, 1},
	            {0, 1, 0, 0},
	            {1, 1, 1, 1}
	        };
		Maze M = new Maze();
		M.solve(maze);
	}
	
	public void solve(int [][] maze) {
		int row = maze.length;
		int col = maze[0].length;
		int [][] sol = new int [row][col];
		
		sol[0][0] = 1;
		
		//leftmost col;
		for (int i=1; i<row; i++) {
			if (maze[i][0] == 0) {
				sol[i][0] = 0;
			} else {
				sol[i][0] = sol[i-1][0];
			}
		}
		
		//first row
		for (int i=1; i<col; i++) {
			if (maze[0][i] == 0) {
				sol[0][i] = 0;
			} else {
				sol[0][i] = sol[0][i-1];
			}
		}
		
		for (int i=1; i<row; i++) {
			for (int j=1; j<col; j++) {
				if (maze[i][j] == 0) {
					sol[i][j] = 0;
				} else {
					sol[i][j] = sol[i-1][j] + sol[i][j-1];
				}
			}
		}
		
		System.out.println("solution matrix: ");
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}
}
