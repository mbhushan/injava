package stack_StockSpan;

import java.util.Stack;

/*
The stock span problem is a financial problem where we have a series of n daily price 
quotes for a stock and we need to calculate span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of 
consecutive days just before the given day, for which the price of the stock on the current 
day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, 
then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 */
public class StockSpan {

	
	public static void main(String [] args) {
		int [] prices = {100, 80, 60, 70, 60, 75, 85};
		StockSpan SS = new StockSpan();
		SS.stockSpan(prices);
	}
	
	public void stockSpan(int [] prices) {
		Stack<Integer> stack = new Stack<Integer>();
		int len = prices.length;
		int [] span = new int[len];
		
		stack.push(0);
		span[0] = 1;
		
		for (int i=1; i<len; i++) {
			// Pop elements from stack while stack is not empty and top of
		    // stack is smaller than price[i]
			while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
				stack.pop();
			}
			
			// If stack becomes empty, then price[i] is greater than all elements
		    // on left of it, i.e., price[0], price[1],..price[i-1].  Else price[i]
		    // is greater than elements after top of stack
			span[i] = stack.isEmpty() ? i+1 : (i - stack.peek());
			stack.push(i);
		}
		
		System.out.println("printing stock span: ");
		for (Integer s: span) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}
