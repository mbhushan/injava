package i_JumpMinHops;

import java.util.ArrayList;
import java.util.Collections;

public class MinJump {
	
	public static void main(String[] args) {
		Integer [] X = {2,3,1,1,4};
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		
		Collections.addAll(A, X);
		System.out.println("min jump steps: " + jump(A));
	}

	public static int jump(ArrayList<Integer> A) {
		int N = A.size();
		int steps = 0;
		for (int i = 0, max = 0, next = 0; i < N - 1 && next < N - 1; ++i) {
			max = Math.max(max, i + A.get(i).intValue());
			if (i == next) { // ready to jump
				if (max == next)
					return -1; // unreachable
				next = max;
				++steps;
			}
		}
		return steps;
	}
}
