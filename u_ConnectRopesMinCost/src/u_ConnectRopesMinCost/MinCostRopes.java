package u_ConnectRopesMinCost;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostRopes {

	public static void main(String [] args) {
		int [] ropes = {4, 3, 2, 6};
		System.out.println("min ropes cost: " + getCost(ropes));
	}
	
	public static int getCost(int [] ropes) {
		int len = ropes.length;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(len, new IntComparator());
		for (int i=0; i<len; i++) {
			pq.add(ropes[i]);
		}
		int totalCost = 0;
		while (pq.size() > 1) {
			int a = pq.remove();
			int b = pq.remove();
			totalCost += a+b;
			pq.add(a+b);
		}
		
		return totalCost;
	}
}

class IntComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if (o1 < o2) {
			return -1;
		} else if (o1 > o2) {
			return 1;
		}
		return 0;
	}
	
}
