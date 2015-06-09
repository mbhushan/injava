

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCD {
	
	private static int a;
	private static int b;

	public static void main(String [] args) {
		readInput();
		int gcd = gcdRec(a, b);
		System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
		
	}
	
	public static int gcdRec(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcdRec(b, a%b);
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String [] strs = br.readLine().split(" ");
			if (strs.length == 2) {
				a = Integer.parseInt(strs[0].trim());
				b = Integer.parseInt(strs[1].trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/**
Sample input/outpu:
102 68
GCD of 102 and 68 is: 34
*/
