package i_CountSay;

public class CountSay {

	public static String countAndSay(int a) {
		
		String st = "1";
		System.out.println(st);
		for (int i=0; i<a; i++) {
			st = nextSeq(st);
			System.out.println(st);
		}
		
		return st;
	}
	
	
	private static String nextSeq(String st) {
		int n = st.length();
		
		char ch = st.charAt(0);
		StringBuffer sb = new StringBuffer();
		int count = 1;
		for (int i=1; i<n; i++) {
			if (st.charAt(i) == ch) {
				++count;
			} else {
				sb.append(count);
				sb.append(ch);
				ch = st.charAt(i);
				count = 1;
			}
		}
		sb.append(count);
		sb.append(ch);
		
		return sb.toString();
	}
	
	public static void main(String [] args) {
		int n = 5;
		countAndSay(n);
	}
}
