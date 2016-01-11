package i_PowerMod;

public class PowerMod {

	public static int pow(int x, int n, int d) {
		if (x == 0 || x == 1) {
			return x;
		}
		long y = x % d;
		long num = 1;
		
		while (n > 0) {
			if (n%2 == 1) {
				num = num * y;
				num = num % d;
			}
			n = n / 2;
			y = (y * y) % d; 
		}
		
		if (num < 0) {
			num = num + d;
		}
		return (int)num;
	}
	
	public static void main(String[] args) {
		int x = 71045970;
		int n = 41535484;
		int d = 64735492;
		
		System.out.println(x + "^" + n + " % " + d + ": " + pow(x, n, d));
	}
}
