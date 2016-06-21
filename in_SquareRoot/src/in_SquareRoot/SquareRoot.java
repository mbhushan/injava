package in_SquareRoot;

public class SquareRoot {

	public static void main(String[] args) {
		SquareRoot sr = new SquareRoot();
		
		for (int i=1; i<=100; i++) {
			System.out.println(i + " sqrt: " + sr.sqrt(i));
		}
	}
	
	public double sqrt(double num) {
		double guess = num/2;
		
		int i = 0;
		while (i < 1000) {
			guess = (0.5) * (guess + num/guess);
			++i;
		}
		return guess;
	}
}
