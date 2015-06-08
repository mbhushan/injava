package a_Fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
	
	private static int N;

	public static void main(String [] args) {
		readInput();
		for (int i=1; i<=N; i++) {
			System.out.print(fibonacci(i) + " ");
		}
		System.out.println();
		
	}
	
	public static int fibonacci(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = br.readLine().trim();
			N = Integer.parseInt(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/**
Sample input output:
10
1 1 2 3 5 8 13 21 34 55 
*/