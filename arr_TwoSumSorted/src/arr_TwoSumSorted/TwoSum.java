package arr_TwoSumSorted;

public class TwoSum {

	public static void main(String [] args) {
		int [] A = {2, 3, 7, 11, 19, 25, 33, 41};
		int target = 36;
		
		TwoSum TS = new TwoSum();
		Result result = TS.twoSum(A, target);
		System.out.println("numbers are: " + result.first + ", " + result.second);
	}
	
	public Result twoSum(int [] A, int target) {
		if (A == null || A.length < 2) {
			return null;
		}
		int len = A.length;
		int i = 0;
		int j = len-1;
		
		while (i < j) {
			if (A[i] + A[j] == target) {
				return new Result(A[i], A[j]);
			} else if (A[i] + A[j] < target) {
				++i;
			} else {
				--j;
			}
		}
		return null;
	}
}

class Result {
	int first;
	int second;
	
	Result (int f, int s) {
		first = f;
		second = s;
	}
}
