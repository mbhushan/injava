package math_ReverseInteger;

public class ReverseInteger {

	
	public static void main(String[] args) {
		ReverseInteger RI = new ReverseInteger();
		
		int [] data = {1234, 3423, 2341, -1234};
		
		for (int i=0; i<data.length; i++) {
			System.out.println(data[i] + ": " + RI.reverseInteger(data[i]));
		}
	}
	
	public int reverseInteger(int n) {
		boolean isNegative = false;
		if (n < 0) {
			n = 0 - n;
			isNegative = true;
		}
		int res = 0;
		int ptr = n;
		while (ptr > 0) {
			int mod = ptr % 10;
			ptr = ptr/10;
			res = res * 10 + mod;
		}
		
		if (isNegative) {
			res = 0 - res;
		}
		return res;
	}
	
	
}
