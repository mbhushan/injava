package i_SingleNumberV2;

public class Divide {
	public static int divide(int dividend, int divisor) {
		long denom=divisor;
	    long current = 1;
	    long answer=0;
	    int sign = dividend < 0 ^ divisor < 0 ? -1 : 1;
	   // System.out.println("sign: " + sign);
	    //System.out.println("a: " + dividend);

	    if ( Math.abs(denom) > Math.abs(dividend)) {
	        return 0;
	    }

	    if ( Math.abs(denom) == Math.abs(dividend)) {
	    	if (sign < 0) {
	    		return -1;
	    	}
	        return 1;
	    }
	    denom = Math.abs(denom);
	    dividend = Math.abs(dividend);

	    while (Math.abs(denom) <= dividend) {
	        denom = denom << 1;
	        current = current << 1;
	    }

	    //System.out.println("current: " + current);
	    denom = denom >> 1;
	        
	    current = current >> 1;
	    //System.out.println("denom: " + denom);
	    //System.out.println("current: " + current);


	    while (current > 0) {
	        if ( dividend >= denom) {
	            dividend -= denom;
	            answer = answer | current;
	        }
	        current = current >> 1;
	        denom = denom >> 1;
	       // System.out.println("stuk");
	    } 
	    if (sign < 0) {
	    	answer = -answer;
	    }
	    if (answer > Integer.MAX_VALUE) {
	    	return Integer.MAX_VALUE;
	    }
	    return (int)answer;
	}
	
	public static void main(String [] args) {
		int a = -2147483647;
		int b = -1;
	
		System.out.println("ans: "  + divide(a, b));
	}

}
