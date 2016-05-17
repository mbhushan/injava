package ss_MinLenUnsortedSubarray;

public class MinLenUnsortedSubarray {

	public int [] unsortedSubarray(int [] A) {
		int [] result = new int[2];
		
		int start = -1;
		int end = -1;
		result[0] = start;
		result[1] = end;
		
		for (int i=0; i<A.length-1; i++) {
			if (A[i] > A[i+1]) {
				start = i;
				break;
			}
		}
		
		for (int i=A.length-1; i>0 ;i--) {
			if (A[i] < A[i-1]) {
				end = i;
				break;
			}
		}
		//input is sorted.
		if (start == -1 || end == -1) {
			return result;
		}
		
		int min = A[start];
		int max = A[start];
		for (int i=start; i<=end; i++) {
			if (A[i] < min) {
				min = A[i];
			}
			if (A[i] > max) {
				max = A[i];
			}
		}
		//System.out.println("start: " + start + ", end: " + end);
		for (int i=0; i<start; i++) {
			if (A[i] > min) {
				start = i;
				break;
			}
		}
		for (int i=A.length-1; i>end; i--) {
			if (A[i] < max) {
				end = i;
				break;
			}
		}
		result[0] = start;
		result[1] = end;
		
		return result;
	}
	
	public static void main(String[] args) {
		MinLenUnsortedSubarray ML  = new MinLenUnsortedSubarray();
		int [][] A = {
				{10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60},
				{0,1,15,25,6,7,30,40,50},
				};
		
		for (int i=0; i<A.length; i++) {
			int [] result = ML.unsortedSubarray(A[i]);
			System.out.println("start: " + result[0] + ", end: " + result[1]);
		}
	}
}
