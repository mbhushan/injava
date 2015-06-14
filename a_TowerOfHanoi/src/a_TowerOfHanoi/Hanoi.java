package a_TowerOfHanoi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hanoi {

	private static int N = 2;
	
	public static void main(String [] args) {
		System.out.println("Number of discs: ");
		readInput();
		solveHanoi(N, 'A', 'B', 'C');
	}
	
	public static void solveHanoi(int n, char A, char B, char C) {
		if (n == 1) {
			System.out.println("Disk 1 from " + A + " to " + C);
		} else {
			solveHanoi(n-1, A, C, B);
			System.out.println("Disk " + n + " from " + A + " to " + C);
			solveHanoi(n-1, B, A, C);
		}
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String st = br.readLine().trim();
			N = Integer.parseInt(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
