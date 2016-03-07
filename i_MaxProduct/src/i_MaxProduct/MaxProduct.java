package i_MaxProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxProduct {
	
	public static void main(String[] args) {
		Integer [] X = {2,3,-2,4};
		List<Integer> a = new ArrayList<Integer>();
		Collections.addAll(a, X);
		System.out.println("max product: " + maxProduct(a));
	}

	public static int maxProduct(final List<Integer> a) {
		int size = a.size();
		int [] A = new int[size];
		for (int i=0; i<size; i++) {
			A[i] = a.get(i).intValue();
		}
		if(A==null || A.length==0)  
	        return 0;  
	 
	    int maxLocal = A[0];  
	    int minLocal = A[0];  
	    int global = A[0];  
	 
	    for(int i=1; i<A.length; i++){  
	        int temp = maxLocal;  
	        maxLocal = Math.max(Math.max(A[i]*maxLocal, A[i]), A[i]*minLocal);  
	        minLocal = Math.min(Math.min(A[i]*temp, A[i]), A[i]*minLocal);  
	        global = Math.max(global, maxLocal);  
	    }  
	    return global;
	}
}
