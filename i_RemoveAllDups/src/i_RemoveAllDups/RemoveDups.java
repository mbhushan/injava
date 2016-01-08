package i_RemoveAllDups;

import java.util.ArrayList;

public class RemoveDups {

	public static int removeDuplicates(ArrayList<Integer> a) {
		int ptr = 0;
		int len = a.size();
		if (len < 2) {
			return len;
		}
		for (int i=1; i<len; i++) {
			if (!a.get(i).equals(a.get(ptr))) {
				a.set(++ptr, a.get(i));
			}
		}
		
		System.out.println("ptr: " + ptr);
		printList(a);
		a.subList(ptr+1, len).clear();
		printList(a);
		return ptr;
	}
	
	private static void printList(ArrayList<Integer> A) {
		int n = A.size();
		
		for (int i=0; i<n; i++) {
			System.out.print(A.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void main(String [] args) {
		int [] A = {1,1,1,2,2,3};
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		removeDuplicates(X);
	}
}
