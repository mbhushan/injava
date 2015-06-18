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
		System.out.println("triplets which sum to ZERO");
		threeSumZero(A);
	}
	
	//print all the triplets such that A[i] + A[j] + A[k] = 0
	public static void threeSumZero(int [] arr) {
		int n = arr.length;
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				for (int k=j+1; k<n; k++) {
					if ((arr[i] + arr[j] + arr[k]) == 0) {
						System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
					}
				}
			}
		}
	
	}

	//print the array elements.
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
/**
8
  30
 -30
 -20
 -10
  40
   0
  10
  15
Elements in the array: 
30 -30 -20 -10 40 0 10 15 
triplets which sum to ZERO
30 -30 0
30 -20 -10
-30 -10 40
-10 0 10
*/