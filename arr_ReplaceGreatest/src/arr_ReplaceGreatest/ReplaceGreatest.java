package arr_ReplaceGreatest;

/*
Replace every element with the greatest element on right side
Given an array of integers, replace every element with the next greatest element (greatest element on the right side) in the array. 
Since there is no element next to the last element, replace it with -1. For example, if the array is {16, 17, 4, 3, 5, 2}, 
then it should be modified to {17, 5, 5, 5, 2, -1}.
*/

public class ReplaceGreatest {

	public static void main(String[] args) {
		ReplaceGreatest rg = new ReplaceGreatest();
		int [] A = {16, 17, 4, 3, 5, 2};
		rg.replaceGreatest(A);
		System.out.println("after replacement: ");
		for (int x : A) {
			System.out.print(x + " ");
		}
		System.out.println();
		
	}
	
	public void replaceGreatest(int [] A) {
		if (A == null || A.length < 1) {
			return ;
		}
		
		int maxSoFar = A[A.length-1];
		A[A.length-1] = -1;
		for (int i=A.length-2; i>=0; i--) {
			int buff = A[i];
			A[i] = maxSoFar;
			if (maxSoFar < buff) {
				maxSoFar = buff;
			}
		}
		return;
	}
}
