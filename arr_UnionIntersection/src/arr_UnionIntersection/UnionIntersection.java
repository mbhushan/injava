package arr_UnionIntersection;

import java.util.ArrayList;

/*
Union and Intersection of two sorted arrays - no duplicates.
Given two sorted arrays, find their union and intersection.

For example, if the input arrays are: 
arr1[] = {1, 3, 4, 5, 7}
arr2[] = {2, 3, 5, 6}
Then your program should print Union as {1, 2, 3, 4, 5, 6, 7} and Intersection as {3, 5}. 
*/
public class UnionIntersection {

	public static void main(String[] args) {
		int [] A = {1, 3, 4, 5, 7};
		int [] B = {2, 3, 5, 6};
		UnionIntersection UI = new UnionIntersection();
		ArrayList<Integer> union = UI.union(A, B);
		System.out.println("union of arrays: ");
		for (Integer a: union) {
			System.out.print(a + " ");
		}
		System.out.println();
		
		ArrayList<Integer> interset = UI.intersection(A, B);
		System.out.println("intersection of arrays: ");
		for (Integer a: interset) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
	public ArrayList<Integer> intersection(int [] A, int [] B) {
		int alen = A.length;
		int blen = B.length;
		
		int i = 0;
		int j = 0;
		ArrayList<Integer> intersect = new ArrayList<Integer>();
		while (i < alen && j < blen) {
			if (A[i] < B[j]) {
				++i;
			} else if (A[i] > B[j]) {
				++j;
			} else {
				intersect.add(A[i]);
				++i;
				++j;
			}
		}
		
		return intersect;
	}
	
	public ArrayList<Integer> union(int [] A, int [] B) {
		int alen = A.length;
		int blen = B.length;
		
		ArrayList<Integer> union = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while (i < alen && j < blen) {
			if (A[i] < B[j]) {
				union.add(A[i]);
				++i;
			} else if (A[i] > B[j]) {
				union.add(B[j]);
				++j;
			} else {
				union.add(A[i]);
				++i;
				++j;
			}
		}
		while (i < alen) {
			union.add(A[i]);
			++i;
		}
		while (j < blen) {
			union.add(B[j]);
			++j;
		}
		return union;
				
	}
}
