package i_GCD;

public class GCD {
	
	public static int gcd(int a, int b) {
	    if (b == 0) {
	        return a;
	    }
	    
	    return gcd(b, a%b);
	}
	
	public static void main(String [] args) {
		int m = 6;
		int n = 9;
		m = 24;
		n = 54;
		System.out.println("gcd: " + gcd(n, m));
	}

}
