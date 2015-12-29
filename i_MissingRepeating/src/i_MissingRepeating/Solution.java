package i_MissingRepeating;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Solution {

	public static ArrayList<Integer> repeatedNumber(final List<Integer> a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int n = a.size();
    	BitSet bits = new BitSet(n+1);
    	
    	for (int i=0; i<n; i++) {
    		if (!bits.get(a.get(i))) {
    			bits.set(a.get(i));
    		} else {
    			result.add(a.get(i));
    		}
    	}
    	int len = bits.length();
    	for (int i=1; i<len; i++) {
    		if (!bits.get(i)) {
    			result.add(i);
    		}
    	}
    	
    	return result;
	}
	
	public static ArrayList<Integer> repeatMissing(final List<Integer> a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		int xors = 0;
		int n = a.size();
		
		for (int i=0; i<n; i++) {
			xors = xors ^ a.get(i);
		}
		
		for (int i=1; i<=n; i++) {
			xors = xors ^ i;
		}
		
		int setBitNum = xors & ~ (xors-1);
		
		int x = 0;
		int y = 0;
		   
		for (int i=0; i<n; i++) {
			if((a.get(i) & setBitNum) > 0) {
		           x = x ^ a.get(i);  
			} else {
		           y = y ^ a.get(i);  
			}
		}
		
		for(int i = 1; i <= n; i++) {
		      if((i & setBitNum) > 0) {
		          x = x ^ i;  
		      } else {
		          y = y ^ i;  
		      }
		}
		result.add(x);
		result.add(y);
		return result;
	}
	
	public static void main(String [] args) {
		int [] A = {3, 1, 2, 5, 3};
		
		ArrayList<Integer> X = new ArrayList();
		
		for (int index = 0; index < A.length; index++) {
			X.add(A[index]);
		 }
		
		//X = repeatedNumber(X);
		X = repeatMissing(X);
		
		for (int i=0; i<X.size(); i++) {
			System.out.print(X.get(i) + " ");
		}
		System.out.println();
	}
}
