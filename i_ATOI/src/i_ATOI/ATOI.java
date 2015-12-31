package i_ATOI;

public class ATOI {
	
	public static int atoi(final String a) {
		if (null == a || a.length() < 1) {
			return 0;
		}
		String st = a.trim();
		int n = st.length();
		
		//StringBuffer sb = new StringBuffer();
		int i = 0;
		if ((i < n) && (st.charAt(i) < '0' || st.charAt(i) > '9')){
			if (st.charAt(i) != '-' && st.charAt(i) != '+' ) {
				return 0;
			} 
		}
		st = st.substring(i);
		System.out.println("st: " + st);
		int ans = toInteger(st);
		System.out.println("ans: " + ans);
		return ans;
	}

	
	private static int toInteger(String str) {
		char flag = '+';
	 
		// check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		// use double to store result
		double result = 0;
	 
		// calculate value
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
	 
		if (flag == '-')
			result = -result;
	 
		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
	 
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
	 
		return (int) result;
	}
	
	public static void main(String [] args) {
		String st = "9 2704";
		st = " -88297 248252140B12 37239U4622733246I218 123 ";
		st = " V515V 5793K 627";
		st = " +7";
		System.out.println("atoi: " + atoi(st));
	}
}
