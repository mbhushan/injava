package math_Power;

public class Power {

	public static void main(String[] args) {
		Power P = new Power();
		int [] X = {2,3,4,5,6,7,8,9};
		int [] N = {9, 8, 7, 6, 5, 4, 3, 2, 2};
		
		for (int i=0; i<X.length; i++) {
			System.out.println(X[i] + "^" + N[i] + " = " + P.power(X[i], N[i]));
		}
		
	}
	
	public double power(double x, int n) {
		if (n == 0)
			return 1;
	 
		double v = power(x, n / 2);
	 
		if (n % 2 == 0) {
			return v * v;
		} else {
			return v * v * x;
		}
	}
}
