package i_Rearrange;

import java.util.ArrayList;

public class Rearrange {
	
	public static void arrange(ArrayList<Integer> a) {
		// First step: Increase all values by (arr[arr[i]]%n)*n
		int n = a.size();
	    for (int i=0; i < n; i++) {
	        a.set(i, a.get(i) + (a.get(a.get(i))%n)*n);
	    }
	 
	    // Second Step: Divide all values by n
	    for (int i=0; i<n; i++) {
	        a.set(i, a.get(i) /n);
	    }
	    printList(a);
	}
	
	private static void printList(ArrayList<Integer> A) {
		int n = A.size();
		for (int i=0; i<n; i++) {
			System.out.print(A.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void main(String [] args) {
		//int [] A = {3, 2, 0, 1};
		int [] A = {4, 0, 2, 1, 3};
		ArrayList<Integer> X = new ArrayList<Integer> ();
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		arrange(X);
	}

}
