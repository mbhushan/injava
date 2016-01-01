package i_BinarySum;

public class BinarySum {
	
	public static String addBinary(String a, String b) {
		if (null == a || b == null) {
			return null;
		}
		int alen = a.length();
		int blen = b.length();
		StringBuffer sb = new StringBuffer();
		
		int carry = 0;
		int sum = 0;
		int diff = Math.abs(alen - blen);
		for (int i=0; i<diff; i++) {
			sb.append(0);
		}
		if (alen <= blen) {
			sb.append(a);
			a = sb.toString();
		} else {
			sb.append(b);
			b = sb.toString();
		}
		alen = a.length();
		blen = b.length();
		sb = new StringBuffer();
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		int index = alen - 1;
		while (index >= 0) {
			int x = Character.getNumericValue(a.charAt(index));
			int y = Character.getNumericValue(b.charAt(index));
			System.out.println("x: " + x + ", y:" + y);
			if ((x + y + carry) == 3) {
				sum = 1;
				carry = 1;
			} else if ((x + y + carry) == 2) {
				sum = 0;
				carry = 1;
			} else if ((x + y + carry) == 1) {
				sum = 1;
				carry = 0;
			} else {
				sum = 0;
				carry = 0;
			}
			System.out.println("sum : " + sum);
			sb.append(sum);
			--index;
		}
		if (carry == 1) {
			sb.append(carry);
		}
		//System.out.println("result: " + sb.toString());
		
		return sb.reverse().toString();
	}
			
	public static void main(String [] args) {
		String a = "1010110111001101101000";
		String b = "1000011011000000111100110";
		String c = addBinary(a, b);
		System.out.println("result: " + c);
	}

}
