package i_IntersectionArrays;

import java.util.ArrayList;
import java.util.List;

public class Intersection {

	public static ArrayList<Integer> intersect(final List<Integer> a,
			final List<Integer> b) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		int i = 0, j = 0;
		int m = a.size();
		int n = b.size();
		while (i < m && j < n) {
			if (a.get(i) < b.get(j)) {
				i++;
			} else if (b.get(j) < a.get(i)) {
				j++;
			} else /* if a[i] == b[j] */{
				result.add(b.get(j));
				j++;
				i++;
			}
		}

		return result;
	}
	
	public static void main(String [] args) {
		int [] A = {1, 2, 3, 3, 4, 5, 6};
		int [] B = {3, 3, 5};
		
		ArrayList<Integer> X = new ArrayList<Integer>();
		ArrayList<Integer> Y = new ArrayList<Integer>();
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		for (int i=0; i<B.length; i++) {
			Y.add(B[i]);
		}
		
		ArrayList<Integer> ans = intersect(X, Y);
		for (int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		System.out.println();
	}

}
