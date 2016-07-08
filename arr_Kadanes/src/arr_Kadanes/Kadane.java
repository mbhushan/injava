package arr_Kadanes;

public class Kadane {

	public static void main(String[] args) {
		Kadane kad = new Kadane();
		
		int [] A = {-2, -3, 4, -1, -2, 1, 5, -3};
		
		int result = kad.maxContiguousSum(A);
		System.out.println("max contiguous sum: " + result);
		
	}
	
	
	public int maxContiguousSum(int [] A) {
		int maxSoFar = 0;
		int buff = 0;
		int start = 0;
		int end = 0;
		
		for (int i=0; i<A.length; i++) {
			buff += A[i];
			if (buff > maxSoFar) {
					maxSoFar = buff;
					end = i;
			}
			
			if (buff < 0) {
				buff = 0;
				start = i+1;
			}
		}
		
		System.out.println("start index: " + start);
		System.out.println("end index: " + end);
		
		return maxSoFar;
	}
}
