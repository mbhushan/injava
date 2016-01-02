package i_ReverseBits;

public class ReverseBits {

	public static long reverse(long a) {
		long y = 0;
	    for (int i = 0; i < 32 ; ++i) {
	        y <<= 1;       // make space
	        y |= (a & 1);  // copy LSB of X into Y
	        a >>>= 1;      // shift X right
	    }
	    return y;
	}
	
	public static void main(String[] args) {
		long a = 3;
		System.out.println("reverse: " + reverse(a));
	}
}
