package arr_PeakElement;

public class PeakElement {

	public int findPeakElement(int [] A) {
		if (A == null || A.length <= 1) {
			return 0;
		}
		if (A[0] > A[1]) {
			return 0;
		}
		if (A[A.length-1] > A[A.length-2]) {
			return A.length-1;
		}
		for (int i=1; i<A.length-1; i++) {
			if (A[i] > A[i-1] && A[i] > A[i+1]) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		PeakElement PE = new PeakElement();
		
		int [] A = {1, 2, 3, 1};
		System.out.println("peak element: " + PE.findPeakElement(A));

	}
}
