package i_RevInt;

public class RevInt {
	public static int reverse(int a) {
		boolean isneg = false;
		if (a < 0) {
			isneg = true;
			a = Math.abs(a);
		}
		int n = a;
		long rev = 0;
		 while (n > 0)
		 {
		      int dig = n % 10;
		      rev = rev * 10 + dig;
		      // check for overflow
		      if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
		    	  return 0;
		      }
		      n = n / 10;
		 }
		 if (isneg) {
			 rev = -rev;
		 }
		return (int)rev;
	}
	
	public static void main(String [] args) {
		int [] A = {443, 890, -123, 2147483647, -1146467285};
		for (int i=0; i<A.length; i++) {
			System.out.println(A[i] + " reversed: " + reverse(A[i]));
		}
	}

}
