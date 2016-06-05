package arr_KWindowMax;

import java.util.Deque;
import java.util.LinkedList;

/*
Maximum of all subarrays of size k (Added a O(n) method)
Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.

Examples:
Input :
arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}
k = 3
Output :
3 3 4 5 5 5 6

Input :
arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
k = 4
Output :
10 10 10 15 15 90 90
*/
public class WindowMaximum {

	public static void main(String[] args) {
		WindowMaximum WM = new WindowMaximum();
		
		int [][] A = {
				{1, 2, 3, 1, 4, 5, 2, 3, 6},
				{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}
		};
		
		int [] K = {3,4};
		
		for (int i=0; i<A.length; i++) {
			WM.windowMax(A[i], K[i]);
		}
	}
	
	private void windowMax(int [] A, int k) {
		if (A == null || A.length < k) {
			return;
		}
		
		Deque<Integer> dq = new LinkedList<Integer>();
		int i = 0;
		for (i=0; i<k; i++) {
			while (!dq.isEmpty() && A[i] > A[dq.peekLast()]) {
				dq.removeLast();
			}
			dq.addLast(i);
		}
		
		for (; i<A.length; i++) {
			//key at the front is the largest of the previous window.
			System.out.print(A[dq.getFirst()] + " ");
			
			//remove the keys that are out of this window.
			while (!dq.isEmpty() && dq.getFirst() <= (i-k)) {
				dq.removeFirst();
			}
			
			while (!dq.isEmpty() && A[i] > A[dq.peekLast()]) {
				dq.removeLast();
			}
			
			dq.addLast(i);
		}
		System.out.print(A[dq.getFirst()]);
		System.out.println();
	}
	
	
}
