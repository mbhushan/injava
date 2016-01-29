package i_GrayCode;

import java.util.ArrayList;

public class GrayCode {
	
	public static void main(String[] args) {
		int n = 3;
		ArrayList<Integer> A = grayCode(n);
		for (int i : A) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (n == 0) {
			result.add(0);
			return result;
		}
		;
		result.add(0);
		result.add(1);
		for (int i = 1; i < n; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(result);
			Integer a = 1 << i;
			for (int k = result.size() - 1; k >= 0; k--) {
				tmp.add(result.get(k) + a);
			}
			result = tmp;
		}
		return result;
	}
}
