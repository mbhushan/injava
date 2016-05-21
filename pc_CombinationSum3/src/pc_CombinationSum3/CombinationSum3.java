package pc_CombinationSum3;

import java.util.ArrayList;

/*
 Find all possible combinations of k numbers that add up to a number n, 
 given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.

Example 1: Input: k = 3, n = 7 Output: [[1,2,4]]
Example 2: Input: k = 3, n = 9 Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSum3 {

	public static void main(String[] args) {
		CombinationSum3 CS = new CombinationSum3();
		int k = 3;
		int sum = 9;
		
		ArrayList<ArrayList<Integer>> result = CS.combinationSum(sum, k);
		for (ArrayList<Integer> R: result) {
			for (Integer r: R) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<Integer>> combinationSum(int sum, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		dfs(sum, k, 1, result, temp);
		return result;
	}
	
	private void dfs(int sum, int k, int start, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
		if (sum == 0 && temp.size() == k) {
			ArrayList<Integer> list = new ArrayList<Integer>(temp);
			result.add(list);
		}
		
		for (int i=start; i<=9; i++) {
			if (sum < i) {
				break;
			}
			if (temp.size() > k) {
				break;
			}
			temp.add(i);
			dfs(sum-i, k, i+1, result, temp);
			temp.remove(temp.size()-1);
		}
	}
}
