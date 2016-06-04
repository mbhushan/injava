package arr_Sort012;

/*
Sort an array of 0s, 1s and 2s
Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last.

Example
Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
 */
public class Sort012 {

	public static void main(String[] args) {
		Sort012 srt = new Sort012();
		
		int [] A = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		srt.sort012(A);
		
		for (int i: A) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public void sort012(int [] A) {
		int len = A.length;

		int low = 0;
		int mid = 0;
		int high = len-1;
		
		while (mid <= high) {
			if (A[mid] == 0) {
				swap(A, low, mid);
				low++;
				mid++;
			} else if (A[mid] == 1) {
				mid++;
			} else if (A[mid] == 2) {
				swap(A, mid, high);
				high--;
			}
		}
		return;
	}
	
	private void swap(int [] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
