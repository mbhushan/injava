package a_MergeSort;

public class MergeSort {
	
	private MergeSort() {}
	
	public static void mergeSort(Comparable [] A) {
		Comparable [] helper = new Comparable[A.length];
		mergeSort(A, helper, 0, A.length-1);
		assert isSorted(A);
	}
	
	private static void mergeSort(Comparable [] A, Comparable [] helper, int low, int high) {
		if (high <= low) {
			return ;
		}
		int mid = low + (high - low)/2;
		mergeSort(A, helper, low, mid);
		mergeSort(A, helper, mid+1, high);
		merge(A, helper, low, mid, high);
	}
	
	private static void merge(Comparable [] A, Comparable [] helper, int low, int mid, int high) {
		assert isSorted(A, low, mid);
		assert isSorted(A, mid+1, high);
		
		for (int k=low; k <= high; k++) {
			helper[k] = A[k];
		}
		
		int i = low;
		int j = mid+1;
		for (int k=low; k<= high; k++) {
			if (i > mid) {
				A[k] = helper[j];
				++j;
			} else if (j > high) {
				A[k] = helper[i];
				++i;
			} else if (less(A[i], A[j])) {
				A[k] = helper[i];
				++i;
			} else {
				A[k] = helper[j];
				++j;
			}
		}
		
		assert isSorted(A, low, high);
	}
	
	/*** Helper methods for sorting ***/
	private static boolean less(Comparable x, Comparable y) {
		return x.compareTo(y) < 0;
	}
	
	private static void exchange(Comparable[] A, int i, int j) {
		Comparable temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	private static boolean isSorted(Comparable [] A) {
		return isSorted(A, 0, A.length-1);
	}
	
	private static boolean isSorted(Comparable [] A, int low, int high) {
		for (int i=low+1; i<=high; i++) {
			if (less(A[i], A[i-1])) {
				return false;
			}
		}
		return true;
	}
	
	public static void showData(Comparable [] A) {
		if (null == A) {
			return;
		}
		for (int i=0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
