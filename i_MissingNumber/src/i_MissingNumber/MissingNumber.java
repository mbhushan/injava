package i_MissingNumber;

import java.util.ArrayList;
import java.util.BitSet;

public class MissingNumber {
	public static int firstMissingPositive(ArrayList<Integer> a) {
		int ans = -1;
		int n = a.size();
		
		BitSet bits = new BitSet(n+1);
		
		for (int i=0; i<n; i++) {
			int num = a.get(i);
			if ((num >= 0) && (num <= n)) {
				bits.set(num);
			}
		}
		
		for (int i=1; i<=n; i++) {
			if (!bits.get(i)) {
				ans = i;
				break;
			}
		}
		if (ans == -1) {
			ans = n+1;
		}
		return ans;
	}
	
	public static void main(String [] args) {
		//Integer [] A = {1,2,0} ;
		//Integer [] A = {3,4,-1,1};
		//Integer [] A = {-8, -7, -6};
		Integer [] A = {1};
		
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int index = 0; index < A.length; index++) {
			X.add(A[index]);
		 }
		
		System.out.println("first missing: " + firstMissingPositive(X));
	}

}
