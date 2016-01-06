package i_MaxOne;

import java.util.ArrayList;

public class MaxOne {
	
	public static ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
		int wL = 0, wR = 0; 
		int nZero = 0;
		int bestWindowWidth = 0;
		int n = a.size();
		int bestWR = 0;
		int bestWL = 0;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		int runningSum = 0;
		int start=0, finish=0;
		int j = 0;
		int maxSum = 0;
		if (b == 0) {
			
			   
			  for (int i=1; i<n; i++) {
			   if (runningSum > 0) {
			    runningSum += a.get(i).intValue();
			   } else {
			    runningSum = a.get(i).intValue();
			    j = i;
			   }
			   if (runningSum > maxSum) {
			    maxSum = runningSum;
			    start = j;
			    finish = i;
			   }
			  }
			  System.out.println("Max Sum: " + maxSum);
			  System.out.println("Indices: i=" + start + ": j=" + finish);
		}

		while(wR < n){	
			//expand to the right, update '0' count:
			if (nZero <= b){
				if ((wR < n) && (a.get(wR).equals(0))) {
					nZero++; 
				}
				++wR;
			} 
			if (nZero > b) { // nZero > b
			//shrink from left, update '0' count:
				if ((wL < n) && (a.get(wL).equals(0))) {
					nZero--;
				}
				++wL;
			}
			
			//update best window:
			if ( ((wR - wL + 1) > bestWindowWidth)){
				bestWindowWidth = (wR - wL + 1);
				System.out.println("max window: " + bestWindowWidth);
				bestWR = wR;
				bestWL = wL;
			}	
		}
		for (int i=bestWL; i<bestWR; i++) {
			ans.add(i);
		}
		
		printList(ans);
		return ans;
	}
	
	private static void printList(ArrayList<Integer> A) {
		int n = A.size();
		for (int i=0; i<n; i++) {
			System.out.print(A.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//int [] A = {1, 1, 0, 1, 1, 0, 0, 1, 1, 1};
		int m = 0;
		int [] A = {0, 1, 1, 1};
		
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		maxone(X, m);
	}


}
