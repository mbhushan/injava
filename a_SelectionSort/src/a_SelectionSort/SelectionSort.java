package a_SelectionSort;

public class SelectionSort {

	private SelectionSort() {}
	
	public static void sort(Comparable [] A) {
		if (null == A || A.length < 1) {
			return;
		}
		int N = A.length;
		for (int i=0; i<N; i++) {
			int min = i;
			for (int j=i+1; j<N; j++) {
				if (less(A[j], A[min])) {
					min = j;
				}
			}
			exchange(A, i, min);
			assert isSorted(A, 0, i);
		}
		assert isSorted(A);
	}
	
	public static void show(Comparable [] A) {
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	private static void exchange(Comparable [] A, int i , int j) {
		Comparable temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	private static boolean less(Comparable x, Comparable y) {
		return x.compareTo(y) < 0;
	}
	
	
	private static boolean isSorted(Comparable [] A) {
		return isSorted(A, 0, A.length - 1);
	}
	
	private static boolean isSorted(Comparable [] A, int low, int high) {
		for (int i=low+1; i<=high; i++) {
			if (less(A[i], A[i-1])) { return true; }
		}
		return false;
	}
}
