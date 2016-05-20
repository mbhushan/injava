package pc_CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum CS = new CombinationSum();
		
		int [] A = {2,3,6,7};
		int target = 9;
		ArrayList<ArrayList<Integer>> result = CS.combinationSum(A, target);
		for (ArrayList<Integer> R: result) {
			for (Integer r: R) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<Integer>> combinationSum(int [] A, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		if (A == null || A.length == 0) {
			return result;
		}
		
		Arrays.sort(A);
		
		ArrayList<Integer> current = new ArrayList<Integer>();
		combinationSum(A, target, 0, result, current);
		
		return result;
	}
	
	private void combinationSum(int [] A, int target, int start, ArrayList<ArrayList<Integer>> result , ArrayList<Integer> current) {
		if (target == 0) {
			ArrayList<Integer> temp = new ArrayList<Integer>(current);
			result.add(temp);
			return;
		}
		
		for (int i=start; i<A.length; i++) {
			if (target < A[i]) {
				return;
			}
			
			current.add(A[i]);
			combinationSum(A, target - A[i], i, result, current);
			current.remove(current.size()-1);
		}
	}
	
	
}
