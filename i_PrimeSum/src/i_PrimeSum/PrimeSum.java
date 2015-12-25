package i_PrimeSum;

import java.util.ArrayList;
import java.util.BitSet;

public class PrimeSum {

	public static ArrayList<Integer> primesum(int a) {

	    BitSet isPrime = new BitSet(a+1); 
	         
	    for (int i=2; i<=a; i++) {
	    	isPrime.set(i);
	    }
	    // Sieve of Erastothenes
	    for(int i = 2; i <= a; i++) {
	        if (!isPrime.get(i)) continue;
	        if (i > a / i) break;
	        for (int j = i * i; j <= a; j += i) {
	        	isPrime.set(j, false);
	        }
	    }

	    ArrayList<Integer> result = new ArrayList<Integer>(); 
	    for(int i = 2; i <= a; ++i) {
	    	result = new ArrayList<Integer>();
	        if(isPrime.get(i) && isPrime.get(a-i)) {
	        	result.add(i);
	        	result.add(a-i);
	        	break;
	            //return result;
	        }
	    } 
	         
	    printList(result);
	    return result;
    }
	
	private static void printList(ArrayList<Integer> A) {
		int n = A.size();
		for (int i=0; i<n; i++) {
			System.out.print(A.get(i) + " ");
		}
		System.out.println("done!");
	}
	
	public static void main(String [] args) {
		int [] A = {4, 6, 8, 10, 12, 100};
		for (int i=0; i<A.length; i++) {
			primesum(A[i]);
			
		}
	}
}
