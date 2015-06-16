package a_ThreeSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ThreeSum {
	
	private static int [] A;
	private static int N;
	public static void main(String [] args) {
		readInput();
		System.out.println("Elements in the array: ");
		printArray(A);
	}
	
	//print all the triplets such that A[i] + A[j] + A[k] = 0
	public static void threeSumZero(int [] arr) {
		
	
	}
	
	public static void printArray(int [] arr) {
		if (null == arr) {
			return;
		}
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String st = br.readLine().trim();
			N = Integer.parseInt(st);
			A = new int[N];
			for (int i=0; i<A.length; i++) {
				A[i] = Integer.parseInt(br.readLine().trim());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
