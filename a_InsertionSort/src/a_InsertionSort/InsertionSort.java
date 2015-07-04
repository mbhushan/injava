package a_InsertionSort;

public class InsertionSort {

	private InsertionSort() {}
	
	public static void sort(Comparable [] A) {
		int N = A.length;
		for (int i=0; i<N; i++) {
			for (int j=i; j>0 && less(A[j], A[j-1]); j--) {
				exchange(A, j, j-1);
			}
			assert isSorted(A, 0, i);
		}
		assert isSorted(A, 0, N-1);
	}
	
	// helper sorting functions
	
	private static boolean less(Comparable x, Comparable y) {
		return x.compareTo(y) < 0;
	}
	
	private static void exchange(Comparable [] A, int i, int j) {
		Comparable temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	private static boolean isSorted(Comparable [] A, int low, int high) {
		for (int i=low+1; i<=high; i++) {
			if (less(A[i], A[i-1])) {
				return false;
			}
		}
		return true;
	}
	
	public static void printData(Comparable [] A) {
		if (null == A) { 
			return;
		}
		int len = A.length;
		for (int i=0; i<len; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
