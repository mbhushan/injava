package arr_MissingNumber;

/*
 Find the Missing Number
You are given a list of n-1 integers and these integers are in the range of 1 to n. 
There are no duplicates in list. One of the integers is missing in the list. Write an efficient code to find the missing integer.
 */

public class MissingNumber {

	public static void main(String[] args) {
		MissingNumber MN = new MissingNumber();
		int [] A = {1, 2, 4, 6, 3, 7, 8};
		System.out.println("missing number: " + MN.missingNumber(A));
	}
	
	public int missingNumber(int [] A) {
		int x1 = A[0];
		int x2 = 1;
		
		for (int i=1; i<A.length; i++) {
			x1 = x1^A[i];
		}
		
		for (int i=2; i<=A.length + 1; i++) {
			x2 = x2 ^  i;
		}
		
		return x1 ^ x2;
	}
}
