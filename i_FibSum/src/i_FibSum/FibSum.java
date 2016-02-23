package i_FibSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FibSum {

	private static Stack<Integer> st = new Stack<Integer>();
	
	public static void main(String[] args) {
		int n = 9;
		//System.out.println(fibsum(n));
		fibonacciSum(n);
	}
	
	public static void fibonacciSum(int n){
	    
	    int prev = 0, cur = 1;
	    st.push(prev);
	    while(cur<n){
	        int temp = prev;
	        prev = cur;
	        cur = temp + prev;
	        st.push(prev);
	    }
	    int sum = (int)st.pop();
	    System.out.println(sum);
	    recSum(sum,n);
	    }

	    public static void recSum(int sum, int n){
	       if((sum+(int)st.peek())==n){
	           System.out.println(sum+(int)st.peek() + " - " + st.pop());
	       }
	       else if((sum+(int)st.peek())>n){
	           st.pop();
	           recSum(sum, n);
	       }
	       else if((sum+(int)st.peek())<n){
	           sum+=(int)st.peek();
	           System.out.println(sum + " - " + st.peek());
	           recSum(sum,n);
	       }
	    }
	
	
	public static int fibsum(int n) {
		List<Integer> fiboNums = new ArrayList<Integer>();
		int a=1,b=1,c=1;
		fiboNums.add(c);
		while(true) {
			c = a+b;
			if(c<=n)
				fiboNums.add(c);
			else break;
			a = b;
			b = c;
		}
		System.out.println("fib nums: ");
		for (Integer x: fiboNums) {
			System.out.print(x + " ");
		}
		System.out.println();
		int minSum[] = new int[n+1];
		minSum[0] = 0;
		for(int i = 1;i<=n;i++) {
			minSum[i] = n; 
			for(Integer fibo : fiboNums) {
				int k = fibo;
				int steps = 0;
				if(k<=i) {
					steps = minSum[i-k] + 1;
					minSum[i] = Math.min(minSum[i], steps);
						
				}
				else break;
			}
		}
		return minSum[n];
	}
}
