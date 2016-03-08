package i_DistinctSubsequence;

public class DistinctSubsequence {

	public static void main(String[] args) {
		String S = "rabbbit", T = "rabbit" ;
		
		System.out.println("number of distinct subsequence: " + numDistinct(S, T));
	}
	
	public static int numDistinct(String S, String T) {
		 int m = S.length(), n = T.length();
	        int[] C = new int[n+1];
	        C[0] = 1;
	        for(int i=1;i<=m;i++) {
	            int lastval=C[0];
	            for(int j=1;j<=n;j++) {
	                int thisval = C[j];
	                if(S.charAt(i-1)==T.charAt(j-1)) C[j]+=lastval;
	                lastval = thisval;
	            }
	        }
	        return C[n];
	}
}
