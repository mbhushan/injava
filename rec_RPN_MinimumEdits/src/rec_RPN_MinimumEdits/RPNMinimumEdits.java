package rec_RPN_MinimumEdits;

/*
Imagine x is an operand and * is a binary operator. We say a string of x and * follows Reverse Polish notation if it is a postfix notation. 

For example strings xx*, x, and xx*xx** follow Reverse Polish notation. 

Given a string of x and *, how many insert, delete, and replace operations are needed to make the string follow the RPN. 

For example, xx* need 0 operation to follow RPN since it already follows RPN. 
x*x needs two operations to become xx* which follows RPN. 
*xx* needs one operation to become xx* which follows RPN. 

Your algorithm should work for a string of size up to 100.
*/

public class RPNMinimumEdits {

	public static void main(String[] args) {
		RPNMinimumEdits rpn = new RPNMinimumEdits();
		String [] input = { "xxxx*x*x*", "xx*xx**", "x*x", "*xx*"};
		
		for (int i=0; i<input.length; i++) {
			System.out.println("input string: " + input[i]);
			System.out.println("min edits for RPN: " + rpn.minEdits(input[i]));
		}
	}
	
	public int minEdits(String input) {
		char [] data = input.toCharArray();
		return minEdits(data, 0, 0);
	}
	
	private int minEdits(char [] input, int index, int countX) {
		if (index == input.length) {
			if (countX > 1) {
				return Integer.MAX_VALUE;
			}
			return 0;
		}
		
		//if we have x, then we can use as it is, delete it or convert to *
		if (input[index] == 'x') {
			int v1 = minEdits(input, index+1, countX+1);
			
			int v2 = Integer.MAX_VALUE;
			if (countX > 1) {
				v2 = minEdits(input, index+1, countX-1);
				v2 = (v2 != Integer.MAX_VALUE) ? v2+1: Integer.MAX_VALUE;
			}
			
			//input[index] = '*';
			int v3 = minEdits(input, index+1, countX);
			v3 = (v3 != Integer.MAX_VALUE) ? v3+1: Integer.MAX_VALUE;
			
			return Math.min(Math.min(v1, v2), v3);
		}
		
		//If input is * we can take 2 xs and convert it to one x. 
        //we can either delete this * or convert it to x.
        //Remember adding anything does not make any sense since deleting things
        //can achieve same things unless cost of adding is different from deleting
		else { //(input[index] == '*') {
			if (countX >= 2) {
				return minEdits(input, index+1, countX-1);
			} else {
				int v1  = minEdits(input, index+1, countX);
				v1 = (v1 != Integer.MAX_VALUE) ? v1+1: Integer.MAX_VALUE;
				//input[index] = 'x';
				int v2 = minEdits(input, index+1, countX+1);
				v2 = (v2 != Integer.MAX_VALUE) ? v2+1: Integer.MAX_VALUE;
				
				return Math.min(v1, v2);
			}
		}
	}
	
}
