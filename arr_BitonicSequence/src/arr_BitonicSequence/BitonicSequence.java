package arr_BitonicSequence;

/*
Maximum Length Bitonic Subarray
Given an array A[0 … n-1] containing n positive integers, a subarray A[i … j] is bitonic 
if there is a k with i <= k <= j such that A[i] <= A[i + 1] ... <= A[k] >= A[k + 1] >= .. A[j – 1] > = A[j]. 
Write a function that takes an array as argument and returns the length of the maximum length bitonic subarray.
Expected time complexity of the solution is O(n)
 */
public class BitonicSequence {

	public static void main(String[] args) {
		BitonicSequence bs = new BitonicSequence();
		int [] A = {12, 4, 78, 90, 45, 23};
		
		System.out.println("max bitonic sequence: "  + bs.maxBitonicSeq(A));
	}
	
	public int maxBitonicSeq(int [] A) {
		if (A == null || A.length < 1) {
			return 0;
		}
		
		int result = 0;
		int [] inc = new int[A.length];
		int [] dec = new int[A.length];
		
		inc[0] = 1;
		for (int i=1; i<A.length; i++) {
			if (A[i] > A[i-1]) {
				inc[i] = inc[i-1] + 1;
			} else {
				inc[i] = 1;
			}
		}
		
		dec[A.length - 1] = 1;
		for (int i=A.length-2; i>=0 ;i--) {
			if (A[i] > A[i+1]) {
				dec[i] = dec[i+1] + 1;
			} else {
				dec[i] = 1;
			}
		}
		
		for (int i=0; i<A.length; i++) {
			int tmp = inc[i] + dec[i] - 1;
			if (tmp > result) {
				result = tmp;
			}
		}
		
		return result;
	}
}
