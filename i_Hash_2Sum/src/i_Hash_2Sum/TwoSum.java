package i_Hash_2Sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {
	
	
	public static void main(String[] args) {
		int [] X = {2, 7, 11, 15};
		//int [] X = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
		List<Integer> A = new ArrayList<Integer>();
		for (int i=0; i<X.length; i++) {
			A.add(X[i]);
		}
		int b = -3;
		ArrayList<Integer> R = twoSum(A, b);
		for (int i=0; i<R.size(); i++) {
			System.out.print(R.get(i) + " ");
		}
		System.out.println();
	}

	public static ArrayList<Integer> twoSum(final List<Integer> a, int b) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if (a == null) {
			return result;
		}
		
		HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<Integer, ArrayList<Integer>>();
		int len = a.size();
		
		for (int i=0; i<len; i++) {
			int index = i;
			ArrayList<Integer> indices = new ArrayList<Integer>();
			int key = a.get(i).intValue();
			if (hmap.containsKey(key)) {
				indices = hmap.get(key);
			}
			indices.add(index);
			hmap.put(key, indices);
		}
		
		int y = len;
		int x = len;
		for (int i=len-1; i>=0; i--) {
			int diff = b - a.get(i).intValue();
			if (hmap.containsKey(diff)) {
				ArrayList<Integer> indices = hmap.get(diff);
				int size = indices.size();
				for (int j=0; j<size; j++) {
					int val = indices.get(j);
					if (val != i && val > i) {
						if (val <= y && i <= x) {
							y = val;
							x = i;
						}
					}
				}
			}
			
		}
		if (x == len ) {
			return result;
		}
		result.add(x+1);
		result.add(y+1);
		return result;
		
	}
}
