package i_RainWater;

public class RainWater {

	public static void main(String[] args) {
		int [] A = {3, 0, 0, 2, 0, 4};
		
		System.out.println("total water: " + collectWater(A));
	}
	
	public static int collectWater(int [] A) {
	
		int len = A.length;
		int water = 0;
		
		int [] left = new int[len];
		left[0] = A[0];
		for (int i=1; i<len; i++) {
			left[i] = Math.max(A[i], left[i-1]);
		}
		
		int [] right = new int[len];
		right[len-1] = A[len-1];
		for (int i=len-2; i>=0; i--) {
			right[i] = Math.max(A[i], right[i+1]);
		}
		
		for (int i=0; i<len; i++) {
			water += (Math.min(left[i], right[i]) - A[i]);
		}
		
		
		return water;
	}
}
