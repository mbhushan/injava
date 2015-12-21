package i_CoverPoints;

import java.util.ArrayList;

public class Solution {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
    	int result = 0;
    	int n = X.size();
    	
    	for (int i=0; i<n-1; i++) {
    		int a = X.get(i) - X.get(i+1);
    		int b = Y.get(i) - Y.get(i+1);
    		//System.out.println(a + " : " + b);
    		result += Math.abs(a) > Math.abs(b) ? Math.abs(a) : Math.abs(b);
    	}
    	return result;
    }
    
    public static void main(String [] args) {
    	Integer [] A = {4, 8, -7, -5, -13, 9, -7, 8};
    	Integer [] B = {4, -15, -10, -3, -13, 12, 8, -8};
    	ArrayList<Integer> X = new ArrayList();
     	ArrayList<Integer> Y = new ArrayList();
		for (int index = 0; index < A.length; index++)
	    {
			X.add(A[index]);
			Y.add(B[index]);
	    }
		
		int result = coverPoints(X, Y);
		System.out.println("result: " + result);
    }
}
