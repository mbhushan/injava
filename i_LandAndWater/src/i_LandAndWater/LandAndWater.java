package i_LandAndWater;

public class LandAndWater {

	public static void main(String [] args) {
		int [][] matrix = {{1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
           };
		
		System.out.println("count islands: " + countIslands(matrix));
		
	}
	
	public static int countIslands(int [][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		
		boolean [][] visited = new boolean[row][col];
		int count = 0;
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				if (!visited[i][j] && matrix[i][j] == 1) {
					doDFS(matrix, visited, i, j);
					++count;
				}
			}
		}
		return count;
	}
	
	private static void doDFS(int [][] matrix, boolean [][] visited, int i, int j) {
		visited[i][j] = true;
		
		for (int r=i-1; r <= i+1 && r < matrix.length; r++) {
			for (int c=j-1; c <= j+1 && c <matrix[0].length; c++) {
				if (r >= 0 && c >= 0 && !visited[r][c] && matrix[r][c] == 1) {
					doDFS(matrix, visited, r, c);
				}
			}
		}
	}
}
