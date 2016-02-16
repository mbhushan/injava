package i_CombinationSum1;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSum {
	
	 public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer>  candidates, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        if(candidates.size() == 0) return ret;
	        Collections.sort(candidates);
	        
	        combinationSumHelper(candidates, target, 0, 0, ret, list);
	        
	        return ret;
	    }
	    
	    public void combinationSumHelper(ArrayList<Integer>  input, int target, int start, int sum,
	                                    ArrayList<ArrayList<Integer>> ret,
	                                    ArrayList<Integer> list) {
	        if(sum > target) return;// Note: This method cannot finish large set if this line is missing
	        for(int i = start; i < input.size(); i++) {
	            list.add(input.get(i).intValue());
	            sum += input.get(i).intValue();
	            if(sum == target) {
	                ret.add(new ArrayList<Integer>(list));
	                sum -= list.get(list.size() - 1);
	                list.remove(list.size() - 1);
	                return;
	            }

	            if(sum < target) {
	                combinationSumHelper(input, target, i, sum, ret, list);
	            } else {
	                combinationSumHelper(input, target, i+1, sum, ret, list);
	            }

	            sum -= list.get(list.size() - 1);
	            list.remove(list.size() - 1);
	        }
	        
	        return;
	    }

	public ArrayList<ArrayList<Integer>> combinationSum1(ArrayList<Integer> candidates, int target) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
	    if(candidates == null || candidates.size() == 0) return result;
	 
	    ArrayList<Integer> current = new ArrayList<Integer>();
	    Collections.sort(candidates);
	 
	    combinationSum1(candidates, target, 0, current, result);
	 
	    return result;
	}
	 
	public void combinationSum1(ArrayList<Integer>  candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result){
	   if(target == 0){
	       ArrayList<Integer> temp = new ArrayList<Integer>(curr);
	       result.add(temp);
	       return;
	   }
	 
	   for(int i=j; i<candidates.size(); i++){
	       if(target < candidates.get(i).intValue()) 
	            return;
	 
	       curr.add(candidates.get(i).intValue());
	       combinationSum1(candidates, target - candidates.get(i).intValue(), i, curr, result);
	       curr.remove(curr.size()-1); 
	   }
	}
}
