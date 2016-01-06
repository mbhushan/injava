package i_MaxArea;

import java.util.ArrayList;

public class MaxArea {

	public static int maxArea(ArrayList<Integer> a) {
		if (a == null || a.size() < 2) {
			return 0;
		}
	 
		int max = 0;
		int left = 0;
		int right = a.size() - 1;
	 
		while (left < right) {
			max = Math.max(max, (right - left) * Math.min(a.get(left) , a.get(right)));
			if (a.get(left) < a.get(right)) {
				left++;
			} else {
				right--;
			}
		}
	 
		return max;
	}
	
	public static void main(String[] args) {
		int [] A = {1, 5, 4, 3};
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		
		System.out.println("max area: " + maxArea(X));
		
		
	}
}
