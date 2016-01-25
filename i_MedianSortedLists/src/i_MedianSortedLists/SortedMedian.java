package i_MedianSortedLists;

import java.util.ArrayList;
import java.util.List;

public class SortedMedian {
	
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
	
	public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		return findMedianSortedArrays(a, a.size(), b, b.size());
	}

	private static double findMedianSortedArrays(final List<Integer> A, int m, final List<Integer> B, int n)  {
		  assert(m+n >= 1);
		  if (m == 0)
		    return findMedianSingleArray(B, n);
		  else if (n == 0)
		    return findMedianSingleArray(A, m);
		  else if (m == 1)
		    return findMedianBaseCase(A.get(0).intValue(), B, n);
		  else if (n == 1)
		    return findMedianBaseCase(B.get(0).intValue(), A, m);
		  else if (m == 2)
		    return findMedianBaseCase2(A.get(0).intValue(), A.get(1).intValue(), B, n);
		  else if (n == 2)
		    return findMedianBaseCase2(B.get(0).intValue(), B.get(1).intValue(), A, m);
		 
		  int i = m/2, j = n/2, k;
		  if (A.get(i).intValue() <= B.get(j).intValue()) {
		    k = ((m%2 == 0) ? Math.min(i-1, n-j-1) : Math.min(i, n-j-1));
		    assert(k > 0);
		    return findMedianSortedArrays(A, m-k, B, n-k);
		  } else {
		    k = ((n%2 == 0) ? Math.min(m-i-1, j-1) : Math.min(m-i-1, j));
		    assert(k > 0);
		    return findMedianSortedArrays(A, m-k, B, n-k);
		  }
		}
	
	private static double findMedianBaseCase(int med, List<Integer> C, int n) {
		  if (n == 1)
		    return (med+C.get(0).intValue())/2.0;
		 
		  if (n % 2 == 0) {
		    int a = C.get(n/2 -1).intValue(), b = C.get(n/2).intValue();
		    if (med <= a)
		      return a;
		    else if (med <= b)
		      return med;
		    else /* med > b */
		      return b;
		  } else {
		    int a = C.get(n/2 - 1).intValue(), b = C.get(n/2).intValue(), c = C.get(n/2 + 1).intValue();
		    if (med <= a)
		      return (a+b) / 2.0;
		    else if (med <= c)
		      return (med+b) / 2.0;
		    else /* med > c */
		      return (b+c) / 2.0;
		  }
		}
		 
		private static double findMedianBaseCase2(int med1, int med2, List<Integer> C, int n) {
		  if (n % 2 == 0) {
		    int a = (((n/2-2) >= 0) ? C.get(n/2 - 2).intValue() : Integer.MAX_VALUE);
		    int b = C.get(n/2 - 1).intValue(), c = C.get(n/2).intValue();
		    int d = (((n/2 + 1) <= n-1) ? C.get(n/2 + 1).intValue() : Integer.MAX_VALUE);
		    if (med2 <= b)
		      return (b+Math.max(med2,a)) / 2.0;
		    else if (med1 <= b)
		      return (b+Math.min(med2,c)) / 2.0;
		    else if (med1 >= c)
		      return (c+Math.min(med1,d)) / 2.0;
		    else if (med2 >= c)
		      return (c+Math.max(med1,b)) / 2.0;
		    else  /* a < med1 <= med2 < b */
		      return (med1+med2) / 2.0;
		  } else {
		    int a = C.get(n/2 -1).intValue(), b = C.get(n/2).intValue(), c = C.get(n/2 + 1).intValue();
		    if (med1 >= b)
		      return Math.min(med1, c);
		    else if (med2 <= b)
		      return Math.max(med2, a);
		    else  /* med1 < b < med2 */
		      return b;
		  }
		}
		 
		private static double findMedianSingleArray(List<Integer> A, int n) {
		  assert(n > 0);
		  return ((n%2 == 1) ? A.get(n/2).intValue() : (A.get(n/2 - 1).intValue() + A.get(n/2).intValue() ) / 2.0);
		}
}
