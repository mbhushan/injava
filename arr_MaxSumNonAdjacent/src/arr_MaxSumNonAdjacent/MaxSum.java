package arr_MaxSumNonAdjacent;

public class MaxSum {

	public static void main(String[] args) {
		int [] A = {5,  5, 10, 40, 50, 35};
		
		MaxSum ms = new MaxSum();
		System.out.println("max sum of non adjacent keys: " + ms.maxSum(A));
		
	}
	
	public int maxSum(int [] A) {
		int len = A.length;
		
		int incl = A[0];
		int excl = 0;
		for (int i=1; i<len; i++) {
			int old_incl = incl;
			incl = excl + A[i];
			excl = Math.max(excl, old_incl); 
		}
		
		return Math.max(incl, excl);
	}
}
