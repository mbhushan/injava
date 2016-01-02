package i_SingleNumber;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {

	public static int singleNumber(final List<Integer> a) {
		int n = a.size();
		int num = a.get(0);
		for (int i=1; i<n; i++) {
			num = num ^ a.get(i);
		}
		return num;
	}
	
	public static void main(String [] args) {
		int [] A = {1,2,2,3,1};
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		System.out.println("single number: " + singleNumber(X));
	}
}
