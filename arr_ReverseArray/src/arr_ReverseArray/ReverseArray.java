package arr_ReverseArray;

public class ReverseArray {

	public static void main(String[] args) {
		int [] A = {1,2,3,4,5,6,7};
		new ReverseArray().reverseArray(A);
		for (int i: A) {
			System.out.print(i + " ");
		}
	}
	
	
	public void reverseArray(int [] A) {
		if (A == null || A.length <= 1) {
			return;
		}
		int start = 0;
		int end = A.length-1;
		
		while (start < end) {
			int temp = A[start];
			A[start] = A[end];
			A[end] = temp;
			++start;
			--end;
		}
	}
}
