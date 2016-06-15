package arr_PartitionProblem;

public class PartitionProblem {

	public static void main(String[] args) {
		PartitionProblem pp = new PartitionProblem();
		
		int [] A = {3, 1, 5, 9, 12};
		System.out.println("equal partition possible: " + pp.partition(A));
		System.out.println("equal partition possible fast: " + pp.partitionDP(A));
		
	}
	
	public boolean partitionDP(int [] A) {
		if (A == null || A.length <= 1) {
			return false;
		}
		int sum = 0;
		for (int i=0; i<A.length; i++) {
			sum += A[i];
		}
		if (sum%2 == 1) {
			return false;
		}
		sum = sum/2;
		boolean [][] dp = new boolean[sum+1][A.length+1];
		
		for (int i=0; i<=A.length; i++) {
			dp[0][i] = true;
		}
		
		for (int i=1; i<=sum; i++) {
			dp[i][0] = false; 
		}
		
		for (int i=1; i<=sum; i++) {
			for (int j=1; j<=A.length; j++) {
				dp[i][j] = dp[i][j-1];
				if (i >= A[j-1]) {
					dp[i][j] = dp[i][j] || dp[i - A[j-1]][j-1];
				}
			}
		}
		
		return dp[sum][A.length];
	}
	
	public boolean partition(int [] A) {
		if (A == null || A.length <= 1) {
			return false;
		}
		
		int sum = 0;
		for (int i=0; i<A.length; i++) {
			sum += A[i];
		}
		
		if (sum%2 == 1){
			return false;
		}
		sum = sum/2;
		return partition(A, A.length-1, sum);
	}
	
	private boolean partition(int [] A, int index, int sum) {
		//base cases
		if (sum == 0) {
			return true;
		} 
		if (index == -1 && sum != 0) {
			return false;
		}
		if (A[index] > sum) {
			return partition(A, index-1, sum);
		}
		
		return ( partition(A, index-1, sum) || 
				partition(A, index-1, sum - A[index]));
	}
	
	
}
