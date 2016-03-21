package i_MinJumps;

import java.util.ArrayList;

public class MinJumps {

	public static void  minJumps(ArrayList<Integer> a, int b) {
		int n = a.size();
		int [] cost = new int[n+1];
		int [] parent = new int[n+1];
		cost[1] = a.get(0).intValue();
		for (int i = 2; i <= n; i++) {
			int mn = Integer.MAX_VALUE;
			parent[i] = -1;
			for (int j = i - 1; j >= (i - b); j++) {
				if (a.get(j).intValue() != -1 && mn < cost[i]) {
					mn = cost[i];
					parent[i] = j;
				}
			}
			if (a.get(i).intValue() != -1 && parent[i] != -1)
				cost[i] = mn;
			else
				cost[i] = Integer.MAX_VALUE;
		}
	}
}
