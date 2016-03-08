package i_IsInterleaved;

public class InterleaveStings {
	
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		
		System.out.println("is interleaved: " + isInterleave(s1, s2, s3));
		s3 = "aadbbbaccc";
		System.out.println("is interleaved: " + isInterleave(s1, s2, s3));
	}

	public static int isInterleave(String a, String b, String c) {
		char [] A = a.toCharArray();
		char [] B = b.toCharArray();
		char [] C = c.toCharArray();
		
		if (isInterleavedDP(A, B, C)) {
			return 1;
		}
		return 0;
	}
	
	private static boolean isInterleavedDP(char [] A, char [] B, char [] C)
	{
	    // Find lengths of the two strings
	    int M = A.length, N = B.length;
	 
	    // Let us create a 2D table to store solutions of
	    // subproblems.  C[i][j] will be true if C[0..i+j-1]
	    // is an interleaving of A[0..i-1] and B[0..j-1].
	    boolean [][] IL  = new boolean[M+1][N+1];
	 
	 
	    // C can be an interleaving of A and B only of sum
	    // of lengths of A & B is equal to length of C.
	    if ((M+N) != C.length)
	       return false;
	 
	    // Process all characters of A and B
	    for (int i=0; i<=M; ++i)
	    {
	        for (int j=0; j<=N; ++j)
	        {
	            // two empty strings have an empty string
	            // as interleaving
	            if (i==0 && j==0)
	                IL[i][j] = true;
	 
	            // A is empty
	            else if (i==0 && B[j-1]==C[j-1])
	                IL[i][j] = IL[i][j-1];
	 
	            // B is empty
	            else if (j==0 && A[i-1]==C[i-1])
	                IL[i][j] = IL[i-1][j];
	 
	            // Current character of C matches with current character of A,
	            // but doesn't match with current character of B
	            else if( (i > 0) && A[i-1]==C[i+j-1] && (j > 0) && B[j-1]!=C[i+j-1])
	                IL[i][j] = IL[i-1][j];
	 
	            // Current character of C matches with current character of B,
	            // but doesn't match with current character of A
	            else if ((i > 0) && A[i-1]!=C[i+j-1] && (j > 0) && B[j-1]==C[i+j-1])
	                IL[i][j] = IL[i][j-1];
	 
	            // Current character of C matches with that of both A and B
	            else if ((i > 0) && A[i-1]==C[i+j-1] && (j > 0) && B[j-1]==C[i+j-1])
	                IL[i][j]=(IL[i-1][j] || IL[i][j-1]) ;
	        }
	    }
	 
	    return IL[M][N];
	}
}
