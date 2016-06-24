package fx_SubarrayTarget;

public class SubarraySum {

	public static void main(String[] args) {
		SubarraySum ss = new SubarraySum();

		int [] A = {15, 2, 4, 8, 9, 5, 10, 23};
		int target = 23;
		
		ss.findSum(A, target);
	}
	
	public void findSum(int [] A, int target) {
		
		for (int i=0, j=0, sum=0; i < A.length; i++) {
			for (; j<A.length && sum < target; j++) {
				sum += A[j];
			}
			if (sum == target) {
				System.out.println(i + " to " + (j-1));
				for (int x=i; x<j; x++) {
					System.out.print(A[x] + " ");
				}
				System.out.println();
			}
			sum -= A[i];
		}
	}
}
