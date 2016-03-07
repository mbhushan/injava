package i_EditDistance;

public class EditDistance {

	public static void main(String[] args) {
		String str1 = "Anshuman";
		String str2 = "Antihuman";
		System.out.println("min edit distance: " + minDistance(str1, str2));
	}
	
	public static int minDistance(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		int m = str1.length();
		int n = str2.length();
		
		int [][]dp = new int[m+1][n+1];
		 
	    // Fill d[][] in bottom up manner
	    for (int i=0; i<=m; i++)
	    {
	        for (int j=0; j<=n; j++)
	        {
	            // If first string is empty, only option is to
	            // isnert all characters of second string
	            if (i==0)
	                dp[i][j] = j;  // Min. operations = j
	 
	            // If second string is empty, only option is to
	            // remove all characters of second string
	            else if (j==0)
	                dp[i][j] = i; // Min. operations = i
	 
	            // If last characters are same, ignore last char
	            // and recur for remaining string
	            else if (str1.charAt(i-1) == str2.charAt(j-1))
	                dp[i][j] = dp[i-1][j-1];
	 
	            // If last character are different, consider all
	            // possibilities and find minimum
	            else
	                dp[i][j] = 1 + Math.min(dp[i][j-1],  // Insert
	                                  Math.min(dp[i-1][j],  // Remove
	                                   dp[i-1][j-1])); // Replace
	        }
	    }
	 
	    return dp[m][n];
	}
}
