package arr_ClosestToZero;

import java.util.Arrays;

/*
Two elements whose sum is closest to zero
Question: An Array of integers is given, both +ve and -ve. You need to find the two elements such that their sum is closest to zero.

For the below array, program should print -80 and 85.
*/
public class ClosestToZero {

	public static void main(String[] args) {
		int [] A = {1, 60, -10, 70, -80, 85};
		
		ClosestToZero CZ = new ClosestToZero();
		Result result = CZ.closeToZeroTwoSum(A);
		System.out.println("numbers are: " + result.toString());
		System.out.println("actual numbers are: " + A[result.first] + ", " + A[result.second]);
	}
	
	public Result closeToZeroTwoSum(int [] A) {
		Result result = new Result();
		
		if (A == null || A.length <= 1) {
			return result;
		}
		
		Arrays.sort(A);
		int i = 0;
		int j = A.length-1;
		int first = -1;
		int second = -1;
		int min = Integer.MAX_VALUE;
		while (i < j) {
			int sum = A[i] + A[j];
			if (Math.abs(sum) < Math.abs(min)) {
				min = sum;
				first = i; second = j;
			} 
			if (sum < 0) {
				++i;
			} else {
				--j;
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
	
	public String toString() {
		String str = first + ", " + second;
		return str;
	}
}
