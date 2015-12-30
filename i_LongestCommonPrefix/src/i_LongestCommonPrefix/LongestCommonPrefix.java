package i_LongestCommonPrefix;

import java.util.ArrayList;

public class LongestCommonPrefix {
	
	public static String longestCommonPrefix(ArrayList<String> a) {
		if (null == a) {
			return null;
		}
		int n = a.size();
		if (n == 0) {
			return "";
		}
		
		String prefix = a.get(0);
		for (int i=1; i<n; i++) {
			prefix = getPrefix(prefix, a.get(i));
			if (prefix.isEmpty()) {
				System.out.println("prefix is empty!");
				return prefix;
			} 
		}
		System.out.println("prefix: " + prefix);
		return prefix;
	}
	
	private static String getPrefix(String x, String y) {
		StringBuffer sb = new StringBuffer();
		int i=0;
		int xlen = x.length();
		int ylen = y.length();
		while (i < xlen && i < ylen) {
			if (x.charAt(i) == y.charAt(i)) {
				sb.append(x.charAt(i));
			}
			++i;
		}
		return sb.toString();
	}

	public static void main(String [] args) {
		String [] S = {"abcdefgh",
				  "aefghijk",
				  "abcefgh"};
		ArrayList<String> a = new ArrayList<String>();
		for (int i=0; i<S.length; i++) {
			a.add(S[i]);
		}
		System.out.println("longest prefix: " + longestCommonPrefix(a));
	}
}
