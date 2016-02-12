package i_LIS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LIS {
	
	public static void main(String[] args) {
		Integer [] X = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		List<Integer> A = new ArrayList<Integer>();
		
		Collections.addAll(A, X);
		
		System.out.println("lis: " + lis(A));
	}

	public static int lis(final List<Integer> A) {
		// Add boundary case, when array size is one

		int size = A.size();
		
		if (size == 1) {
			return size;
		}

		int[] tailTable = new int[size];
		int len; // always points empty slot

		tailTable[0] = A.get(0).intValue();
		len = 1;
		for (int i = 1; i < size; i++) {
			if (A.get(i).intValue() < tailTable[0])
				// new smallest value
				tailTable[0] = A.get(i).intValue();

			else if (A.get(i).intValue() > tailTable[len - 1])
				// A[i] wants to extend largest subsequence
				tailTable[len++] = A.get(i).intValue();

			else
				// A[i] wants to be current end candidate of an existing
				// subsequence. It will replace ceil value in tailTable
				tailTable[CeilIndex(tailTable, -1, len - 1, A.get(i).intValue())] = A
						.get(i).intValue();
		}

		return len;
	}

	private static int CeilIndex(int A[], int l, int r, int key) {
		while (r - l > 1) {
			int m = l + (r - l) / 2;
			if (A[m] >= key)
				r = m;
			else
				l = m;
		}

		return r;
	}
}
