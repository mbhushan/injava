package a_HeapSort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HeapSortClient {
	private static Integer[] A;

	public static void main(String[] args) {
		readInput();
		HeapSort.sort(A);
		System.out.println("After heap sorting: ");
		showData();
	}

	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] data = br.readLine().trim().split(" ");
			int n = data.length;
			A = new Integer[n];

			for (int i = 0; i < n; i++) {
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

		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
