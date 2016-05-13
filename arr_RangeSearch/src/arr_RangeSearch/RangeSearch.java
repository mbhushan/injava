package arr_RangeSearch;

import java.util.Arrays;

public class RangeSearch {

	public int [] findRange(int [] A, int key, int left, int right) {
		if (A == null || A.length == 0) {
			return new int []{-1, -1};
		}
		
		if (left > right) {
			return new int []{-1, -1};
		}
		
		int mid = left + (right - left)/2;
		if (key < A[mid]) {
			return findRange(A, key, left, mid-1);
		} else if (key > A[mid]) {
			return findRange(A, key, mid+1, right);
		} else {
			 int[] leftRange = findRange(A, key, left, mid-1);
			 int[] rightRange = findRange(A, key, mid+1, right);
			 
			 int leftEnd = (leftRange[0] == -1 ? mid : leftRange[0]);
             int rightEnd = (rightRange[1] == -1 ? mid : rightRange[1]);
             return new int[]{leftEnd, rightEnd};
		}
	}
	
	public static void main(String[] args) {
		RangeSearch RS = new RangeSearch();
		
		int [] A = {5, 7, 7, 8, 8, 10};
		int key = 8;
		int [] ans = RS.findRange(A, key, 0, A.length-1);
		System.out.println("range is: " + ans[0] + " to " + ans[1]);
		
		 System.out.println(Arrays.toString(RS.findRange(new int[]{1,8,8,8,9}, 8, 0, 4)));
		    System.out.println(Arrays.toString(RS.findRange(new int[]{1,2,8,8,8,9}, 8, 0, 5)));
		    System.out.println(Arrays.toString(RS.findRange(new int[]{1,2,3,8,8,8,9}, 8, 0, 6)));
		    System.out.println(Arrays.toString(RS.findRange(new int[]{1,2,3,4,8,8,8,9}, 8, 0, 7)));
		    System.out.println(Arrays.toString(RS.findRange(new int[]{1,2,3,4,5,8,8,9}, 8, 0, 7)));
		    System.out.println(Arrays.toString(RS.findRange(new int[]{1,2,3,4,5,6,8,9}, 8, 0, 7)));
		    System.out.println(Arrays.toString(RS.findRange(new int[]{1,2,3,4,8,8,8,9}, 7, 0, 7)));
	}
}
