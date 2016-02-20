package i_MaxPoints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MaxPoints {
	
	public static void main(String[] args) {
		Integer [] X = {1, 2};
		Integer [] Y = {1, 2};
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		Collections.addAll(a, X);
		Collections.addAll(b, Y);
		System.out.println("max points: " + maxPoints(a, b));
	}

	public static int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		if (a == null || a.size() == 0) {
			return 0;
		}
		
		int N = a.size();

		HashMap<Double, Integer> result = new HashMap<Double, Integer>();
		int max = 0;

		for (int i = 0; i < N; i++) {
			int duplicate = 1;//
			int vertical = 0;
			for (int j = i + 1; j < N; j++) {
				// handle duplicates and vertical
				if (a.get(i).intValue() == a.get(j).intValue()) {
					if (b.get(i).intValue() == b.get(j).intValue()) {
						duplicate++;
					} else {
						vertical++;
					}
				} else {
					double slope = b.get(j).intValue()== b.get(i).intValue() ? 0.0
							: (1.0 * (b.get(j).intValue()- b.get(i).intValue()))
									/ (a.get(j).intValue()- a.get(i).intValue()) ;

					if (result.get(slope) != null) {
						result.put(slope, result.get(slope) + 1);
					} else {
						result.put(slope, 1);
					}
				}
			}

			for (Integer count : result.values()) {
				if (count + duplicate > max) {
					max = count + duplicate;
				}
			}

			max = Math.max(vertical + duplicate, max);
			result.clear();
		}

		return max;
	}
}
