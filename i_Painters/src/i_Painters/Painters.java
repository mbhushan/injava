package i_Painters;

import java.util.ArrayList;

public class Painters {

	private static int getMax(ArrayList<Integer> A, int n) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (A.get(i).intValue() > max)
				max = A.get(i).intValue();
		}
		return max;
	}

	private static int getSum(ArrayList<Integer> A, int n) {
		int total = 0;
		for (int i = 0; i < n; i++)
			total += A.get(i).intValue();
		return total;
	}

	private static int getRequiredPainters(ArrayList<Integer> A, int n,
			int maxLengthPerPainter) {
		int total = 0, numPainters = 1;
		for (int i = 0; i < n; i++) {
			total += A.get(i).intValue();
			if (total > maxLengthPerPainter) {
				total = A.get(i).intValue();
				numPainters++;
			}
		}
		return numPainters;
	}

	private static int partition(ArrayList<Integer> A, int n, int k) {
		int lo = getMax(A, n);
		int hi = getSum(A, n);

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int requiredPainters = getRequiredPainters(A, n, mid);
			if (requiredPainters <= k)
				hi = mid;
			else
				lo = mid + 1;
		}
		return lo;
	}

	public static int paint(int a, int b, ArrayList<Integer> c) {
		int n = c.size();
		int k = a;
		int ans = partition(c, n, k);
		ans = ans * b;
		System.out.println("ans: " + ans);
		return ans;
	}

	public static void main(String[] args) {
		int a = 2;
		int b = 5;
		int[] C = { 1, 10 };
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int i = 0; i < C.length; i++) {
			X.add(C[i]);
		}
		System.out.println("paint: " + paint(a, b, X));
	}
}
