package arr_MedianSortedArray;

import java.util.Arrays;

public class MedianArrays {

	public static void main(String[] args) {
		int [] A = {1, 2, 3, 6};
	    int [] B = {4, 6, 8, 10};
	    
	    System.out.println("combined median: " + new MedianArrays().combinedMedian(A, B, A.length));
	}
	
	//assuming arrays are of equal size ie n
	public int combinedMedian(int [] A, int [] B, int n ) {
		if (n <= 0) {
			return -1;
		}
		if (n == 1) {
			return (A[0] + B[0])/2;
		}
		if (n == 2) {
			return (Math.max(A[0], B[0]) + Math.min(A[1], B[1]))/2;
		}
		
		int m1 = getMedian(A);
		int m2 = getMedian(B);
		
		if (m1 == m2) {
			return m1;
		}
		
		if (m1 < m2) {
			if (n%2 == 0) {
				return combinedMedian(Arrays.copyOfRange(A, n/2 -1, n), B, n - n/2 + 1);
			}
			return combinedMedian(Arrays.copyOfRange(A, n/2, n), B, n - n/2);
		}
		if (n%2 == 0) {
				return combinedMedian(Arrays.copyOfRange(B, n/2 -1, n), A, n - n/2 + 1);
		}
		return combinedMedian(Arrays.copyOfRange(B, n/2, n), B, n - n/2);
	}
	private int getMedian(int [] A) {
		int len = A.length;
		
		if (len%2 == 0) {
			return (A[len/2] + A[len/2 - 1])/2;
		} else {
			return A[len/2];
		}
	}
}
