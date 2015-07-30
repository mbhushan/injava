package a_MergeSort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MergeSortClient {
	
	private static Integer [] A;
	
	public static void main(String [] args) {
		readInput();
		MergeSort.mergeSort(A);
		System.out.println("After applying merge sort on input data..");
		MergeSort.showData(A);
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String [] ins = br.readLine().trim().split(" ");
			int n = ins.length;
			A = new Integer[n];
			for (int i=0; i<n; i++) {
				A[i] = Integer.parseInt(ins[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
