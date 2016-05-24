package fx_IslandVectors;

/*
 You a have a vector with the heights of an island (at point 1, point 2 etc) and 
 you want to know how much water would remain on this island (without flowing away).
 */
public class IslandVectors {

	public static void main(String[] args) {
		int [] A = {3, 0, 0, 2, 0, 4};
		
		IslandVectors IV = new IslandVectors();
		System.out.println("total water: " + IV.waterStorage(A));
	}
	
	public int waterStorage(int [] A) {
		if (A == null || A.length <= 1) {
			return -1;
		}
		
		int len = A.length;
		int [] left = new int[len];
		int [] right = new int[len];
		
		left[0] = A[0];
		for (int i=1; i<len; i++) {
			left[i] = Math.max(left[i-1], A[i]);
		}
		
		right[len-1] = A[len-1];
		for (int i=len-2; i>=0 ; i--) {
			right[i] = Math.max(right[i+1], A[i]);
		}
		
		int totalWater = 0;
		for (int i=0; i<len; i++) {
			totalWater += (Math.min(left[i], right[i]) - A[i]);
		}
		
		return totalWater;
	}
}
