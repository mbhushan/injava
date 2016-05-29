package arr_PairSum;

import java.util.Arrays;

public class PairSum {

	public static void main(String[] args) {
		PairSum PS = new PairSum();
		int [] A = {1, 4, 45, 6, 10, -8} ;
		int target = 16;
		
		Result result = PS.pairSum(A, target);
		if (result != null) {
			System.out.println("first number: " + A[result.start] + ", second number:" + A[result.end]);
		} else {
			System.out.println("no pairs found!");
		}
	}
	
	public Result pairSum(int [] A, int target) {
		if (A == null || A.length <= 1) {
			return null;
		}
		
		Arrays.sort(A);
		int front = 0;
		int back = A.length-1;
		while (front < back) {
			if (A[front] + A[back] == target) {
				return new Result(front, back);
			} else if (A[front] + A[back] < target) {
				++front;
			} else {
				--back;
			}
		}
		return null;
	}
}

class Result {
	int start;
	int end;
	
	Result(int s, int e) {
		this.start = s;
		this.end = e;
	}
}
