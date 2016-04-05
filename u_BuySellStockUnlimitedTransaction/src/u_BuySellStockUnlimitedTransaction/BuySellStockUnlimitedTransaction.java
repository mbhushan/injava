package u_BuySellStockUnlimitedTransaction;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple
transactions at the same time (ie, you must sell the stock before you buy again).

Analysis:
This problem can be viewed as finding all ascending sequences. For example, given {5, 1, 2, 3, 4}, 
buy at 1 & sell at 4 is the same as buy at 1 &sell at 2 & buy at 2& sell at 3 & buy at 3 & sell at 4.
We can scan the array once, and find all pairs of elements that are in ascending order.
*/
public class BuySellStockUnlimitedTransaction {

	public static void main(String [] args) {
		BuySellStockUnlimitedTransaction BSS = new BuySellStockUnlimitedTransaction();
		int [] prices = {2, 5, 7, 1, 4, 3, 1, 3};
		System.out.println("max profit: " + BSS.maxProfit(prices));
	}
	
	public int maxProfit(int [] prices) {
		int profit = 0;
		for (int i=1; i<prices.length; i++) {
			int diff = prices[i] - prices[i-1];
			if (diff > 0) {
				profit += diff;
			}
		}
		return profit;
	}
}
