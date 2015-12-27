package i_SearchMatrix;

import java.util.ArrayList;

public class SearchMatrix {
	public static int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
		int result = 0;
		int m = a.size();
		int n = a.get(0).size();
		int row = 0;
		int col = n - 1;
		
		while ((row < m) && (col > 0)) {
			if (a.get(row).get(col) == b) {
				result = 1;
				break;
			} else if (a.get(row).get(col) > b) {
				col--;
			} else {
				row++;
			}
		}
		return result;
	}
}
