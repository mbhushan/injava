package i_MaxProfitStocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxProfit {

	public static void main(String[] args) {
		Integer [] A = {1, 2, 3};
		List<Integer> prices = new ArrayList<Integer>();
		Collections.addAll(prices, A);
		
		System.out.println("max profit: " + maxProfit(prices));
	}
	
	public static int  maxProfit(final List<Integer> prices) {
		int length = prices.size();
		int profit = 0;
	    for(int i=1; i<length; i++){
	        int diff = prices.get(i).intValue()-prices.get(i-1).intValue();
	        if(diff > 0){
	            profit += diff;
	        }
	    }
	    return profit;
	}
}
