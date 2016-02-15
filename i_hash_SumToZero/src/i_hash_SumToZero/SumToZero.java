package i_hash_SumToZero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SumToZero {
	
	public static void main(String[] args) {
		//Integer [] X = {1 ,2 ,-2 ,4 ,-4};
		//Integer [] X = {4,  6,  3, -9, -5, 1, 3, 0, 2};
		//Integer [] X = {0, 1, -1, 0};
		//Integer [] X = {-19, 8, 2, -8, 19, 5, -2, -23};
		//Integer [] X = {-1, 1, 1, -1, -1, 1, 1, -1};
		Integer [] X = { -8, 8, -1, -16, -28, -27, 15, -14, 14, -27, -5, -6, -25, -11, 28, 29, -3, -25, 17, -25, 4, -20, 2, 1, -17, -10, -25 };
		ArrayList<Integer> A = new ArrayList<Integer>();
		Collections.addAll(A, X);
		
		for (int i: X) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		ArrayList<Integer> result = lszero(A);
		for (Integer a: result) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
		
		 HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
		 ArrayList<Integer> result = new ArrayList<Integer>();
         
	        // Initialize sum of elements
	        int sum = 0;      
	        int N = A.size();
	        int start = 0;
	        int end = 0;
	        int fstart = -1;
	        int fend = -1;
	        int maxLen = Integer.MIN_VALUE;
	         
	        // Traverse through the given array
	        for (int i = 0; i < N; i++)
	        {   
	            // Add current element to sum
	            sum += A.get(i).intValue();
	            end = i;
	            System.out.println("sum: " + sum); 
	            // Return true in following cases
	            // a) Current element is 0
	            // b) sum of elements from 0 to i is 0
	            // c) sum is already present in hash map
	            if (sum == 0) {
	            	if (i == N-1) {
	            		fstart = 0;
	            		fend = N-1;
	            		break;
	            	}
	            	if ((end - start) > maxLen) {
	            		fstart = start;
	            		fend = end;
	            		maxLen = end - start;
	            	}
	            }
	            if (hM.containsKey(sum)) {
	            	start = hM.get(sum).intValue();
	            	if (A.get(start).intValue() == 0) {
	            		if ((end - start) > maxLen) {
	            			fstart = start;
	            			fend = end;
	            			maxLen = end - start;
	            		}
	            	} else {
	            		if ((end - start) > maxLen) {
	            			if (start > 0) {
	            				if ((end - start - 1) > maxLen) {
	            					fstart = start+1;
	    	            			fend = end;
	    	            			maxLen = end - start -1;
	            				}
	            			} else {
	            			fstart = start+1;
	            			fend = end;
	            			maxLen = end - start;
	            			}
	            		}
	            	}
	            }
	            //if (A.get(i).intValue() == 0 || sum == 0 || hM.get(sum) != null)   {                          
	           // }
	             
	            // Add sum to hash map
	            if (!hM.containsKey(sum)) {
	            	hM.put(sum, i);
	            }
	            //System.out.println("A[i]: " + A.get(i));
	            System.out.println("maxLen: " + maxLen);
	            System.out.println("start: end = " + start + ": " + end );
	            System.out.println("fstart: fend = " + fstart + ": " + fend);
	        }    
	        
	        if (fstart == -1) {
	        	return result;
	        }
	        
	        for (int i=fstart; i<=fend; i++) {
	        	result.add(A.get(i).intValue());
	        }
	         
	        // We reach here only when there is no subarray with 0 sum
	        return result;
    }
}
