package i_SubsetDuplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetGeneration {
	
	public static void main(String[] args) {
		int [] X = {1,2,2};
		ArrayList<Integer> A = new ArrayList<Integer>();
		for (int i=0; i<X.length; i++) {
			A.add(X[i]);
		}
		//ArrayList<ArrayList<Integer>> result = subsetsWithDup(A);
		ArrayList<ArrayList<Integer>> result = subsetsWithDup(A);
		for (ArrayList<Integer> R : result) {
			System.out.println(R);
		}
	}
	
	private static ArrayList<ArrayList<Integer>> subsetsHelper(ArrayList<Integer> num, int cur,  
		     ArrayList<Integer> path, ArrayList<ArrayList<Integer>> results) {  
		   results.add(path);  
		   for (int i=cur; i<num.size(); ++i) {  
		     // skip duplicates  
		     if (i > cur && num.get(i).intValue() == num.get(i-1).intValue())  
		       continue;  
		     ArrayList<Integer> result = new ArrayList<Integer>(path);  
		     result.add(num.get(i).intValue());  
		     results = subsetsHelper(num, i+1, result, results);  
		   }  
		   return results;  
		 }  
		   
		 public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> num) {  
			 Collections.sort(num);  
		   return subsetsHelper(num, 0, new ArrayList<Integer>(), new ArrayList<ArrayList<Integer>>());  
		 } 

	public static ArrayList<ArrayList<Integer>> subsetsWithDup1(ArrayList<Integer> num) {
		// sort the given set  
		   Collections.sort(num);  
		   // generate subsets  
		   ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();   
		   results.add(new ArrayList<Integer>());   
		   int count = 0;   
		   int len = num.size();
		   for (int i=0; i<len; ++i) {   
		     int curSize = results.size();   
		     // count duplicates   
		     if (i > 0 && num.get(i).intValue() == num.get(i-1).intValue()) {   
		       ++count;   
		     } else {   
		       count = 0;   
		     }  
		     // append to previous subsets   
		     while (curSize-- > 0) {   
		       ArrayList<Integer> res = new ArrayList<Integer>();   
		       ArrayList<Integer> pre = results.get(curSize);   
		       // for duplicates, only append to subsets containing all previous duplicates   
		       if (count > 0 && (pre.size() < count || pre.get(pre.size()-count) != num.get(i).intValue()))  
		         continue;   
		       res.addAll(pre);   
		       res.add(num.get(i).intValue());   
		       results.add(res);   
		     }   
		   }   
		   //Collections.sort(result);
		   return results;   
	}
}
