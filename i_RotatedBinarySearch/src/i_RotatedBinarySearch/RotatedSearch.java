package i_RotatedBinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RotatedSearch {
	
	public static void main(String[] args) {
		int [] A = {4, 5, 6, 7, 0, 1, 2};
		List<Integer> X = new ArrayList<Integer>();
		
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		
		Random rand = new Random();
		for (int i=0; i<5; i++) {
			int key = rand.nextInt(20) + 1;
			System.out.println(key + " search: " + search(X, key));
			
		}
		
	}

	public static int search(final List<Integer> A, int key) {
		if (A == null || (A.size() == 0)) {
			return -1;
		}
		int N = A.size();
		int L = 0;
		int R = N - 1;

		while (L <= R) {
			// Avoid overflow, same as M=(L+R)/2
			int M = L + ((R - L) / 2);
			if (A.get(M).intValue() == key)
				return M;

			// the bottom half is sorted
			if (A.get(L).intValue() <= A.get(M).intValue()) {
				if (A.get(L).intValue() <= key && key < A.get(M).intValue())
					R = M - 1;
				else
					L = M + 1;
			}
			// the upper half is sorted
			else {
				if (A.get(M).intValue() < key && key <= A.get(R).intValue())
					L = M + 1;
				else
					R = M - 1;
			}
		}
		return -1;
	}
}
