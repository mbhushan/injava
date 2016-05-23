package fx_MoveAllZerosToEnd;

/*
 Move all zeroes to end of array
 Given an array of random numbers, Push all the zero’s of a given array to the end of the array. 
 For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. 
 The order of all other elements should be same. Expected time complexity is O(n) and extra space is O(1).
 */
public class MoveAllZeros {

	public static void main(String[] args) {
		MoveAllZeros MA = new MoveAllZeros();

		int[][] A = {
				{ 0, 1, 0, 2, 0, 3, 0 },
				{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}
		};
		for (int i=0; i<A.length; i++) {
			//MA.moveZeroToEnd(A[i]);
			MA.moveZeroEnd(A[i]);
		}
	}
	
	public void moveZeroEnd(int [] A) {
		int count = 0; //count of non zero elements.
		
		// Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
		for (int i=0; i<A.length; i++) {
			if (A[i] != 0) {
				A[count++] = A[i];
			}
		}
		
		// Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
		while (count < A.length) {
			A[count++] = 0;
		}
		
		for (Integer x: A) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	public void moveZeroToEnd(int[] A) {
		int z = 0;
		int n = 0;
		int len = A.length;
		while ((z < len) && A[z] != 0) {
			z += 1;
		}
		if (z == len) {
			return;
		}
		n = z;
		while ((n < len) && A[n] == 0) {
			n += 1;
		}
		if (n == len) {
			return;
		}

		while (z < len && n < len) {
			swap(A, z, n);
			while ((z < len) && A[z] != 0) {
				z += 1;
			}
			while ((n < len) && A[n] == 0) {
				n += 1;
			}
		}
		
		for (Integer x: A) {
			System.out.print(x + " ");
		}
		System.out.println();

	}
	
	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
