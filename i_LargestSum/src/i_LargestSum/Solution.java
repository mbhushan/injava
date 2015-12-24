package i_LargestSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static int maxSubArray(final List<Integer> a) {
	   int runningSum = a.get(0);
       int maxSum = a.get(0);
       for(int i=1;i<a.size();i++){
           runningSum = Math.max(runningSum + a.get(i), a.get(i));
           maxSum = Math.max(maxSum, runningSum);
       }
       return maxSum;
	}
	
	public static void main(String [] args) {
		int [] A = {-2,1,-3,4,-1,2,1,-5,4};
		ArrayList<Integer> X = new ArrayList();
		
		for (int index = 0; index < A.length; index++) {
			X.add(A[index]);
		 }
		
		System.out.println("Max Sum: " + maxSubArray(X));
		
	}

}
