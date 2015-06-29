package a_SortExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortTemplate {

	public static void main(String [] args) {
		String [] inputs = readInput();
		System.out.println("Input values: ");
		printValues(inputs);
		sort(inputs);
		assert isSorted(inputs);
		System.out.println("Sorted values:");
		printValues(inputs);
	}
	
	public static void sort(Comparable [] A) {
		for (int i=0; i<A.length-1; i++) {
			for (int j=i+1; j<A.length; j++) {
				if (less(A[j], A[i])) {
					exchange(A, i, j);
				}
			}
		}
	}
	
	public static boolean isSorted(Comparable [] A) {
		if (A == null || A.length <= 1) {
			return true;
		}
		
		for (int i=1; i<A.length; i++) {
			if (less(A[i], A[i-1])) {
				return false;
			}
		}
		return true;
		
	}
	
	private static void exchange(Comparable [] A, int i, int j) {
		Comparable t = A[i];
		A[i] = A[j];
		A[j] = t;
	}
	
	private static boolean less(Comparable x, Comparable y) {
		return x.compareTo(y) < 0;
	}
	
	private static void printValues(Comparable [] A) {
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	public static String [] readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] inputs = null;
		try {
			inputs = br.readLine().trim().split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputs;
	}
}
