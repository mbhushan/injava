package arr_MinJumpToReachEnd;

import java.util.Arrays;

/*
Minimum number of jumps to reach end
Given an array of integers where each element represents the max number of steps that can be made forward from that element. 
Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.

Example:

Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1-> 3 -> 8 ->9)
First element is 1, so can only go to 3. Second element is 3, so can make at most 3 steps eg to 5 or 8 or 9.
*/

public class MinimumJump {
	
	public static void main(String[] args) {
		MinimumJump  mj = new MinimumJump();
		
		int [] A = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		
		mj.minJump(A);
		
	}
	
	public void minJump(int [] A) {
		if (A == null || A.length < 1) {
			return ;
		}
		
		int [] jumps = new int[A.length];
		int [] path = new int[A.length];
		
		jumps[0] = 0;
		for (int i=1; i<A.length; i++) {
			jumps[i] = Integer.MAX_VALUE -1;
		}
		
		for (int i=1; i<A.length; i++) {
			for (int j=0; j<i; j++) {
				if (A[j] + j >= i) {
					if (jumps[i] > jumps[j] + 1) {
						path[i] = j;
						jumps[i] = jumps[j] + 1;
					}
				}
			}
		}
		
		System.out.println("min jumps: " + jumps[A.length-1]);
		System.out.println("actual jumps: ");
		System.out.println(Arrays.toString(path));
		printPath(path, A);
	}
	
	public void printPath(int [] path, int [] A) {
		int len = path.length;
		
		int x = path[len-1];
		System.out.print(A[len-1] + " <- ");
		while (x != 0) {
			System.out.print(A[x] + " <- ");
			x = path[x];
		}
		System.out.print(A[x]);
	}
}
