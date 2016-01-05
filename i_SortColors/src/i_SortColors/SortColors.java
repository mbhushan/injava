package i_SortColors;

import java.util.ArrayList;

public class SortColors {

	public static void sortColors(ArrayList<Integer> a) {

		int n = a.size();
		int low = 0;
		int mid = 0;
		int high = n - 1;

		while (mid <= high) {
			if (a.get(mid) == 0) {
				int temp = a.get(low);
				a.set(low, a.get(mid));
				a.set(mid, temp);
				++low;
				++mid;
			} else if (a.get(mid) == 2) {
				int temp = a.get(mid);
				a.set(mid, a.get(high));
				a.set(high, temp);
				--high;
				
			} else {
				++mid;
			}
		}
		printList(a);
	}

	public static void printList(ArrayList<Integer> A) {
		for (int i = 0; i < A.size(); i++) {
			System.out.print(A.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] A = { 0, 1, 2, 0, 1, 2 };
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			X.add(A[i]);
		}
		sortColors(X);
	}
}
