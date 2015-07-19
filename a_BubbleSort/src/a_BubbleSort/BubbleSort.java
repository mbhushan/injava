package a_BubbleSort;

public class BubbleSort {
	
	private BubbleSort() {}
	
	public static void sort(Comparable [] A) {
		if (null == A || A.length <= 1) {
			return;
		}
		
		int N = A.length;
		for (int i=0; i<N; i++) {
			for (int j=N-1; j>=i+1; j--) {
				if (less(A[j], A[j-1])) {
					exchange(A, j, j-1);
				}
			}
		}
		assert isSorted(A, 0, N-1);
	}
	
	public static void show(Comparable [] A) {
		if (null == A) {
			return;
		}
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	/* Helper functions */
	private static boolean less(Comparable x, Comparable y) {
		return x.compareTo(y) < 0;
	}
	
	private static void exchange(Comparable [] A, int i, int j) {
		Comparable temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	private static boolean isSorted(Comparable [] A, int low, int high) {
		if ((high - low + 1) <= 1) {
			return true;
		}
		
		for (int i=low+1; i<=high; i++) {
			if (less(A[i], A[i-1])) {
				return false;
			}
		}
		return true;
	}

}
