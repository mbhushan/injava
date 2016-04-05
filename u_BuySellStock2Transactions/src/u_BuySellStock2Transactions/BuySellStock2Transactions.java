package u_BuySellStock2Transactions;

public class BuySellStock2Transactions {

	public static void main(String [] args) {
		BuySellStock2Transactions BSS = new BuySellStock2Transactions();
		int [] prices = {1, 4, 5, 7, 6, 3, 2, 9};
		System.out.println("max profit: " + BSS.maxProfit(prices));
	}
	
	public int maxProfit(int [] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int len = prices.length;
		//highest profit in 0...i
		int [] left = new int[len];
		int [] right = new int[len];
		
		left[0] = 0;
		int min = prices[0];
		for (int i=1; i<len; i++) {
			min = Math.min(min, prices[i]);
			left[i] = Math.max(left[i-1], prices[i] - min);
		}
		
		right[len-1] = 0;
		int max = prices[len-1];
		for (int i=len-2; i>=0; i--) {
			max = Math.max(max, prices[i+1]);
			right[i] = Math.max(right[i+1], max - prices[i]);
		}
		
		int maxProfit = 0;
		for (int i=0; i<len; i++) {
			maxProfit = Math.max(maxProfit, left[i] + right[i]);
		}
		return maxProfit;
	}
	
}
