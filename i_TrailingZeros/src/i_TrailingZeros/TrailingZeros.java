package i_TrailingZeros;

public class TrailingZeros {
	public static int trailingZeroes(int a) {
		if (a < 0)
			return -1;
	 
		int count = 0;
		for (long i = 5; a / i >= 1; i *= 5) {
			count += a / i;
		}
	 
		return count;
	}
	
	public static void main(String [] args) {
		int [] A = {5, 20, 100};
		
		for (int i=0; i<A.length; i++) {
			System.out.println("trailing zeros: " + trailingZeroes(A[i]));
		}
	}
	

}
