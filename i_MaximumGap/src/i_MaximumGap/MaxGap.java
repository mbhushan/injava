package i_MaximumGap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Bucket {
	int low;
	int high;

	public Bucket() {
		low = -1;
		high = -1;
	}
}

public class MaxGap {
	
	public static void main(String[] args) {
		Integer [] X = {1, 10, 5};
		ArrayList<Integer> A = new ArrayList<Integer>();
		
		Collections.addAll(A, X);
		
		int ans = maximumGap(A);
		System.out.println("ans: " + ans);
		
	}
	
	public static int maximumGap(final List<Integer> a) {
		if (a == null || a.size() < 2) {
			return 0;
		}
		int n = a.size();
		int [] num = new int[n];
		for (int i=0; i<n; i++) {
			num[i] = a.get(i).intValue();
		}
		
		return maximumGap(num);
	}
	
	public static int maximumGap(int[] num) {
		if (num == null || num.length < 2) {
			return 0;
		}

		int max = num[0];
		int min = num[0];
		for (int i = 1; i < num.length; i++) {
			max = Math.max(max, num[i]);
			min = Math.min(min, num[i]);
		}

		// initialize an array of buckets
		Bucket[] buckets = new Bucket[num.length + 1]; // project to (0 - n)
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new Bucket();
		}

		double interval = (double) num.length / (max - min);
		// distribute every number to a bucket array
		for (int i = 0; i < num.length; i++) {
			int index = (int) ((num[i] - min) * interval);

			if (buckets[index].low == -1) {
				buckets[index].low = num[i];
				buckets[index].high = num[i];
			} else {
				buckets[index].low = Math.min(buckets[index].low, num[i]);
				buckets[index].high = Math.max(buckets[index].high, num[i]);
			}
		}

		// scan buckets to find maximum gap
		int result = 0;
		int prev = buckets[0].high;
		for (int i = 1; i < buckets.length; i++) {
			if (buckets[i].low != -1) {
				result = Math.max(result, buckets[i].low - prev);
				prev = buckets[i].high;
			}
		}
		return result;
	}
}