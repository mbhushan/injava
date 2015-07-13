package a_ShellSort;

public class ShellSort {

	private ShellSort() {}
	
	
	public static void sort(Comparable [] A) {
		if (null == A || A.length <= 1) {
			return;
		}
		int N = A.length;
		
		// 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
		int h = 1;
        while (h < N/3) {
        	h = 3*h + 1;
        }
        
        while (h >= 1) {
        	for (int i=h; i<N; i++) {
        		for (int j=i; j >= h && less(A[j], A[j-h]); j-=h) {
        			exchange(A, j, j-h);
        		}
        	}
        	assert isHSorted(A, h);
        	h /= 3;
        }
		assert isSorted(A, 0, N-1);
	}
	
	public static void show(Comparable [] A) {
		if (null == A || A.length < 1) {
			return;
		}
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	
	/***** Helper methods for sorting ********/
	
	private static boolean less(Comparable x, Comparable y) {
		return x.compareTo(y) < 0;
	}
	
	private static void exchange(Comparable [] A, int i, int j) {
		Comparable temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	private static boolean isHSorted(Comparable [] A, int h) {
		if (null == A || A.length <= 1) {
			return true;
		}
		for (int i=h; i<A.length; i++) {
			if (less(A[i], A[i-h])) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isSorted(Comparable [] A, int low, int high) {
		if (null == A || A.length <= 1) {
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
