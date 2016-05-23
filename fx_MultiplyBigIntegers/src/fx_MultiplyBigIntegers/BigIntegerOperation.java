package fx_MultiplyBigIntegers;
/*
 1. Write code to multiply two large numbers given as strings (without using BigInteger).
 */

public class BigIntegerOperation {

	public static void main(String[] args) {
		BigIntegerOperation BO = new BigIntegerOperation();
		String s1 = "92";
		String s2 = "230";
		System.out.println("sum: " + BO.sumStrings(s1, s2));
		
		s1 = "23";
		s2 = "14";
		System.out.println("multiply: " + BO.multiply(s1, s2));
	}
	
	public String multiply(String s1, String s2) {
		StringBuffer sb = new StringBuffer();
		
		int s1len = s1.length();
		int s2len = s2.length();
		int carry = 0;
		int offset = 0;
		StringBuffer tmp = new StringBuffer();
		for (int i=s2len-1; i>=0; i--) {
			Character c1 = s2.charAt(i);
			int n1 = Character.getNumericValue(c1);
			for (int k=0; k<offset; k++) {
				tmp.append('0');
			}
			for (int j=s1len-1; j>=0; j--) {
				Character c2 = s1.charAt(j);
				int n2 = Character.getNumericValue(c2);
				int prod = (n1*n2);
				int sum = (prod + carry)%10;
				carry = (prod + carry)/10;
				tmp.append(sum);
				
			}
			if (carry > 0) {
				tmp.append(carry);
			}
			String first = sb.toString();
			String second = tmp.reverse().toString();
			//System.out.println("tmp: " + second);
			String result = sumStrings(first, second);
			sb = new StringBuffer(result);
			tmp = new StringBuffer();
			++offset;
		}
		
		
		return sb.toString();
	}
	
	private String sumStrings(String s1, String s2) {
		if (s1 == null && s2 == null) {
			return null;
		}
		if (s1.isEmpty()) {
			return s2;
		}
		if (s2.isEmpty()) {
			return s1;
		}
		StringBuffer sb = new StringBuffer();
		
		int s1Len = s1.length();
		int s2Len = s2.length();
		
		int i = s1Len - 1;
		int j = s2Len - 1;
		int carry = 0;
		int sum = 0;
		while (i >= 0 && j >=0 ) {
			Character c1 = s1.charAt(i);
			Character c2 = s2.charAt(j);
			int n1 = Character.getNumericValue(c1);
			int n2 = Character.getNumericValue(c2);
			sum = (n1 + n2 + carry) % 10;
			carry = (n1 + n2 + carry) / 10;
			sb.append(sum);
			--i;
			--j;
		}
	//	System.out.println("sb sum: " + sb.reverse().toString());
	//	System.out.println("i: " + i + ", j: " + j);
		while (i >= 0) {
			Character c1 = s1.charAt(i);
			int n1 = Character.getNumericValue(c1);
			sum = (n1 + carry) %10;
			carry = (n1 + carry)/10;
			sb.append(sum);
			--i;
		}
		while (j >=0) {
			Character c2 = s2.charAt(j);
			int n2 = Character.getNumericValue(c2);
			sum = (n2 + carry) %10;
			carry = (n2 + carry)/10;
			sb.append(sum);
			--j;
		}
		if (carry > 0) {
			sb.append(carry);
		}
		
		return sb.reverse().toString();
	}
}
