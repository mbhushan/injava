package i_SearchInsert;

import java.util.ArrayList;

public class SearchInsert {

	public static int searchInsert(ArrayList<Integer> a, int b) {
		
		if (a == null || a.size() == 0) {
            return -1;
        }
        if (b < a.get(0)) {
            return 0;
        }

        int start = 0;
        int end = a.size() - 1;
        int mid;
        int target = b;

        // Binary search:
        while ((start + 1) < end) {
            mid = start + (end - start) / 2;
            if (a.get(mid).intValue() == target) {
                return mid;
            } else if (a.get(mid).intValue() < target) {
                start = mid;
            } else if (a.get(mid).intValue() > target) {
                end = mid;
            }
        }

        // Now that target should be
        // 1.equals start or end. Then the index of start/end should be returned
        if (a.get(start).intValue() == target) {
            return start;
        }
        if (a.get(end).intValue() == target) {
            return end;
        }
        // 2. larger than end. Then it should be inserted after end. So index is end + 1.
        if (a.get(end).intValue() < target) {
            return end + 1;
        }
        // 3. larger than start but smaller than end. Should be inserted after start. So index is start + 1.
        return start + 1;
    }

	public static void main(String[] args) {
		int [] A = {1, 3, 5, 6};
		int [] B = {5, 2, 7, 0};
		
		ArrayList<Integer> X = new ArrayList<Integer>();
		
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		
		for (int i=0; i<B.length; i++) {
			System.out.println("search and insert: " + searchInsert(X, B[i]));
		}
	}
	
	
}
