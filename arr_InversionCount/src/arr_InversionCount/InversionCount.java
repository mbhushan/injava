package arr_InversionCount;

import java.util.Arrays;

public class InversionCount {

	public static void main(String[] args) {
		InversionCount ic = new InversionCount();
		
		int [] A = {1, 20, 6, 4, 5};
		System.out.println("inversion count: " + ic.inversionCount(A));
		
		System.out.println("fast inversion count: " + ic.countInversionsFast(A));
	}
	
	public int countInversionsFast(int [] A) {
		if (A == null || A.length <= 1) {
			return 0;
		}
		int [] aux = Arrays.copyOf(A, A.length);
		return count(A, aux, 0, A.length-1);
	}
	
	private int count(int [] A, int [] aux, int low, int high) {
		int inversions = 0;
		
		if (low >= high) {
			return 0;
		}
		int mid = low + (high - low)/2;
		inversions += count(A, aux, low, mid);
		inversions += count(A, aux, mid+1, high);
		inversions += merge(A, aux, low, mid, high);

		return inversions;
	}
	
	private int merge(int [] A, int [] aux, int low, int mid, int high) {
		int inversions = 0;
		
		//copy to aux
		for (int i=low; i<=high; i++) {
			aux[i] = A[i];
		}
		
		//merge back to A
		int i = low;
		int j = mid+1;
		for (int k=low; k<=high; k++) {
			if (i > mid) {
				A[k] = A[j++];
			} else if (j > high) {
				A[k] = A[i++];
			} else if (aux[i] > aux[j]) {
				A[k] = A[j++];
				inversions += mid - i + 1;
			} else {
				A[k] = A[i++];
			}
		}
		return inversions;
	}
	
	//slow version of inversion count;
	public int inversionCount(int [] A) {
		if (A == null || A.length <= 1) {
			return 0;
		}
		
		int invCount = 0;
		for (int i=0; i<A.length; i++) {
			for (int j=i+1; j<A.length; j++) {
				if (A[i] > A[j]) {
					++invCount;
				}
			}
		}
		return invCount;
	}
}
