package regex_WildcardStarDot;


public class Wildcard {

	public static void main(String [] args) {
		String S = "abcdefx";
		String P = "a.c*xy";
		Wildcard wc = new Wildcard();
		
		System.out.println("is match: " + wc.isMatch(S, P));
		System.out.println("is match: " + wc.isMatch("caab", "c*a*b") );
		System.out.println("is match: " + wc.isMatch("caab", ".*") );
	}

	
	public boolean isMatch(String S, String P) {
		int iStr = 0;
		int jPat = 0;
		int startIndex = -1;
		int iIndex = -1;
		int slen = S.length();
		int plen = P.length();
		
		while (iStr < slen) {
			if ((jPat < plen) && (P.charAt(jPat) == S.charAt(iStr) || P.charAt(jPat) == '.')) {
				++iStr;
				++jPat;
			} else if ((jPat < plen) && (P.charAt(jPat) == '*')) {
				startIndex = jPat;
				iIndex = iStr;
				++jPat;
			} else if ((jPat < plen) && (startIndex != -1)) {
				jPat = startIndex + 1;
				iStr = iIndex + 1;
				++iIndex;
			} else {
				break;
				//return false;
			}
		}
		while (jPat < P.length() && P.charAt(jPat) == '*') {
			++jPat;
		}
		
		return jPat == plen;
		
	}
}
