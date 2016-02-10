package i_MajorityElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElement {
	
	public static void main(String[] args) {
		Integer [] X = {2, 1, 2};
		ArrayList<Integer> A = new ArrayList<Integer>();
		
		Collections.addAll(A, X);
		System.out.println("majority element: " + majorityElement(A));
	}

	public static int majorityElement(final List<Integer> A) {
		int vote = 1;
		int len = A.size();
		int candidate = A.get(0).intValue();
		
		for (int i = 1; i < len; i++) {
			if (A.get(i).intValue() == candidate) {
				++vote;
			} else {
				if (vote > 0) {
					--vote;
				} else {
					candidate = A.get(i).intValue();
					++vote;
				}
			}
		}
		return candidate;
	}
}
