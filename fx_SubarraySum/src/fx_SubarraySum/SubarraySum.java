package fx_SubarraySum;
/*
 Given an array having positive integers, how do I find a continuous subarray which sums to a given number?
 */

public class SubarraySum {

	public static void main(String[] args) {
		SubarraySum SS = new SubarraySum();
		
		int [] A = { 1, 4, 4, 1, 1, 13, 4, 5, 2, 14 };
		int target = 25;
		
		Result R = SS.findSum(A, target);
		System.out.println("start and end indices are: " + R.start + ":" + R.end);
	}
	
	public Result findSum(int [] A, int target) {
		Result result = new Result(-1, -1);
		
		for (int i=0, j=0, sum=0; i<A.length; i++ ) {
			for (; j<A.length && sum < target; j++) {
				sum += A[j];
			}
			if (sum == target) {
				result.start = i;
				result.end = j-1;
				return result;
			}
			if (sum > target) {
				sum -= A[i];
			}
		}
		return result;
	}
}

class Result {
	int start;
	int end;
	
	public Result(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
