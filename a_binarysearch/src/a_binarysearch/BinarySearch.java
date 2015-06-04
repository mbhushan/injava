/*
 * @author: manib
 */
package a_binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {

	private static int [] A;
	private static int key;
	
	public static void main(String [] args) {
		System.out.println("Enter search array: ");
		readInput();
		printArray(A);
		System.out.println("Enter search key: ");
		readKey();
		int index = binarySearch(A, key);
		if (index >= 0) {
			System.out.println("Key is present at index: " + index);
		} else {
			System.out.println("Key is not present in the array!");
		}
		
	}
	
	public static void readKey() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = br.readLine().trim();
			key = Integer.parseInt(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/**
 * Iterative version of the binary Search	
 */
	public static int binarySearch(int [] A, int key) {
		int low = 0;
		int high = A.length;
		
		while (low <= high) {
			int mid = low + (high - low)/2;
			if (key == A[mid]) {
				return mid;
			} else if (key < A[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	
	public static void printArray(int [] data) {
		if (data == null) {
			return ;
		}
		for (int i=0; i<data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
	
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
/**
Enter search array: 
2 4 6 8 10
2 4 6 8 10 
Enter search key: 
8
Key is present at index: 3
=============================
Enter search array: 
2 4 6 8 10 12 14
2 4 6 8 10 12 14 
Enter search key: 
2
Key is present at index: 0
*/
