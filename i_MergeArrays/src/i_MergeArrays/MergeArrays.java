package i_MergeArrays;

import java.util.ArrayList;

public class MergeArrays {

	public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		
		int m = a.size();
		int n = b.size();
		int i = m-1;
		int j = n-1;
		a.addAll(b);
		int p = a.size();
		int k = p-1;
		
		while (i >=0 && j >= 0) {
			if (a.get(i) >= b.get(j)) {
				a.set(k, a.get(i));
				--i;
				--k;
			} else if (a.get(i) < b.get(j)) {
				a.set(k, b.get(j));
				--k;
				--j;
			} 
		}
		while (i >= 0) {
			a.set(k, a.get(i));
			--i;
			--k;
		}
		while (j >= 0) {
			a.set(k, b.get(j));
			--j;
			--k;
		}
		printList(a);
		return ;
	}
	
	private static void printList(ArrayList<Integer> A) {
		int n = A.size();
		for (int i=0; i<n; i++) {
			System.out.print(A.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int [] A = {1,5,8};
		int [] B = {6,9};
		
		ArrayList<Integer> X = new ArrayList<Integer>();
		ArrayList<Integer> Y = new ArrayList<Integer>();
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		for (int i=0; i<B.length; i++) {
			Y.add(B[i]);
		}
		
		merge(X, Y);
	}
}
