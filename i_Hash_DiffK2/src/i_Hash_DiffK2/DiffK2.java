package i_Hash_DiffK2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiffK2 {
	
	public static void main(String[] args) {
		//int [] X = {5, 20, 3, 2, 50, 80};
		//int [] X = {1, 5, 4, 1, 2};
		int [] X = {0};
		//int [] X = {25, 19, 92, 71, 82, 35, 71, 65, 91, 45, 64, 47, 11, 68, 85, 3, 28, 21, 94, 73, 8, 78, 54, 53, 31, 94, 20, 68, 26, 42};
		List<Integer> A = new ArrayList<Integer>();
		for (int i=0; i<X.length; i++) {
			A.add(X[i]);
		}
		int key = 0;
		System.out.println("pair possible: " + diffPossible(A, key));
	}

	public static int diffPossible(final List<Integer> A, int key) {
		
//		if (key < 1) {
//			return 0;
//		}
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		
		int size = A.size();
		
		for (int i=0; i<size; i++) {
			int count = 1;
			if (hmap.containsKey(A.get(i).intValue())) {
				count = hmap.get(A.get(i).intValue());
				++count;
			}
			hmap.put(A.get(i).intValue(), count);
		}
		
		for (int i=0; i<size; i++) {
			int target = A.get(i).intValue() + key;
			if (hmap.containsKey(target)) {
				int val = hmap.get(target);
				if (key == 0 && val >= 2) {
					return 1;
				}
				else if (key != 0 && val >= 1) {
					return 1;
				}
			}
		}
		return 0;
	}
}
