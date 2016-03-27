package hash_KDistanceDuplicates;

import java.util.HashSet;

/*
 Check if a given array contains duplicate elements within k distance from each other
Given an unsorted array that may contain duplicates. Also given a number k which is smaller than size of array. Write a function that returns true if array contains duplicates within k distance.

Examples:

Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
Output: false
All duplicates are more than k distance away.

Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
Output: true
1 is repeated at distance 3.

Input: k = 3, arr[] = {1, 2, 3, 4, 5}
Output: false

Input: k = 3, arr[] = {1, 2, 3, 4, 4}
Output: true
 */
public class KDistanceDups {

	public static void main(String[] args) {
		int [][] A = {
				{1, 2, 3, 4, 1, 2, 3, 4},
				{1, 2, 3, 1, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 4}
		};
		int k = 3;
		for (int i=0; i<A.length; i++) {
			System.out.println("Duplicates at " + k + " distance away: " + kDistanceDups(A[i], k));
		}
		
	}
	
	public static boolean kDistanceDups(int [] A, int k) {
		HashSet<Integer> hset = new HashSet<Integer>();
		int len = A.length;
		
		for (int i=0; i<len; i++) {
			if (i >= k) {
				if (hset.contains(A[i])) {
					return true;
				} else {
					hset.remove(A[i-k]);
				}
			} 
			hset.add(A[i]);
		}
		return false;
	}
	
	
}
