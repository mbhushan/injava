package i_ColorfulNumbers;

import java.util.HashMap;

public class ColorfulNumbers {

	public static void main(String [] args) {
		int [] num = {3245, 236, 263};
		for (int i=0; i<num.length; i++) {
			System.out.println("colorful: " + colorful(num[i]));
		}
		
	}
	
	public static int colorful(int num) {
		// Some initialization
		String str = String.valueOf(num);
		int len = str.length();
		HashMap<Integer, Boolean> hmap = new HashMap<Integer, Boolean>();
		
		int[] digits = new int[len];
		for (int i = 0; i < len; i++) {
			digits[i] = Character.getNumericValue(str.charAt(i));
			if (hmap.containsKey(digits[i])) {
				return 0;
			}
			hmap.put(digits[i], true);
		}
		
		int [][] dpmatrix = new int[len][len];

		// Fill in diagonal: O(N)
		for (int i = 0; i < digits.length; i++) {
			dpmatrix[i][i] = digits[i];
		}

		// Fill in lower left triangle: O(N^2)
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < i; j++) {
				//dpmatrix[i][j] = digits[i] * dpmatrix[i - 1][j];
				dpmatrix[i][j] = digits[i] * dpmatrix[i - 1][j];
if (hmap.containsKey(dpmatrix[i][j])) {
					return 0;
				}
				hmap.put(dpmatrix[i][j], true);
			}
		}

		// Check for dups: O(N^2)
//		int[] nums = new int[digits.length * (digits.length + 1) / 2];
//		for (int i = 0, j = 0; i < digits.length; i++, j += i)
//			System.arraycopy(dpmatrix[i], 0, nums, j, i + 1);
//
//		Arrays.sort(nums);
//
//		for (int i = 0; i < nums.length - 1; i++) {
//			if (nums[i] == nums[i + 1]) {
//				return 0;
//			}
//		}

		return 1;
	}
}
