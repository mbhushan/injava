package a_RandomQuickSort;

import java.util.Random;

public class RandomizedQuickSort {

	private static Integer [] data;
	
	private RandomizedQuickSort() {}
	
	public static void sort(Integer [] A) {
		if (null == A) {
			return ;
		}
		
		int len = A.length;
		
		if (0 == len || 1 == len) {
			return;
		}
		
		data = A;
		
		randomizedQuickSort(0, len-1);
	}
	
	private static void randomizedQuickSort(int left, int right) {
		if (left < right) {
			int pivot = randomizedPartition(left, right);
			randomizedQuickSort(left, pivot-1);
			randomizedQuickSort(pivot+1, right);
		}
	}
	
	private static int randomizedPartition(int left, int right) {
		Random rand = new Random();
		int i = rand.nextInt(right - left + 1) + left;
		int temp = data[i];
		data[i] = data[right];
		data[right] = temp;
		return partition(left, right);
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
