package arr_LargestSubarrayWithEqual01;

import java.util.HashMap;

/*
Largest subarray with equal number of 0s and 1s
Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s. Expected time complexity is O(n).

Examples:

Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
Output: 1 to 6 (Starting and Ending indexes of output subarray)

Input: arr[] = {1, 1, 1, 1}
Output: No such subarray

Input: arr[] = {0, 0, 1, 1, 0}
Output: 0 to 3 Or 1 to 4
*/
public class LargestSubarray01 {
	public static void main(String[] args) {
		LargestSubarray01 ls = new LargestSubarray01();
		
		int [][] A = {
				{1, 0, 1, 1, 1, 0, 0},
				{1, 1, 1, 1},
				{0, 0, 1, 1, 0}
		};
		for (int i=0; i<A.length; i++) {
			System.out.println("max subarray: " + ls.largestSubarray(A[i]));
		}
		
	}
	
	public int largestSubarray(int [] A) {
		if (A == null || A.length <= 1) {
			return 0;
		}
		
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		int [] tmp = new int[A.length];
		int max = 0;
		
		int runningSum = 0;
		for (int i=0; i<A.length; i++) {
			if (A[i] == 1) {
				runningSum += A[i];
			} else {
				runningSum += -1;
			}
			tmp[i] = runningSum;
			if (tmp[i] == 0 && ((i+1) > max)) {
				max = i+1;
			}
			if (!hmap.containsKey(runningSum)) {
				hmap.put(runningSum, i);
			} else {
				int prev = hmap.get(runningSum);
				int diff = i - prev;
				if (diff > max) {
					max = diff;
				}
			}
		}
		
		return max;
	}
}
