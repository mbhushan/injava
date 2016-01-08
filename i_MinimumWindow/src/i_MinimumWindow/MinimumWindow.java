package i_MinimumWindow;

import java.util.ArrayList;
import java.util.List;

public class MinimumWindow {

	public static int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
		
		int diff = Integer.MAX_VALUE;
	    int minimum = Integer.MAX_VALUE;
	    int maximum = Integer.MIN_VALUE;
	    int i = 0, j = 0, k = 0;
	    int l = a.size();
	    int m = b.size();
	    int n = c.size();
	     
	    while(i < l && j < m && k < n) {
	 
	        minimum = Math.min(a.get(i).intValue(), Math.min(b.get(j).intValue(), c.get(k).intValue()));
	        maximum = Math.max(a.get(i).intValue(), Math.max(b.get(j).intValue(), c.get(k).intValue())); 
	        diff = Math.min(diff, maximum - minimum);
	        if (diff == 0) break;
	        if (a.get(i).intValue() == minimum) i++;
	        else if (b.get(j).intValue() == minimum) j++;
	        else k++;
	    }
	     
	    return diff;
	}
	
	public static void main(String[] args) {
		int [] A = {1, 4, 10};
		int [] B = {2, 15, 20};
		int [] C = {10, 12, 30};
		
		ArrayList<Integer> X = new ArrayList<Integer>();
		ArrayList<Integer> Y = new ArrayList<Integer>();
		ArrayList<Integer> Z = new ArrayList<Integer>();
		
		int n = A.length;
		
		for (int i=0; i<n; i++) {
			X.add(A[i]);
			Y.add(B[i]);
			Z.add(C[i]);
		}
		
		System.out.println("min window: " + minimize(X, Y, Z));
		
	}
}
