package i_CompareVersion;

import java.math.BigInteger;

public class CompVersion {

	public static int compareVersion(String a, String b) {
		String[] X = a.split("\\.");

		String[] Y = b.split("\\.");

		int n = X.length;
		int m = Y.length;
		int i = 0, j = 0;

		while (i < n && j < m) {
			
			try {
			long first = Long.parseLong(X[i]);
			long second = Long.parseLong(Y[j]);
			if (first > second) {
				return 1;
			}
			if (first < second) {
				return -1;
			}
			} catch (NumberFormatException e) {
				if (X[i].compareTo(Y[i]) > 0) {
					return 1;
				}
				if (X[i].compareTo(Y[i]) < 0) {
					return -1;
				}
			}
			
			//System.out.println("first: " + first);
			//System.out.println("second: " + second);
			++i;
			++j;
		}

		if (i < n) {
			if (X[i].equals("0")) return 0;
			return 1;
		}
		if (j < m) {
			if (Y[j].equals("0")) return 0;
			return -1;
		}

		return 0;
	}

	public static void main(String[] args) {
		String a = "444444444444444444444444";
		String b = "4444444444444444444444444";
		a = "1.0";
		b = "1";

		int ans = compareVersion(a, b);
		System.out.println("ans: " + ans);
	}
}
