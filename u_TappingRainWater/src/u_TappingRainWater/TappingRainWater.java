package u_TappingRainWater;

public class TappingRainWater {

	public static void main(String [] args) {
		int [][] A = {
				 {2, 0, 2},
				 {3, 0, 0, 2, 0, 4},
				 {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
		};
		
		for (int i=0; i<A.length; i++) {
			System.out.println("getting tapped water: " + getTappedWater(A[i]));
		}
	}
	
	public static int getTappedWater(int [] A) {
		int len = A.length;
		
		int [] left = new int[len];
		int [] right = new int[len];
		
		left[0] = A[0];
		for (int i=1; i<len; i++) {
			left[i] = Math.max(left[i-1], A[i]);
		}
		
		//lets fill the right array now.
		right[len-1] = A[len-1];
		for (int i=len-2; i>=0; i--) {
			right[i] = Math.max(right[i+1], A[i]);
		}
		
		int totalWater = 0;
		for (int i=0; i<len; i++) {
			totalWater += (Math.min(left[i], right[i]) - A[i]);
		}
		return totalWater;
	}
}
