package i_Multiply;

public class Multiply {

	public static void main(String[] args) {
		String a = "234";
		String b = "0";
		System.out.println("ans: " + multiply(a, b));
	}
	public static String multiply(String a, String b) {
		if (a.length() >= b.length()) {
			return multiplyStrings(a, b);
		} else {
			return multiplyStrings(b, a);
		}
	}
	
	private static String multiplyStrings(String X, String Y) {
		StringBuffer first = new StringBuffer();
		StringBuffer second = new StringBuffer();
		int ylen = Y.length();
		int xlen = X.length();
		int carry = 0;
		int skip = 0;
		
		for (int i=ylen-1; i>=0; i--) {
			int ay = Character.getNumericValue(Y.charAt(i));
			carry = 0;
			second.setLength(0);
			
			for (int j=xlen-1; j>=0; j--) {
				int ax = Character.getNumericValue(X.charAt(j));
				int p = (ax * ay) + carry;
				int n = p % 10;
				carry = p / 10;
				second.append(n);
			}
			if (carry > 0) {
				second.append(carry);
			}
			first = sumTwoStrings(first.toString(), second.toString(), skip);
			++skip;
		}
		String result = first.reverse().toString();
		result = result.replaceFirst("^0+(?!$)", "");
		return result;
	}
	
	
	private static StringBuffer sumTwoStrings(String X, String Y, int skip) {
		StringBuffer result = new StringBuffer();
		int i = skip;
		int j = 0;
		int nx = X.length();
		int my = Y.length();
		
		for (int k=0; k<skip && k < nx; k++) {
			result.append(X.charAt(k));
		}
		
		int carry = 0;
		while ((i < nx) && (j < my)) {
			int ax = Character.getNumericValue(X.charAt(i));
			int ay = Character.getNumericValue(Y.charAt(j));
			int num = ax + ay + carry;
			int s = num % 10;
			carry = num / 10;
			result.append(s);
			++i;
			++j;
		}
		
		while (i < nx) {
			int ax = Character.getNumericValue(X.charAt(i));
			int num = ax + carry;
			int s = num % 10;
			carry = num / 10;
			result.append(s);
			++i;
		}
		
		while (j < my) {
			int ay = Character.getNumericValue(Y.charAt(j));
			int num = ay + carry;
			int s = num % 10;
			carry = num / 10;
			result.append(s);
			++j;
		}
		if (carry > 0) {
		    result.append(carry);
		}
		//System.out.println("result: " + result.toString());
				
		return result;
	}
}
