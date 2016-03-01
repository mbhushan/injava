package i_RegexMatchStarQuest;

public class RegexMatch {

	public static void main(String[] args) {
		System.out.println(isMatch("aa","a"));
		System.out.println(isMatch("aa","aa"));
		System.out.println(isMatch("aaa","aa"));
		System.out.println(isMatch("aa","*"));
		System.out.println(isMatch("aa","a*"));
		System.out.println(isMatch("ab","?*"));
		System.out.println(isMatch("aab","c*a*b"));
	}
	
	public static int isMatch(final String s, final String p) {
		if (isRegexMatch(s, p)) {
			return 1;
		}
		return 0;
	}
	
	public static boolean isRegexMatch(final String s, final String p) {
		int i = 0;
		int j = 0;
		int starIndex = -1;
		int iIndex = -1;
	 
		while (i < s.length()) {
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				starIndex = j;		
				iIndex = i;
				j++;
			} else if (starIndex != -1) {
				j = starIndex + 1;
				i = iIndex+1;
				iIndex++;
			} else {
				return false;
			}
		}
	 
		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}
	 
		return j == p.length();
	}
}
