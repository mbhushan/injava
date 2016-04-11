
public class LongestCommonSubsequence {

	
	public static void main(String [] args) {
		String A = "computerscience";
		String B = "programmingandcoding";
		
		LongestCommonSubsequence LCS = new LongestCommonSubsequence();
		System.out.println("A: " + A );
		System.out.println("B: " + B );
		System.out.println("lcs: " + LCS.lcs(A, B));
	}
	
	public int lcs(String A, String B) {
		if (A == null || B == null) {
			return 0;
		}
		return lcsUtil(A.toCharArray(), B.toCharArray(), 0, 0);
	}
	
	private int lcsUtil(char [] A, char [] B, int lenA, int lenB) {
		if (lenA == A.length || lenB == B.length) {
			return 0;
		}
		
		if (A[lenA] == B[lenB]) {
			return 1 + lcsUtil(A, B, lenA+1, lenB+1);
		} else {
			return Math.max(lcsUtil(A, B, lenA+1, lenB), lcsUtil(A, B, lenA, lenB+1));
		}
	}
	
}
