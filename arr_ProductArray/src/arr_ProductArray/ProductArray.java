package arr_ProductArray;

/*
A Product Array Puzzle
Given an array arr[] of n integers, construct a Product Array prod[] (of same size) 
such that prod[i] is equal to the product of all the elements of arr[] except arr[i]. 
Solve it without division operator and in O(n).

Example:
arr[] = {10, 3, 5, 6, 2}
prod[] = {180, 600, 360, 300, 900}

 */
public class ProductArray {

	public static void main(String[] args) {
		ProductArray PA = new ProductArray();
		
		int [] A =  {10, 3, 5, 6, 2};
		
		int [] result = PA.productArray(A);
		
		for (int i: result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	private int [] productArray(int [] A) {
		int len = A.length;
		
		int [] left = new int[len];
		int [] right = new int[len];
		int [] result = new int[len];
		
		left[0] = 1;
		right[len-1] = 1;
		for (int i=1; i<len; i++) {
			left[i] = A[i-1] * left[i-1];
		}
		
		for (int i=len-2; i>=0; i--) {
			right[i] = A[i+1] * right[i+1];
		}
		
		for (int i=0; i<len; i++) {
			result[i] = left[i] * right[i];
		}
		
		return result;
	}
}
