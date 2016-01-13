package i_Power;

public class Power {

	public static int power1(String a) {
		if (null == a) {
			return 0;
		}
		
		int n = a.length();
		boolean onefound = false;
		for (int i=n-1; i>=0; i--) {
			char ch = a.charAt(i);
			if (onefound && (ch == '1')) {
				return 0;
			}
			if (ch == '1') {
				onefound = true;
			}
		}
		return 1;
	}
	
	public static int power(String a) {
		if (null == a) {
			return 0;
		}
		if (a.length() == 1 && a.charAt(0) == '1') {
			return 0;
		}
		int result = 1;
		while (true) {
			a = divideByTwo(a);
			if (a.length() == 1 && a.charAt(0) == '1') {
				break;
			}
			char ch = a.charAt(a.length()-1);
			int val = Character.getNumericValue(ch);
			if (val % 2 != 0) {
				result = 0;
				break;
			}
		}
		return result;
	}
	
	public static String divideByTwo(String a) {
		if (a == null) {
			return a;
		}
		int n = a.length();
		StringBuffer sb = new StringBuffer();
		int y = 0;
		for (int i=0; i<n; i++) {
			char ch = a.charAt(i);
			int x = Character.getNumericValue(ch);
			if (x > 1 || y > 0) {
				x = y*10 + x;
				int val = x / 2;
				y = x % 2;
				sb.append(val);
			} else {
				y = x;
				if (i == n-1) {
					sb.append(y);
				}
			}
		}
		System.out.println("sb: " + sb.toString());
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String a = "147573952589676412928";
		
		System.out.println("ans: " + power(a));
	}
}
