package i_NextPerm;

import java.util.ArrayList;
import java.util.Collections;

public class NextPerm {
	public static void nextPermutation(ArrayList<Integer> a) {
	
		//1. Find the highest index i such that a[i] < a[i+1]. If no such index exists, the permutation is the last permutation.
		int n = a.size();
		int i = -1;
		for (i=n-1; i>0; i--) {
			if (a.get(i) > a.get(i-1)) {
				System.out.println("breaking at i: " + i);
				break;
			}
		}
		--i;
		if (i < 0) {
			System.out.println("inside -1");
			Collections.reverse(a);
		} else {
			//Find the highest index j > i such that a[j] > a[i]. Such a j must exist, since i+1 is such an index.
			int j = 0;
			for (j=n-1; j>i; j--) {
				if (a.get(j) > a.get(i)) {
					//Swap s[i] with s[j].
					System.out.println("swapping: " + a.get(i) + ":" + a.get(j));
					int temp = a.get(i);
					a.set(i, a.get(j));
					a.set(j, temp);
					System.out.println("after swap");
					printList(a);
					break;
				}
			}
			
			//Reverse all the order of all of the elements after index i
			System.out.println("i is at: " + i);
			j = n-1;
			++i;
			while (i <= j)
		    {
		        int temp = a.get(i);   
		        a.set(i, a.get(j));
		        a.set(j, temp);
		        i++;
		        j--;
		    }   
		}
		
		printList(a);
	}
	
	private static void printList(ArrayList<Integer> A) {
		for (Integer a: A) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
	public static void main(String [] args) {
		//Integer	 [] A = {2,1,3};
		Integer [] A = {626, 436, 819, 100, 382, 173, 817, 581, 220, 95, 814, 660, 397, 852, 15, 532, 564, 715, 179, 872, 236, 790, 223, 379, 83, 924, 454, 846, 742, 730, 689, 112, 110, 516, 85, 149, 228, 202, 988, 212, 69, 602, 887, 445, 327, 527, 347, 906, 54, 460, 517, 376, 395, 494, 827, 448, 919, 799, 133, 879, 709, 184, 812, 514, 976, 700, 156, 568, 453, 267, 547, 8, 951, 326, 652, 772, 213, 714, 706, 972, 318, 768, 506, 59, 854, 422};
	    
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int index = 0; index < A.length; index++) {
			X.add(A[index]);
		 }
		nextPermutation(X);
	}

}
