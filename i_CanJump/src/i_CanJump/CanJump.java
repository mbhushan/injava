package i_CanJump;

import java.util.ArrayList;
import java.util.Collections;

public class CanJump {
	
	public static void main(String[] args) {
		Integer [] X = {2,3,1,1,4};
		Integer [] Y = {3,2,1,0,4};
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		
		Collections.addAll(A, X);
		Collections.addAll(B, Y);
		
		System.out.println("can jump: "  +canJump(A));
		System.out.println("can jump: "  +canJump(B));
		
	}

	public static int canJump(ArrayList<Integer> A) {
		int N = A.size();
		if (N <= 1)
			return 1;
		boolean[] canReach = new boolean[N];
		for (int i = N - 2, dist = 1; i >= 0; --i, ++dist) {
			if (A.get(i).intValue() >= dist) {
				canReach[i] = true;
			} else {
				int j = 1;
				while (j <= A.get(i).intValue() && !canReach[i + j])
					++j;
				if (j <= A.get(i).intValue())
					canReach[i] = true;
			}
		}
		if (canReach[0]) {
			return 1;
		}
		return 0;
	}
}
