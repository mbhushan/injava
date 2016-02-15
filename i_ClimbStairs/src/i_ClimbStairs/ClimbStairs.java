package i_ClimbStairs;

public class ClimbStairs {

	public static void main(String[] args) {
		int a = 3;
		System.out.println("stairs: " + climbStairs(a));
	}
	
	public static int climbStairs(int a) {
		return fib(a+1);
	}

	private static int fib(int n) {
		int a = 0, b = 1, c = 0;
		if (n == 0)
			return a;
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
}
