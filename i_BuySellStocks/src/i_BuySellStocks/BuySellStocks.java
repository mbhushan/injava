package i_BuySellStocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuySellStocks {
	
	public static void main(String[] args) {
		Integer [] P = {1,2,1,2};
		List<Integer> prices = new ArrayList<Integer>();
		Collections.addAll(prices, P);
		System.out.println("max profit: " + maxProfit(prices));
		
	}

	public static int maxProfit(final List<Integer> prices) {
		int size = prices.size();
		if (prices == null || size < 2) {
			return 0;
		}
	 
		//highest profit in 0 ... i
		int[] left = new int[size];
		int[] right = new int[size];
	 
		// DP from left to right
		left[0] = 0; 
		int min = prices.get(0).intValue();
		for (int i = 1; i < size; i++) {
			min = Math.min(min, prices.get(i).intValue());
			left[i] = Math.max(left[i - 1], prices.get(i).intValue() - min);
		}
	 
		// DP from right to left
		right[size - 1] = 0;
		int max = prices.get(size - 1).intValue();
		for (int i = size - 2; i >= 0; i--) {
			max = Math.max(max, prices.get(i).intValue());
			right[i] = Math.max(right[i + 1], max - prices.get(i).intValue());
		}
	 
		int profit = 0;
		for (int i = 0; i < size; i++) {
			profit = Math.max(profit, left[i] + right[i]);
		}
	 
		return profit;
	}
}
