package u_BuySellStockKTransactions;

import java.util.Deque;
import java.util.LinkedList;


/*
 * Given stockc prices for certain days and at most k transactions how to buy and sell
 * to maximize profit.
 *
 * Time complexity - O(number of transactions * number of days)
 * Space complexity - O(number of transcations * number of days)
 *
 * https://leetcode.com/discuss/15153/a-clean-dp-solution-which-generalizes-to-k-transactions
 */
public class BuySellStocksKTransaction {

	public static void main(String [] args) {
		BuySellStocksKTransaction BSS = new BuySellStocksKTransaction();
		int prices[] = {2, 5, 7, 1, 4, 3, 1, 3};
		int k = 3;
		System.out.println("max profit: " + BSS.maxProfit(prices, k));
	}
	
	public int maxProfit(int [] prices, int k) {
		if (k == 0 || prices == null || prices.length == 0) {
			return 0;
		}
		int [][] T = new int[k+1][prices.length];
		
		for (int i=1; i<= k; i++) {
			int maxDiff = -prices[0];
			for (int j=1; j<prices.length; j++) {
				T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
				maxDiff = Math.max(T[i-1][j] - prices[j], maxDiff);	
			}
		}
		printSolution(T, prices);
		return T[k][prices.length - 1];
	}
	
	private void printSolution(int [][] T, int []prices) {
		int i = T.length - 1;
        int j = T[0].length - 1;

        Deque<Integer> stack = new LinkedList<>();
        while(true) {
            if(i == 0 || j == 0) {
                break;
            }
            if (T[i][j] == T[i][j-1]) {
                j = j - 1;
            } else {
                stack.addFirst(j);
                int maxDiff = T[i][j] - prices[j];
                for (int k = j-1; k >= 0; k--) {
                    if (T[i-1][k] - prices[k] == maxDiff) {
                        i = i - 1;
                        j = k;
                        stack.addFirst(j);
                        break;
                    }
                }
            }
        }

        while(!stack.isEmpty()) {
            System.out.println("Buy at price " + prices[stack.pollFirst()]);
            System.out.println("Sell at price " + prices[stack.pollFirst()]);
        }
	}
	
}
