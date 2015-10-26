package a_MergeSortAlgo;

public class MergeSort {
	
	private static Integer [] data;

	private MergeSort() {
	}
	
	public static void sort(Integer [] A) {
		if (null == A) {
			return ;
		}
		
		int len = A.length;
		
		if (len == 0 || len == 1) {
			return ;
		}
		
		data = A;
		
		mergeSort(0, len-1);
	}
	
	private static void mergeSort(int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(low, mid);
			mergeSort(mid+1, high);
			merge(low, mid, high);
		}
	}
	
	private static void merge(int low,int mid, int high) {
		int len1 = mid - low + 1;
		int len2 = high - mid;
		
		Integer [] left = new Integer[len1+1];
		Integer [] right = new Integer[len2 + 1];
		
		for (int i=0; i<len1; i++) {
			left[i] = data[low + i];
		}
		
		for (int j=0; j<len2; j++) {
			right[j] = data[mid + j + 1];
		}
		
		left[len1] = Integer.MAX_VALUE;
		right[len2] = Integer.MAX_VALUE;
		
		int i=0, j=0;
		
		for (int k=low; k<= high; k++) {
			if (left[i] <= right[j]) {
				data[k] = left[i];
				++i;
			} else {
				data[k] = right[j];
				++j;
			}
		}
	}
}
