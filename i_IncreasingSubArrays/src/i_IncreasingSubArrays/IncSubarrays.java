package i_IncreasingSubArrays;

import java.util.ArrayList;
import java.util.Collections;

public class IncSubarrays {

	public static void main(String[] args) {
		Integer [] arr = { 4, 5, 1, 2 };
		ArrayList<Integer> input = new ArrayList<Integer>();
		Collections.addAll(input, arr);
		System.out.println(cntInc(input));
	}

	public static int cntInc(ArrayList<Integer> input) {

		if (input == null)
			return 0;
		int length = input.size();

		int[] cumSumArr = new int[length];
		cumSumArr[0] = 1;

		for (int i = 1; i < length; i++) {
			if (input.get(i).intValue() > input.get(i - 1).intValue()) {
				cumSumArr[i] = 1 + cumSumArr[i - 1];
			} else {
				cumSumArr[i] = 1;
			}
		}

		int sum = 0;
		for (int j = 0; j < length; j++) {
			sum += cumSumArr[j] % 1000000007;
		}
		return sum;
	}
}
