package arr_TripletSum;

import java.util.Arrays;

/*
 Find a triplet that sum to a given value
 Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. 
 If there is such a triplet present in array, then print the triplet and return true. Else return false. 
 For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum is 24, then there is a triplet (12, 3 and 9) 
 present in array whose sum is 24.
 */

public class TripletSum {

	public static void main(String[] args) {
		TripletSum ts = new TripletSum();

		int[] A = { 1, 4, 45, 6, 10, 8 };
		int sum = 22;
		ts.tripletSum(A, sum);

	}

	public void tripletSum(int[] A, int sum) {
		if (A == null || A.length < 3) {
			return;
		}

		Arrays.sort(A);
		for (int i = 0; i < A.length - 2; i++) {

			int left = i + 1;
			int right = A.length - 1;
			while (left < right) {
				int value = A[i] + A[left] + A[right];
				if (value == sum) {
					System.out.println("triplets are: " + A[i] + ", " + A[left]
							+ ", " + A[right]);
					return;
				} else if (value < sum) {
					++left;
				} else {
					--right;
				}
			}
		}
		System.out.println("no triplet found!");
	}
}
