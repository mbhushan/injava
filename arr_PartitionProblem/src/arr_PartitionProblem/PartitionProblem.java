package arr_PartitionProblem;

public class PartitionProblem {

	public static void main(String[] args) {
		PartitionProblem pp = new PartitionProblem();
		
		int [] A = {3, 1, 5, 9, 12};
		System.out.println("equal partition possible: " + pp.partition(A));
		
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
