package i_MaxThreeProduct;

import java.util.ArrayList;

public class MaxProduct {
	
	public static void main(String[] args) {
		int [] X = {0, -1, 3, 100, 70, 50};
		ArrayList<Integer> A = new ArrayList<Integer>();
		for (int i=0; i<X.length; i++) {
			A.add(X[i]);
		}
		
		System.out.println("product: " + maxp3(A));
	}

	public static int maxp3(ArrayList<Integer> a) {

		Integer[] arr = new Integer[a.size()];
		a.toArray(arr);

		int[] maxThree = getMaxThree(arr);
		int[] minTwo = getMinTwo(arr);

		int ans = Math.max(maxThree[0] * maxThree[1] * maxThree[2], maxThree[0]
				* minTwo[0] * minTwo[1]);

		return ans;
	}

	private static int[] getMinTwo(Integer[] arr) {
		int[] result = { Integer.MAX_VALUE, Integer.MAX_VALUE };
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			if (arr[i] <= result[0]) {
				result[1] = result[0];
				result[0] = arr[i];
			} else if (arr[i] <= result[1]) {
				result[1] = arr[i];
			}
		}

		return result;
	}

	private static int[] getMaxThree(Integer[] arr) {
		int[] result = { Integer.MIN_VALUE, Integer.MIN_VALUE,
				Integer.MIN_VALUE };
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			if (arr[i] >= result[0]) {
				result[2] = result[1];
				result[1] = result[0];
				result[0] = arr[i];
			} else if (arr[i] >= result[1]) {
				result[2] = result[1];
				result[1] = arr[i];
			} else if (arr[i] >= result[2]) {
				result[2] = arr[i];
			}
		}

		return result;
	}
}
