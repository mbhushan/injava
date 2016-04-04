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
			System.out.println("is Match: " + RM.isMatchDP(S[i].toCharArray(), P[i].toCharArray()));
			System.out.println();
		}
	}
	
	/*
	 * Dynamic Programming Solution
	 */
	
	public boolean isMatchDP(char [] S, char [] P) {
		//replace multiple * with one *
        //e.g a**b***c --> a*b*c
		int writeIndex = 0;
		boolean isFirst = true;
		
		for (int i=0; i<P.length; i++) {
			if (P[i] == '*') {
				if (isFirst) {
					P[writeIndex++] = P[i];
					isFirst = false;
				}
			} else {
				P[writeIndex++] = P[i];
				isFirst = true;
			}
		}
		
		boolean [][] T = new boolean[S.length+1][writeIndex+1];
		if (writeIndex > 0 && P[0] == '*') {
			T[0][1] = true;
		}
		T[0][0] = true;
		for (int i=1; i<T.length; i++) {
			for (int j=1; j<T[0].length; j++) {
				if (P[j-1] == '?' || S[i-1] == P[j-1]) {
					T[i][j] = T[i-1][j-1];
				} else if (P[j-1] == '*') {
					T[i][j] = T[i-1][j] || T[i][j-1];
				}
			}
		}
		return T[S.length][writeIndex];
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
