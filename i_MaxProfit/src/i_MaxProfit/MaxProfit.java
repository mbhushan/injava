package i_MaxProfit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxProfit {
	
	public static void main(String[] args) {
		Integer [] A = {1,2};
		List<Integer> prices = new ArrayList<Integer>();
		Collections.addAll(prices, A);
		
		System.out.println("max profit: " + maxProfit(prices));
	}

	public static int maxProfit(final List<Integer> prices) {
		int N = prices.size();
		if (N == 0)
			return 0;

		int profit = 0;
		int low = prices.get(0).intValue();
		for (int day = 1; day < N; ++day) {
			if (prices.get(day).intValue() < low) {
				// new low price, try to buy
				low = prices.get(day);
			} else {
				// try to sell
				profit = Math.max(profit, prices.get(day) - low);
			}
		}
		return profit;
	}
}
