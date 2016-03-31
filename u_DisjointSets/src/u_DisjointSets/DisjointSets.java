package u_DisjointSets;

import java.util.Arrays;

/*
 How to check if two given sets are disjoint?
Given two sets represented by two arrays, how to check if the given two sets are disjoint or not? 
It may be assumed that the given arrays have no duplicates.
 */

public class DisjointSets {
	
	public static void main(String [] args) {
		int [][] set1 = {
				{12, 34, 11, 9, 3},
				{12, 34, 11, 9, 3}
		};
		int [][] set2 = {
				{2, 1, 3, 5},
				{7, 2, 1, 5}
		};
		
		for (int i=0; i<set1.length; i++) {
			System.out.println("is disjoint: " + isDisjoint(set1[i], set2[i]));
		}
	}
	
	public static boolean isDisjoint(int [] A, int [] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		
		int alen = A.length;
		int blen = B.length;
		
		int i=0;
		int j=0;
		while (i < alen && j < blen) {
			if (A[i] < B[j]) {
				++i;
			} else if (A[i] > B[j]) {
				++j;
			} else { // A[i] == B[j]
				return false;
			}
		}
		return true;
	}

}
