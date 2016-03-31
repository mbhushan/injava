package u_InversionCount;

public class InversionCount {

	public static void main(String[] args) {
		int [] A = {1, 20, 6, 4, 5};
		
		System.out.println("inversion count: " + inversionCountNaive(A));
	}
	
	//naive method - O(n^2) complexity
	public static int inversionCountNaive(int [] A) {
		if (null == A) {
			return 0;
		}
		int len = A.length;
		int invCount = 0;
		for (int i=0; i<len-1; i++) {
			for (int j=i+1; j<len; j++) {
				if (A[i] > A[j]) {
					++invCount;
				}
			}
		}
		return invCount;
	}
}
