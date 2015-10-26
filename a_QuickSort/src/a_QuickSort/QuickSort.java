package a_QuickSort;

public class QuickSort {

	private QuickSort() {}
	
	private static Integer [] data;
	
	public static void Sort(Integer [] A) {
		if (null == A) {
			return;
		}
		
		int len = A.length;
		
		if (0 == len || 1 == len) {
			return ;
		}
		
		data = A;
		
		quickSort(0, len-1);
	}
	
	private static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}
	
	private static int partition(int left, int right) {
		int key = data[right];
		int i = left - 1;
		
		for (int j=left; j<right; j++ ) {
			if (data[j] <= key) {
				i = i + 1;
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
			}
		}
		int temp = data[i+1];
		data[i+1] = data[right];
		data[right] = temp;
		
		return i+1;
	}
}
