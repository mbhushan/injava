package i_BookPages;

import java.util.ArrayList;

public class BookPages {

	public static int books(ArrayList<Integer> a, int b) {

		long sum = 0;
		int n = a.size();
		int m = b;

		if (n < m)
			return -1;

		for (int i = 0; i < n; ++i) {
			sum += a.get(i).intValue();
		}

		long start = 0;
		long end = sum, mid;
		int ans = Integer.MAX_VALUE;

		while (start <= end) {

			mid = (start + end) / 2;

			if (isPossible(a, n, m, mid)) {
				ans = Math.min(ans, (int) mid);
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}
	
	private static boolean isPossible(ArrayList<Integer> a, int n, int m, long curMin) {
		   
	    int studentsRequired = 1;
	    int curSum = 0;
	   
	    for (int i = 0; i < n; i++) {
	   
	        if (a.get(i).intValue() > curMin) return false;
	   
	        if ((curSum + a.get(i).intValue()) > curMin) {
	         
	            studentsRequired++;
	            curSum = a.get(i).intValue(); 
	            if (studentsRequired > m) return false;
	        } 
	        else {
	            curSum += a.get(i).intValue();
	        }
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		int [] A = {12, 34, 67, 90};
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		for (int i=0; i<A.length; i++) {
			a.add(A[i]);
		}
		int m = 2;
		System.out.println("books: " + books(a, m));
	}
}
