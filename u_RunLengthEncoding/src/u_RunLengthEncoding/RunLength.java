package u_RunLengthEncoding;

import java.util.HashMap;

public class RunLength {

	private static HashMap<Character, Character> cmap = new HashMap<Character, Character>();
	private static HashMap<Character, Character> imap = new HashMap<Character, Character>();
	
	public static void main(String [] args) {
		String st = "WWWBBB111122333345";
		String S = "abcdefghij";
		String I = "0123456789";
		char [] iArr = I.toCharArray();
		char [] chArr = S.toCharArray();
		for (int i=0; i<S.length(); i++) {
			cmap.put(chArr[i], iArr[i]);
			imap.put(iArr[i], chArr[i]);
		}
		System.out.println("orignal string: " + st);
		System.out.println("original string length: " + st.length());
		String encoded = encode(st);
		System.out.println("encode: " + encoded);
		System.out.println("encoded length: " + encoded.length());
		String decoded = decode(encoded);
		System.out.println("decoded: " + decoded);
	} 
	
	public static String decode(String st) {
		StringBuffer sb = new StringBuffer();
		int len = st.length();
				
		for (int i=0; i<len; i++) {
			char ch = st.charAt(i);
			StringBuffer tmp = new StringBuffer();
			while (Character.isDigit(ch) && (i+1 < len)) {
				tmp.append(ch);
				ch = st.charAt(++i);
			}
			if (cmap.containsKey(ch)) {
				ch = cmap.get(ch);
			}
			if (tmp.length() > 0) {
				int num = Integer.parseInt(tmp.toString());
				for (int j=0; j<num; j++) {
					sb.append(ch);
				}
			} else {
				sb.append(ch);
			}
		}
		
		return sb.toString();
	}
	
	public static String encode(String st) {
		int len = st.length();
		StringBuffer sb = new StringBuffer();
		int count = 1;
		
		int i = 0;
		while (i < len) {
			char ch = st.charAt(i);
			while ((i+1 < len) && (st.charAt(i) == st.charAt(i+1))) {
				++count;
				++i;
			} 
			if (imap.containsKey(ch)) {
				ch = imap.get(ch);
			}
			if (count > 1) {
				sb.append(count);
			}
			sb.append(ch);
			count = 1;
			++i;
		}
		return sb.toString();
	}
}
