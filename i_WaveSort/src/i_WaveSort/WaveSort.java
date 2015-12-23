package i_WaveSort;

import java.util.ArrayList;
import java.util.Collections;

public class WaveSort {
	
	public static ArrayList<Integer> wave(ArrayList<Integer> a) {
		
		Collections.sort(a);
		printList(a);
		
		int n = a.size();
		for (int i=0; i<n-1; i+=2) {
			int temp = a.get(i);
			a.set(i, a.get(i+1));
			a.set(i+1, temp);
		}
		System.out.println("after wave sort: ");
		printList(a);
		return null;
	}
	
	private static void printList(ArrayList<Integer> a) {
		for (Integer i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String [] args) {
		// Integer [] A = {4, 3, 2, 1};
		Integer [] A = {5, 1, 3, 2, 4 };
		
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int index = 0; index < A.length; index++) {
			X.add(A[index]);
		 }
		
		wave(X);
		
	}

}
