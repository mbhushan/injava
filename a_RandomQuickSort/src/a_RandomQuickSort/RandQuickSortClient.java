package a_RandomQuickSort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RandQuickSortClient {
	
	private static Integer [] A;

	public static void main(String [] args) {
		System.out.println("Enter space separated integers:");
		readInput();
		RandomizedQuickSort.sort(A);
		System.out.println("After Randomized Quick Sorting: ");
		showData();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String [] data = br.readLine().trim().split(" ");
			int len = data.length;
			A = new Integer[len];
			for (int i=0; i<len; i++) {
				A[i] = Integer.parseInt(data[i]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void showData() {
		if (null == A) {
			return;
		}
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
