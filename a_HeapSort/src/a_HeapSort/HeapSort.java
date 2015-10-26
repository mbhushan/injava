package a_HeapSort;

public class HeapSort {
	
	private static Integer [] data;
	private static int heapSize;
	
	private HeapSort() {}
	
	public static void sort(Integer [] A) {
		if (null == A) {
			return ;
		}
		
		int len = A.length;
		
		if (0 == len || 1 == len) {
			return ;
		}
		
		data = A;
		heapSize = len;
		
		heapSort();
	}
	
	public static void showData() {
		
		if (null == data) {
			return;
		}
		for (int i=0; i<data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
	private static void heapSort() {
		buildMaxHeap();
		//showData();
		int len = data.length;
		
		for (int i=len-1; i>0; i--) {
			int temp = data[i];
			data[i] = data[0];
			data[0] = temp;
			heapSize = heapSize - 1;
			maxHeapify(1);
		}
	}
	
	private static void buildMaxHeap() {
		for (int i=heapSize; i>=1; i--) {
			maxHeapify(i);
		}
	}
	
	private static void maxHeapify(int i) {
		int left = 2*i;
		int right = 2*i + 1;
		int largest = i;
		
		if ((left <= heapSize) && (data[left-1] > data[i-1])) {
			largest = left;
		}
		
		if ((right <= heapSize) && (data[right-1] > data[largest-1])) {
			largest = right;
		}
		
		if (largest != i) {
			int temp = data[i-1];
			data[i-1] = data[largest-1];
			data[largest-1] = temp;
			maxHeapify(largest);
		}
	}
}
