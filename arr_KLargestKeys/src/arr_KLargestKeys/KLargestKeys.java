package arr_KLargestKeys;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
k largest(or smallest) elements in an array | added Min Heap method
Question: Write an efficient program for printing k largest elements in an array. Elements in array can be in any order.

For example, if given array is [1, 23, 12, 9, 30, 2, 50] and 
you are asked for the largest 3 elements i.e., k = 3 then your program should print 50, 30 and 23.
*/
public class KLargestKeys {

	public static void main(String[] args) {
		KLargestKeys KK = new KLargestKeys();
		
		int [] A = {1, 23, 12, 9, 30, 2, 50};
		int k = 3;
		ArrayList<Integer> result = KK.kLargestKeys(A, k);
		for (int x : result) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
	public ArrayList<Integer> kLargestKeys(int [] A, int k) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if (A == null || A.length < 1) {
			return result;
		}
		
		if (k >= A.length) {
			for (int x : A) {
				result.add(x);
			}
			return result;
		}
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(10, new MinHeapComparator() );
		for (int i=0; i<k; i++) {
			minHeap.add(A[i]);
		}
		
		for (int i=k; i<A.length; i++) {
			if (A[i] > minHeap.peek()) {
				minHeap.remove();
				minHeap.add(A[i]);
			}
		}
		
		while (!minHeap.isEmpty()) {
			result.add(minHeap.remove());
		}

		return result;
	}
}

class MinHeapComparator implements Comparator<Integer> {
	public int compare(Integer i1, Integer i2) {
		return i1 - i2;
	}
}
