import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SinCos {
	public static void main(String [] args) {
		// Theta is in radians.
		double theta = Math.PI/3.0;
		theta = readInput();
		double result = doMath(theta);
		System.out.println("Result: " + result);
	}
	
	public static double doMath(double theta) {
		double result = Math.pow(Math.sin(theta), 2) + Math.pow(Math.cos(theta), 2);
		return result;
	}

	public static double readInput() {
		System.out.println("Enter the value in radians below: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = "";
		try {
			in = br.readLine().trim();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Double.parseDouble(in);
	}

}
