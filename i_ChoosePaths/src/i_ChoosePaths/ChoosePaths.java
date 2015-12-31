package i_ChoosePaths;

public class ChoosePaths {
	
	public static int uniquePaths(int a, int b) {
		
		int ans = backtrack(1, 1, a, b);
		return ans;
	}
	
	private static int backtrack(int r, int c, int m, int n) {
		  if (r == m && c == n)
		    return 1;
		  if (r > m || c > n)
		    return 0;
		 
		  return backtrack(r+1, c, m, n) + backtrack(r, c+1, m, n);
	}
	
	public static void main(String [] args) {
		int r = 2;
		int c = 2;
		
		System.out.println("unique paths: " + uniquePaths(r, c));
	}

}
