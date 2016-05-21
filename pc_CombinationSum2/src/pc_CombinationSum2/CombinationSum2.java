package pc_CombinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CombinationSum2 {

	public static void main(String[] args) {
		CombinationSum2 CS = new CombinationSum2();
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

		ArrayList<Integer> temp = new ArrayList<Integer>();
		combinationSum(A, target, 0, temp, result);
		
		HashSet<ArrayList<Integer>> hset = new HashSet<ArrayList<Integer>>(result);
		
		//remove duplicate lists
		result.clear();
		result.addAll(hset);
		
		return result;
		
		
	}
	
	private void combinationSum(int [] A, int target, int start, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result) {
		if (target == 0) {
			ArrayList<Integer> list = new ArrayList<Integer>(temp);
			result.add(list);
			return ;
		}
		
		for (int i=start; i<A.length; i++) {
			if (target < A[i]) {
				continue;
			}
			temp.add(A[i]);
			combinationSum(A, target-A[i], i+1, temp, result);
			temp.remove(temp.size()-1);
		}
	}
}
