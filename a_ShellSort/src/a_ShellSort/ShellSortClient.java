package a_ShellSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellSortClient {

	public static void main(String [] args) {
		
		System.out.println("Input data: ");
		Integer [] A = readInput();
		System.out.println("Sorting input..");
		ShellSort.sort(A);
		System.out.println("After shell sorting:");
		ShellSort.show(A);
	}
	
	public static Integer [] readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer [] A = null;
		try {
			String [] strArr = br.readLine().trim().split(" ");
			int n = strArr.length;
			A = new Integer[n];
			for (int i=0; i<n; i++) {
				A[i] = Integer.parseInt(strArr[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return A;
	}
}
/*
Input data: 
9 8 7 6 5 4 3 2 1 10
Sorting input..
After shell sorting:
1 2 3 4 5 6 7 8 9 10 
*/