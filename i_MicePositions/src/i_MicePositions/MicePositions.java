package i_MicePositions;

import java.util.ArrayList;
import java.util.Collections;

public class MicePositions {
	
	public static void main(String[] args) {
		Integer [] X = {4, -4, 2};
		Integer [] Y = {4, 0, 5};
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		Collections.addAll(a, X);
		Collections.addAll(b, Y);
		
		System.out.println("mice allotment: " + mice(a, b));
	}

	public static int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
		Collections.sort(a);
		Collections.sort(b);
		
		int ans = 0;
		int N = a.size();
		for(int i = 0; i < N; ++i) {
			ans = Math.max(ans, Math.abs(a.get(i).intValue() - b.get(i).intValue()));
		}
		return ans;
		
    }

}
