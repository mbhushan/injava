package i_SearchRotated;

import java.util.ArrayList;
import java.util.List;

public class SearchRotated {

	public static int search(final List<Integer> a, int b) {
		int n = a.size();
		int low = 0;
		int high = n - 1;
		int key = b;

		if (a == null || (n == 0)) {
			return -1;
		}
		
		while (low < high && a.get(low).intValue() == a.get(high).intValue()) {  
		      if (a.get(low).intValue() == key) return low;
		      if (a.get(high).intValue() == key) return high;
		      ++low; --high;  
		    } 

		while (low <= high) {
			
			int mid = (low + high) / 2;

			if (key == a.get(mid).intValue()) {
				return mid;
			} else if (key > a.get(high).intValue() && key < a.get(mid).intValue()) {
				high = mid - 1;
			} else if (key < a.get(low).intValue() && key > a.get(mid).intValue()) {
				low = mid + 1;
			} else {
				if (key < a.get(mid).intValue()) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int [] A = {4, 5, 6, 7, 0, 1, 2};
		ArrayList<Integer> X = new ArrayList<Integer>();
		
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		int b = 4;
		System.out.println("found at index: " + search(X, b));

	}

}
