package fx_TargetSum;

import java.util.Arrays;

/*
Given an array of integers and a target number, find the two elements whose sum is closest to the target number.
*/

public class TargetSum {

	public static void main(String[] args) {
		TargetSum TS = new TargetSum();
		
		int [] A = {7, 5, 3, 11, 2, 15, 19, 17};
		int target = 29;

		Result result = TS.findTargetSum(A, target);
		System.out.println("result is: " + A[result.first] + ", " + A[result.second]);
	}
	
	public Result findTargetSum(int [] A, int target) {
		if (A == null || A.length <= 1) {
			return null;
		}
		
		Arrays.sort(A);
		System.out.println("sorted array: ");
		for (int x: A) {
			System.out.print(x + " ");
		}
		System.out.println();
		int len = A.length;
		int minDiff = Math.abs(target - (A[0] + A[len-1]));
		int i = 0;
		int j = len-1;
		Result result = new Result(i, j);
		int first = 0;
		int second = len-1;
		while (i < j) {
			int diff = Math.abs(target - (A[i] + A[j]));
			if (diff < minDiff) {
				minDiff = diff;
				first = i;
				second = j;
			} 
			if (A[i]+A[j] < target) {
				++i;
			} else if (A[i] + A[j] > target) {
				--j;
			} else {
				return new Result(i, j);
			}
			
		}
		
		result.first = first;
		result.second = second;
		
		return result;
	}
	
}
class Result {
	int first;
	int second;
	
	public Result(int f, int s) {
		this.first = f;
		this.second = s;
	}
}
