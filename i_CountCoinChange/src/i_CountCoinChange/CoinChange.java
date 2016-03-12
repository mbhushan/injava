package i_CountCoinChange;

import java.util.ArrayList;
import java.util.Collections;

public class CoinChange {
	
	public static void main(String[] args) {
		//Integer [] X = {1, 2, 3};
		Integer [] X = {18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8 };
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		Collections.addAll(a, X);
		int b = 458;
		System.out.println("coin change: " + coinchange2(a, b));
	}

	public static int coinchange2(ArrayList<Integer> a, int b) {
		int m = a.size();
		
		return count(a, m, b);
	}

	public static int count(ArrayList<Integer> S, int m, int n) {
		int i, j;
		int x, y;

		// We need n+1 rows as the table is consturcted in bottom up manner
		// using
		// the base case 0 value case (n = 0)
		int [][] table = new int [n + 1][m];

		// Fill the enteries for 0 value case (n = 0)
		for (i = 0; i < m; i++)
			table[0][i] = 1;

		// Fill rest of the table enteries in bottom up manner
		for (i = 1; i < n + 1; i++) {
			for (j = 0; j < m; j++) {
				// Count of solutions including S[j]
				x = (i - S.get(j).intValue() >= 0) ? table[i - S.get(j).intValue()][j] : 0;

				// Count of solutions excluding S[j]
				y = (j >= 1) ? table[i][j - 1] : 0;

				// total count
				table[i][j] = (x + y) % 1000007;
			}
		}
		return (int) (table[n][m - 1] % 1000007);
	}
}
