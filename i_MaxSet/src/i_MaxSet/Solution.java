package i_MaxSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    ArrayList<Integer> tmp = new ArrayList<Integer>();
	    
	    for (int i=0; i<a.size(); i++) {
	    	if (a.get(i) >= 0) {
	    		tmp.add(a.get(i));
	    	} else {
	    		if (sumList(tmp) > sumList(res)) {
	    			res = tmp;
	    		} else if(sumList(tmp) == sumList(res)) {
	    			if (tmp.size() > res.size()) {
	    				res = tmp;
	    			}
	    		}
	    		tmp = new ArrayList<Integer>();
	    	}
	    }
	    if (sumList(tmp) > sumList(res)) {
			res = tmp;
	    }
	    
	    return res;
	}
	
	private static long sumList(ArrayList<Integer> m) {
		long sum = 0;
		for(Integer d : m)
		    sum += d;
		return sum;
	}
	
	public static void main(String [] args) {
		//Integer [] ints = {1, 2, 5, -7, 2, 5};
		Integer [] ints = { 756898537, -1973594324, -2038664370, -184803526, 1424268980};
		ArrayList<Integer> a = new ArrayList();
		for (int index = 0; index < ints.length; index++)
	    {
			a.add(ints[index]);
	    }
		ArrayList<Integer> ans = maxset(a);
		for (Integer n: ans) {
			System.out.print(n + " ");
		}
	}
}