package rec_ParenthesisValidity;

import java.util.HashSet;

/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]
*/
public class ParenthesisValidity {

	public static void main(String[] args) {
		ParenthesisValidity po = new ParenthesisValidity();
		String [] str = {"()())()", "(a)())()", ")("}; 
		
		for (int i=0; i<str.length; i++) {
			System.out.println("input: " + str[i]);
			System.out.println("valid strings: ");
			po.genValidParen(str[i].toCharArray());
			System.out.println();
		}
		
	}
	
	public void genValidParen(char [] paren) {
		int left = 0;
		int right = 0;
		int index = 0;
		int open = 0;
		StringBuffer sb = new StringBuffer();
		HashSet<String> result = new HashSet<String>();
		
		for (int i=0; i<paren.length; i++) {
			if (paren[i] == '(') {
				++left;
			} else if (paren[i] == ')') {
				if (left != 0) {
					--left;
				} else {
					++right;
				}
			}
		}
		removeInvalidParen(paren, left, right, open, index, sb, result);
		for (String st: result) {
			System.out.println(st);
		}
		
	}
	
	private void removeInvalidParen(char [] paren, int left, int right, int open, int index, StringBuffer sb, HashSet<String> result) {
		if (index == paren.length && left == 0 && right == 0 && open == 0) {
			//System.out.println(sb.toString());
			result.add(sb.toString());
			return;
		}
		if (index == paren.length || left < 0 || right < 0 || open < 0) {
			return;
		}
		
		int len = sb.length();
		if (paren[index] == '(') {
			removeInvalidParen(paren, left-1, right, open, index+1, sb, result);
			removeInvalidParen(paren, left, right, open+1, index+1, sb.append(paren[index]), result);
		} else if (paren[index] == ')') {
			removeInvalidParen(paren, left, right-1, open, index+1, sb, result);
			removeInvalidParen(paren, left, right, open-1, index+1, sb.append(paren[index]), result);
		} else {
			removeInvalidParen(paren, left, right, open, index+1, sb.append(paren[index]), result);
		}
		sb.setLength(len);
	}
}
