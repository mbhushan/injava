package u_LargestSumContiguousArray;

public class LargestContiguousSum {

	public static void main(String [] args) {
		int [][] A = {
				{-2, -3, 4, -1, -2, 1, 5, -3},
				{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
		};
		
		int len = A.length;
		for (int i=0; i<len; i++) {
			System.out.println("max subarray sum contiguous: " + maxSubarraySumContig(A[i]));
		}
	}
	
	public static int maxSubarraySumContig(int [] A) {
		if (null == A) {
			return 0;
		}
		int maxSoFar = 0;
		int maxEndingHere = 0;
		int startIndex = 0;
		int endIndex = 0;
		int start = 0;
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			maxEndingHere +=  A[i];
			if (maxEndingHere <= 0) {
				maxEndingHere = 0;
				start = i+1;
			}
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
				startIndex = start;
				endIndex = i;
			}
		}
		System.out.println("start index: " + startIndex);
		System.out.println("end index: " + endIndex);
		return maxSoFar;
	}
}
