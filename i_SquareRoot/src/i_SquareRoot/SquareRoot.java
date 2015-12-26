package i_SquareRoot;

public class SquareRoot {
	
	public static int sqrt(int a) {
		long low = 0;
		long high = a;
		
		while (low <= high) {
			long mid = low + (high - low)/2;
			long result = mid * mid;
			
			if (result == a) {
				return (int)mid;
			} else if (result > a ) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return (int)high;
	}
	
	public static void main(String [] args) {
		int [] A = {3,4,5,6,7,8,9};
		for (int i=0; i<A.length; i++) {
			System.out.println(A[i] + ": " + sqrt(A[i]));
		}
	}

}
