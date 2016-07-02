package rec_CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;

/*
* Given an input and total print all combinations with repetitions in this input
* which sums to given total.
* e.g
* input - {2,3,5}
* total - 10
*
* Output
* [2,2,2,2,2],
* [2,2,3,3],
* [2,3,5],
* [5,5]]
* Reference
* https://leetcode.com/problems/combination-sum/
*/

public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
	
		int [] digits = {2, 3, 5};
		int sum = 10;
		cs.combinationSum(digits, sum);
	}
	
	public void combinationSum(int [] digits, int sum) {
		combinationSum(digits, sum, new ArrayList<Integer>(), 0, 0);
	}
	
	private void combinationSum(int [] digits, int sum, ArrayList<Integer> buff, int k, int index) {
		if (k == sum) {
			System.out.println(buff.toString());
			return;
		}
		if (k > sum) {
			return;
		}
		if (index >= digits.length) {
			return;
		}
		
		
		k += digits[index];
		buff.add(digits[index]);
		combinationSum(digits, sum, buff, k, index);
		k -= digits[index];
		buff.remove(buff.size()-1);
		combinationSum(digits, sum, buff, k, index+1);
	}
}
