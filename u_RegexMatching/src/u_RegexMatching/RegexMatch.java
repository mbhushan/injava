package u_RegexMatching;

/*
 '?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 */
public class RegexMatch {

	public static void main(String [] args) {
		
		RegexMatch RM = new RegexMatch();
		
		String [] S = {"xbylmz", "aa", "aa", "aaa", "aa", "aa", "ab", "aab"};
		String [] P = {"x?y*z", "a", "aa", "aa", "*", "a*", "?*", "c*a*b"};
		
		for (int i=0; i<S.length; i++) {
			System.out.println("String: " + S[i]);
			System.out.println("Pattern: " + P[i]);
			System.out.println("is Match: " + RM.isRegexMatchRecursive(S[i], P[i]));
			System.out.println();
		}
	}
	
	/**
	 * recursive version of regex match
	 */
	public boolean isRegexMatchRecursive(String S, String P) {
		return isRegexMatchRecUtil(S.toCharArray(), P.toCharArray(), 0, 0);
	}
	
	private boolean isRegexMatchRecUtil(char [] S, char [] P, int sindex, int pindex) {
		if (pindex == P.length) {
			return sindex == S.length;
		}
		
		if (P[pindex] != '*') {
			if ((sindex < S.length) && (S[sindex] == P[pindex] || P[pindex] == '?')) {
				return isRegexMatchRecUtil(S, P, sindex+1, pindex+1);
			} else {
				return false;
			}
		} else {
			//if we have a***b then skip to the last *
			while ((pindex < P.length-1) && P[pindex+1] == '*') {
				++pindex;
			}
			--sindex;
			while (sindex < S.length) {
				if (isRegexMatchRecUtil(S, P, sindex+1, pindex+1)) {
					return true;
				}
				++sindex;
			}
			return false;
		}
	}
	
}
