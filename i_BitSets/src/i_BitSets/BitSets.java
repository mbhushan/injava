package i_BitSets;

public class BitSets {

	public static int numSetBits(long a) {
		int count = 0;
		while (a > 0) {
			a &= (a - 1);
			count++;
		}
		return count;
	}
	
	public static void main(String [] args) {
		long n = 10;
		for (int i=0; i<n; i++) {
			System.out.println(i + ": " + numSetBits(i));
		}
	}
}
