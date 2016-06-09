package arr_SubArraySum;

import java.util.ArrayList;
import java.util.Arrays;

/*
Find subarray with given sum
Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Ouptut: Sum found between indexes 1 and 4

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found
There may be more than one subarrays with sum as the given sum. The following solutions print first such subarray.
*/
public class SubarraySum {

	public static void main(String[] args) {
		int [][] A = {
				{15, 2, 4, 8, 9, 5, 10, 23},
				{1, 4, 20, 3, 10, 5},
				{1, 4, 0, 0, 3, 10, 5},
				{1, 4}
		};
		
		SubarraySum ss = new SubarraySum();
		
		int [] sum = {23, 33, 7, 0};
		
		for (int i=0; i<A.length; i++) {
			ArrayList<Integer> result = ss.subArraySum(A[i], sum[i]);
			System.out.println("array is: " + Arrays.toString(A[i]));
			System.out.println("subarray with sum: " + sum[i]);
			for (int x: result) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<Integer> subArraySum(int [] A, int sum) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if (A == null || A.length < 1) {
			return result;
		}
		
		long currSum = A[0];
		int start = 0;
		int end = 0;
		
		for (int i=1; i<A.length; i++) {
			while (currSum > sum && start < i) {
				currSum = currSum - A[start];
				++start;
			}
			if (currSum == sum) {
				end = i-1;
				break;
			}
			currSum += A[i];
		}
		
		for (int i=start; i<=end; i++) {
			result.add(A[i]);
		}
		
		return result;
	}
}
