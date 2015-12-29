package i_SearchRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchRange {
	private static ArrayList<Integer> result = new ArrayList<Integer>();
	private static int min = Integer.MAX_VALUE;
	private static int max = Integer.MIN_VALUE;
	
	public static ArrayList<Integer> searchRange(final List<Integer> a, int b) {
		int start = 0;
		int end = a.size()-1;
		
		searchNumOccurrence(a, b, start, end);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		if (max < 0) {
			ans.add(-1);
			ans.add(-1);
		} 
		//else if (result.size() == 1) {
			//ans.add(result.get(0));
			//ans.add(result.get(0));
		 else {
//			int mn = (int)Collections.min(result);
//			int mx = (int)Collections.max(result);
//			ans.add(mn);
//			ans.add(mx);
			//System.out.println("min: " + min);
			//System.out.println("max: " + max);
			ans.add(min);
			ans.add(max);
		}
		result.clear();
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		//System.out.println("printing ans");
		printList(ans);
		return ans;
	}
	
	private static void printList(ArrayList<Integer> A) {
		int n = A.size();
		for (int i=0; i<n; i++) {
			System.out.print(A.get(i) + " ");
		}
		System.out.println();
	}
	private static int searchNumOccurrence(List<Integer> A, int k, int start, int end) {
	    if (start > end) return 0;
	    int mid = (start + end) / 2;
	    if (A.get(mid) < k) return searchNumOccurrence(A, k, mid + 1, end);
	    else if (A.get(mid) > k) return searchNumOccurrence(A, k, start, mid - 1);
	    else {
	    	//result.add(mid);
	    	if (mid < min) min = mid;
	    	if (mid > max) max = mid;
	    }
	    return searchNumOccurrence(A, k, start, mid - 1) + 1 + searchNumOccurrence(A, k, mid + 1, end);
	}
	
	public static void main(String [] args) {
		int [] A = {5, 7, 7, 8, 8, 8, 8, 10};
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int i=0; i<A.length; i++) {
			
			X.add(A[i]);
		}
		int [] B = {1,5,7,8,10};
		for (int i=0; i < B.length; i++) {
			searchRange(X, B[i]);
		}
	}

}
