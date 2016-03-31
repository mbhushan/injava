package u_longest_continuous_sequence;

public class LongestContSequenceOnes {

	public static void main(String [] args) {
		int [][] A = {
				{1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1},
				{1, 1, 1, 1, 0}
		};
		
		for (int i=0; i<A.length; i++) {
			System.out.println("max continuous ones index for zero: " + maxContOnesIndex(A[i]));
		}
		
	}
	
	public static int maxContOnesIndex(int [] A) {
		if (A == null) {
			return -1;
		}
		int n = A.length;
		int max_count = 0;  // for maximum number of 1 around a zero
        int max_index=0;  // for storing result
        int prev_zero = -1;  // index of previous zero
        int prev_prev_zero = -1; // index of previous to previous zero
        
        for (int i=0; i<n; i++) {
        	if (A[i] == 0) {
        		if (i - prev_prev_zero > max_count) {
        			max_count = i - prev_prev_zero;
        			max_index = prev_zero;
        		}
        		//update for next iteration
        		prev_prev_zero = prev_zero;
        		prev_zero = i;
        	}
        }
        if (n - prev_prev_zero > max_count) {
        	max_index = prev_zero;
        }
        return max_index;
	}
}
