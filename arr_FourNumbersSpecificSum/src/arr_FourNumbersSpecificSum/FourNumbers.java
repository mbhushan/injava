package arr_FourNumbersSpecificSum;

/*
Find four elements that sum to a given value | Set 1 (n^3 solution)
Given an array of integers, find all combination of four elements in the array whose sum is equal to a given value X.
For example, if the given array is {10, 2, 3, 4, 5, 9, 7, 8} and X = 23, then your function should print “3 5 7 8″ (3 + 5 + 7 + 8 = 23).
*/
public class FourNumbers {
	
	public static void main(String[] args) {
		FourNumbers fn = new FourNumbers();
		int [] A = {10, 2, 3, 4, 5, 9, 7, 8};
		int X = 23;
		fn.findSum(A, X);
	}
	
	public void findSum(int [] A, int X) {
		if (A == null || A.length < 3) {
			return;
		}
		int n = A.length;
		boolean found = false;
		for (int i=0; i<n-3; i++) {
			for (int j=i+1; j<n-2; j++) {
				int left = j + 1;
				int right = n - 1;
				while (left < right) {
					int val = A[i] + A[j] + A[left] + A[right];
					if (val == X) {
						found = true;
						System.out.println("numbers are: " + A[i] + ", " + A[j] + ", " + A[left] + ", " + A[right]);
						++left;
						--right;
					} else if (val < X) {
						++left;
					} else {
						--right;
					}
				}
			}
		}
		if (!found) { 
			System.out.println("numbers not found!");
		}
		
		return;
	}
}
