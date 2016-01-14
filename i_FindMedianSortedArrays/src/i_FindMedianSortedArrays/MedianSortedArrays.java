package i_FindMedianSortedArrays;

import java.util.ArrayList;
import java.util.List;

public class MedianSortedArrays {
	
	public static double findMedianSortedArrays(final List<Integer> a,
			final List<Integer> b) {
		int m = a.size();
		int n = b.size();
	 
		if ((m + n) % 2 != 0) // odd
			return (double) findKth(a, b, (m + n) / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(a, b, (m + n) / 2, 0, m - 1, 0, n - 1) 
				+ findKth(a, b, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
		}
	}
	 
	public static int findKth( List<Integer> a, List<Integer> b, int k, 
		int aStart, int aEnd, int bStart, int bEnd) {
	 
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
	 
		// Handle special cases
		if (aLen == 0)
			return b.get(bStart + k);
		if (bLen == 0)
			return a.get(aStart + k);
		if (k == 0)
			return a.get(aStart).intValue() < b.get(bStart).intValue() ? a.get(aStart).intValue() : b.get(bStart).intValue();
	 
		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count
	 
		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;
	 
		if (a.get(aMid).intValue() > b.get(bMid).intValue()) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
	 
		return findKth(a, b, k, aStart, aEnd, bStart, bEnd);
	}

	public static double findMedianSortedArrays1(final List<Integer> a,
			final List<Integer> b) {
		int m = a.size()-1;
		int n = b.size()-1;
		int total = m + n;
		if (total % 2 == 1) {
			return fms(a, m, b, n, (total / 2) + 1);
		} else {
			return (fms(a, m, b, n, total / 2) + fms(a, m, b, n, (total / 2) + 1)) / 2;
		}
	}

	private static double fms(List<Integer> a, int m, List<Integer> b, int n,
			int k) {

		if (m > n) {
			return fms(b, n, a, m, k);
		}

		if (m == 0) {
			return b.get(k - 1).doubleValue();
		}
		if (k == 1) {
			return Math.min(a.get(0).intValue(), b.get(0).intValue());
		}
		int pa = Math.min(k / 2, m);
		int pb = k - pa;
		if (a.get(pa - 1).intValue() <= b.get(pb - 1).intValue()) {
			return fms(a, m - pa, b, n, k - pa);
		}
		return fms(a, m, b, n - pb, k - pb);
	}
	
	public static void main(String[] args) {
		int [] A = {1, 4, 5};
		int [] B = {2, 3};
		
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		
		ArrayList<Integer> Y = new ArrayList<Integer>();
		for (int i=0; i<B.length; i++) {
			Y.add(B[i]);
		}
		
		System.out.println("median: " + findMedianSortedArrays(X, Y));
	}

}
