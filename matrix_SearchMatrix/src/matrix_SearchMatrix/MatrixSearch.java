package matrix_SearchMatrix;

public class MatrixSearch {

	public boolean searchMatrix(int [][] M, int key) {

		if (M == null || M.length == 0) {
			return false;
		}
		
		int r = M.length;
		int c = M[0].length;
		
		int start = 0;
		int end = r*c - 1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int midX = mid / c;
			int midY = mid % c;
			
			if (M[midX][midY] == key) {
				return true;
			}
			
			if (M[midX][midY] < key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		MatrixSearch MS = new MatrixSearch();
		
		int [][] M = {
		               {1,   3,  5,  7},
		               {10, 11, 16, 20},
		               {23, 30, 34, 50},
		              };
		int key = 11;
		System.out.println("is key present: " + MS.searchMatrix(M, key));

	}
}
