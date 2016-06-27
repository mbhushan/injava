package rec_CombinationOfSizeK;

import java.util.Arrays;

public class CombinationOfSizeK {

	public static void main(String[] args) {
		CombinationOfSizeK com = new CombinationOfSizeK();
		
		int [] digits = {1,1,2,3,3};
		int k = 3;
		System.out.println("total combinations of size " + k);
		System.out.println(com.findCombinationK(digits, k));
	}
	
	
	public int findCombinationK(int [] digits, int k) {
		if (digits == null || digits.length < 1) {
			return 0;
		}
		return findCombinationsK(digits, k, 0, 0, new int [k]);
	}
	
	private int findCombinationsK(int [] digits, int k, int index, int pos, int [] data) {
		if (index == k) {
			System.out.println(Arrays.toString(data));
			return 1;
		}
		
		if (pos >= digits.length) {
			return 0;
		}
		
		int count = 0;
		data[index] = digits[pos];
		count += findCombinationsK(digits, k, index+1, pos+1, data);
		
		while ((pos+1 < digits.length) && digits[pos] == digits[pos+1]) {
			++pos;
		}
		count += findCombinationsK(digits, k, index, pos+1, data);
		
		return count;
	}
}
