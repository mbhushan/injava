
/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to buy one share of the stock and sell one share of the stock, 
design an algorithm to find the best times to buy and sell.

The question is equivalent to the following:
Find i and j that maximizes Aj – Ai, where i < j.
 */
public class BuySellStock {

	public static void main(String [] args) {
		int [] prices = {100, 180, 260, 310, 40, 535, 695};
		BuySellStock BSS = new BuySellStock();
		Result result = BSS.getBestTimes(prices);
		System.out.println(result.toString());
	}
	
	public Result getBestTimes(int [] prices) {
		int len = prices.length;
		int min = 0;
		int maxDiff = 0;
		int buy=0, sell=0;
		
		for (int i=0; i<len; i++) {
			if (prices[i] < prices[min]) {
				min = i;
			}
			int diff = prices[i] - prices[min];
			if (diff > maxDiff) {
				buy = min;
				sell = i;
				maxDiff = diff;
			}
		}
		return new Result(buy, sell);
	}
	
	private class Result {
		int buy;
		int sell;
		public Result(int buy, int sell) {
			this.buy = buy;
			this.sell = sell;
		}
		
		@Override
		public String toString() {
			return "Buy: day " + buy + "\n" + "Sell: day " + sell;
		}
	}
}
