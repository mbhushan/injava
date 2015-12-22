package i_PlusOne;

import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		int n = a.size();
		long number = 0;
		int carry = 1;
		int len = 0;
		for (int i=n-1; i>=0; i--) {
			int s = a.get(i);
			s = s + carry;
			if (s > 9) {
				s = 0;
				carry = 1;
			} else {
				carry = 0;
			}
			a.set(i, s);
            ++len;
		}
		ArrayList<Integer> result = new ArrayList();
		int index = 0;
		if (carry == 1) {
			result.add(carry);
		} else {
			while (a.get(index) == 0) {
				++index;
			}
		}
		
		System.out.println("index: " + index);
		System.out.println("n: " + n);
		for (int i=index; i<n; i++) {
			// System.out.println("len: " + len);
			result.add(a.get(i));
			
		}
		
		return result;
	}
	
	public static void main(String [] args) {
		 // int [] A = {0,0,1,2,3};
		 // int [] A = { 3, 0, 6, 4, 0 };
		// int [] A = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
		// int [] A = {0, 0, 9, 9, 9};
		 int [] A = { 9, 9, 9, 9, 9 };
				
		ArrayList<Integer> X = new ArrayList();
		
		for (int index = 0; index < A.length; index++) {
			X.add(A[index]);
		 }
		
		X = plusOne(X);
		
		for (int i=0; i<X.size(); i++) {
			System.out.print(X.get(i) + " ");
		}
		System.out.println();
	}
}
