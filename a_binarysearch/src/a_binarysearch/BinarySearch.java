package a_binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {

	private static int [] A;
	public static void main(String [] args) {
		readInput();
		printArray(A);
	}
	
	/*
	 * print the int array
	 */
	public static void printArray(int [] data) {
		if (data == null) {
			return ;
		}
		for (int i=0; i<data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
	/*
	 * read input integers and store in array.
	 */
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String [] str = br.readLine().split(" ");
			int len = str.length;
			A = new int[len];
			for (int i=0; i<len; i++) {
				A[i] = Integer.parseInt(str[i]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
