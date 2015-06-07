package a_LinearSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;


public class LinearSearch {

	private static int [] A;
	private static int N;
	private static int key;
	private static int R = 100;
	
	public static void main(String [] args) {
		System.out.print("How many elements? ");
		readNum();
		populateArray();
		printArray();
		System.out.print("Enter Key:");
		readKey();
		int index = linearSearch(A, key);
		if (index >= 0) {
			System.out.println(key + " is present at index: " + index);
		} else {
			System.out.println(key + " not found in data set!!");
		}
	}
	
	public static int linearSearch(int [] numArr, int key) {
		if (numArr == null) {
			return -1;
		}
		for (int i=0; i < numArr.length; i++) {
			if (key == numArr[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public static void printArray() {
		for (int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	
	public static void populateArray() {
		Random rand = new Random();
		A = new int[N];
		for (int i=0; i<N; i++) {
			A[i] = rand.nextInt(R);
		}
		
	}

	public static void readKey() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			key = Integer.parseInt(br.readLine().trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void readNum() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine().trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/**
 * sample input output:
How many elements? 15
67 28 52 30 66 14 71 65 68 91 46 9 31 76 99 
Enter Key:67
67 is present at index: 0
*/