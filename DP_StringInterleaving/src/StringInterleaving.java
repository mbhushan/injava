
public class StringInterleaving {
	
	

	public static void main(String[] args) {
		StringInterleaving SI = new StringInterleaving();
		String S1 = "aab";
		String S2 = "axy";
		String S3 = "aaxaby";
		boolean ans = SI.isInterleaved(S1.toCharArray(), S2.toCharArray(), S3.toCharArray(), 0, 0, 0);
		System.out.println("is interleaved: " + ans);
		S3 = "abaaxy";
		ans = SI.isInterleaved(S1.toCharArray(), S2.toCharArray(), S3.toCharArray(), 0, 0, 0);
		System.out.println("is interleaved: " + ans);
	}
	
	public boolean isInterleaved(char [] S1, char [] S2, char [] S3, int p1, int p2, int p3) {
		if (p1 == S1.length && p2 == S2.length && p3 == S3.length) {
			return true;
		}
		if (p3 == S3.length) {
			return false;
		}
		
		return (p1 < S1.length && S1[p1] == S3[p3] && isInterleaved(S1, S2, S3, p1+1, p2, p3+1)) 
				|| (p2 < S2.length && S2[p2] == S3[p3] && isInterleaved(S1, S2, S3, p1, p2+1, p3+1));
	}
}
