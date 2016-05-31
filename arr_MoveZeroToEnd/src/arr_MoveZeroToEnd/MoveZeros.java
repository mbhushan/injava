package arr_MoveZeroToEnd;

public class MoveZeros {

	public static void main(String[] args) {
		int [] A = {0, 2, 0, 3, 0, 0, 1, 2, 3, 0};
		MoveZeros MZ = new MoveZeros();

		MZ.moveZerosToEnd(A);
		System.out.println("after moving zeros to end");
		for (int x: A) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
	public void moveZerosToEnd(int [] A) {
		if (A == null || A.length <= 1) {
			return ;
		}
		int len = A.length;
		int count = 0;
		
		for (int i=0; i<A.length; i++) {
			if (A[i] != 0) {
				A[count++] = A[i];
			}
		}
		
		while (count < A.length) {
			A[count++] = 0;
		}
	}
}
