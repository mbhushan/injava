package i_KthSmallest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class KthSmallest {
	
	public static void main(String[] args) {
		//int [] A = {2, 1, 4, 3, 2};
		int [] A = {1, 23, 12, 9, 30, 2, 50};
		List<Integer> X = new ArrayList<Integer>();
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		
		int k = 3;
		System.out.println("kth smallest: " + kthsmallest(X, k));
		
	}
	
	public static int kthsmallest(final List<Integer> a, int k) {

		int n = a.size();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, Collections.reverseOrder());
//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
//		    public int compare(Integer lhs, Integer rhs) {
//		        if (lhs > rhs) return -1;
//		        if (lhs.equals(rhs)) return 0;
//		        return 1;
//		    }
//		});
		for (int i=0; i<n; i++) {
			pq.add(a.get(i).intValue());
			if (pq.size() > k) {
				int x = pq.remove();
				System.out.println("x: " + x);
			}
		}
//		System.out.println("printing pq:");
//		while (pq.size() > 0) {
//		    System.out.print(pq.poll() + " ");
//		}
//		System.out.println();
		
		return pq.poll();
}

	public static int kthsmallest1(final List<Integer> a, int k) {

			int n = a.size();
			return randomSelect(a, 0, n-1, k);
	}

	public static int randomSelect(List<Integer> A, int p, int q, int i) {
		if (p == q) {
			return A.get(p);
		}

		/*
		 * randPartition - partitions the array around randonly chosen pivot and
		 * return the pivot index.
		 */
		int r = randomPartition(A, p, q);

		int k = r - p + 1;

		if (i == k) {
			return A.get(r);
		} else if (i < k) {
			return randomSelect(A, p, r - 1, i);
		} else {
			return randomSelect(A, r + 1, q, i - k);
		}
	}
	
	private static int randomPartition(List<Integer> data, int p, int r) {
		int i = new Random().nextInt(r - p) + p;
		int temp = data.get(i).intValue();
		data.set(i, data.get(p).intValue());
		data.set(p, temp);
		return  partition(data, p, r);
	}
	
	private static int partition(List<Integer> data, int left, int right) {
		int key = data.get(right).intValue();
		int i = left - 1;
		
		for (int j=left; j<right; j++ ) {
			if (data.get(j).intValue() <= key) {
				i = i + 1;
				int temp = data.get(i).intValue();
				data.set(i, data.get(j).intValue());
				data.set(j, temp);
			}
		}
		int temp = data.get(i+1).intValue();
		data.set(i+1, data.get(right).intValue());
		data.set(right, temp);
		
		return i+1;
	}
} 
