

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Factorial {

	private static int N;
	
	public static void main(String [] args) {
		System.out.print("Enter integer n: ");
		readInput();
//		System.out.println();
		long fact = factorialRecursive(N);
		System.out.println(N + "! recursive is: " + fact);
		fact = factorialIter(N);
		System.out.println(N + "! iterative is: " + fact);
		
	}
	
	public static long factorialRecursive(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * factorialRecursive(n-1);
	}
	
	public static long factorialIter(int n) {
		long result = 1;
		for (int i=n; i>1; i--) {
			result *= i;
		}
		return result;
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = br.readLine().trim();
			N = Integer.parseInt(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
/**
 Enter integer n: 5
5! is: 120
*/