package rec_KCombinationInArray;

import java.util.Arrays;

/*
Print all possible combinations of r elements in a given array of size n - assume unique keys.
Given an array of size n, generate and print all possible combinations of r elements in array. 
For example, if input array is {1, 2, 3, 4} and r is 2, 
then output should be {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}.
*/

public class KCombination {

	public static void main(String[] args) {
		KCombination kc = new KCombination();
	
		int [] digits = {1,2,3,4,5};
		int k = 3;
		kc.genCombination(digits, k);
	}
	
	public int genCombination(int [] digits, int k) {
		
		if (digits == null || digits.length < 1) {
			return 0;
		}
		
		int pos = 0;
		int index = 0;
		int [] data = new int[k];
		return genCombination(digits, k, pos, index, data);
		
	}
	
	private int genCombination(int [] digits, int k, int pos, int index, int [] data) {
		
		if (pos == k) {
			System.out.println(Arrays.toString(data));
			return 1;
		}
		
		if (index >= digits.length) {
			return 0;
		}
		
		int count = 0;
		
		data[pos] = digits[index];
		//including key at position digits[index]
		count += genCombination(digits, k, pos+1, index+1, data);
		
		//excluding key at position digits[index]
		count += genCombination(digits, k, pos, index+1, data);
		
		return count;
	}
	
	
}
