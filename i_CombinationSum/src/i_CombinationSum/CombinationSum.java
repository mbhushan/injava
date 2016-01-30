package i_CombinationSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		int[] X = { 10, 1, 2, 7, 6, 1, 5 };
		ArrayList<Integer> A = new ArrayList<Integer>();
		for (int i = 0; i < X.length; i++) {
			A.add(X[i]);
		}
		int target = 8;
		ArrayList<ArrayList<Integer>> Result = combinationSum2(A, target);
		for (ArrayList<Integer> R : Result) {
			System.out.println(R);
		}
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> num, int target) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    if(num == null || num.size() == 0)
	        return result;
	 
	    Collections.sort(num);
                    
	 
	    ArrayList<Integer> temp = new ArrayList<Integer>();    
	    getCombination(num, 0, target, temp, result);
	 
	    HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(result);
	 
	    //remove duplicate lists
	    result.clear();
	    result.addAll(set);
	 
	    return result;
	}
	
	
	private static void getCombination(ArrayList<Integer> num, int start, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result){
	    if(target == 0){
	        ArrayList<Integer> t = new ArrayList<Integer>(temp);
	        result.add(t);
	        return;
	    }
	 
	    for(int i=start; i<num.size(); i++){
	        if(target < num.get(i).intValue())
	            continue;
	 
	        temp.add(num.get(i).intValue());
	        getCombination(num, i+1, target-num.get(i).intValue(), temp, result);
	        temp.remove(temp.size()-1);
	    }
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> candidates, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(candidates.size() == 0) return ret;
Collections.sort(candidates);
        
        combinationSumHelper(candidates, target, 0, 0, ret, list);
        
        return ret;
    }

//	public static ArrayList<ArrayList<Integer>> combinationSum1(
//			ArrayList<Integer> candidates, int target) {
//		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//
//		if (candidates == null || candidates.size() == 0)
//			return result;
//
//		ArrayList<Integer> current = new ArrayList<Integer>();
//		Collections.sort(candidates);
//
//		combinationSum(candidates, target, 0, current, result);
//
//		return result;
//	}

	public static void combinationSumHelper(ArrayList<Integer>  input, int target, int start,
			int sum, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> list) {
		if (sum > target)
			return;// Note: This method cannot finish large set if this line is
					// missing
		for (int i = start; i < input.size(); i++) {
			list.add(input.get(i));
			sum += input.get(i).intValue();
			if (sum == target) {
				ret.add(new ArrayList<Integer>(list));
				sum -= list.get(list.size() - 1);
				list.remove(list.size() - 1);
				return;
			}

			if (sum < target) {
				combinationSumHelper(input, target, i, sum, ret, list);
			} else {
				combinationSumHelper(input, target, i + 1, sum, ret, list);
			}

			sum -= list.get(list.size() - 1);
			list.remove(list.size() - 1);
		}

		return;
	}

//	public static void combinationSum(ArrayList<Integer> candidates,
//			int target, int j, ArrayList<Integer> curr,
//			ArrayList<ArrayList<Integer>> result) {
//		if (target == 0) {
//			ArrayList<Integer> temp = new ArrayList<Integer>(curr);
//			result.add(temp);
//			return;
//		}
//
//		for (int i = j; i < candidates.size(); i++) {
//			if (target < candidates.get(i).intValue())
//				return;
//
//			curr.add(candidates.get(i));
//			combinationSum(candidates, target - candidates.get(i).intValue(),
//					i, curr, result);
//			curr.remove(curr.size() - 1);
//		}
//	}
}
