package i_LongestValidParenthesis;

import java.util.Stack;

public class LongestVaidParen {

	public static void main(String[] args) {
		String st = "())()()(()";
		System.out.println("length of valid paren:" + longestValidParentheses(st));
		System.out.println("length of valid paren using stack: " + longestValidParenStack(st));
		System.out.println("length of valid paren using stack: " + longestValidParenStack("((()"));
	}
	
	public static int longestValidParenStack(String s) {  
		   int maxLen = 0, last = -1;  
		   Stack<Integer> lefts = new Stack<Integer>();  
		   for (int i=0; i<s.length(); ++i) {  
		     if (s.charAt(i)=='(') {  
		       lefts.push(i);  
		     } else {  
		       if (lefts.isEmpty()) {  
		         // no matching left  
		         last = i;  
		       } else {  
		         // find a matching pair  
		         lefts.pop();  
		         if (lefts.isEmpty()) {  
		           maxLen = Math.max(maxLen, i-last);  
		         } else {  
		        	 //System.out.println("left peek: " + (i - lefts.peek()));
		           maxLen = Math.max(maxLen, i-lefts.peek());  
		         }  
		       }  
		     }  
		   }  
		   return maxLen;  
		 }  
	public static int longestValidParentheses(String s) {
		return Math.max(findValidParentheses(s, 0, s.length(), 1, '('),  
		           findValidParentheses(s, s.length()-1, -1, -1, ')'));  
	}
	
	private static int findValidParentheses(String s, int start, int end, int step, char cc) {  
		   int maxLen = 0, count = 0, len = 0;  
		   for (int i=start; i!=end; i+=step) {  
		     if (s.charAt(i)==cc) {  
		       ++count;  
		     } else {  
		       if (count>0) {  
		         // exist a matching  
		         --count;  
		         len += 2;  
		         if (count==0) maxLen = Math.max(maxLen, len);  
		       } else {  
		         // no matching  
		         len = 0;  
		       }  
		     }  
		   }  
		   return maxLen;  
		 }  
}
