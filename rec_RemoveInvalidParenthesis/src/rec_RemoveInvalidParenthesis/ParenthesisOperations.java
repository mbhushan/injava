package rec_RemoveInvalidParenthesis;


/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]
*/
public class ParenthesisOperations {

	public static void main(String[] args) {
		ParenthesisOperations po = new ParenthesisOperations();
		String [] str = {"()())()", "(a)())()", ")("}; 
		
		//for (int i=0; i<str.length; i++) {
			po.fixParenthesis(str[1].toCharArray());
		//}
		
	}
	
	public void fixParenthesis(char [] paren) {
		int left = 0;
		int right = 0;
		int index = 0;
		StringBuffer sb = new StringBuffer();
		int len = 7;
		fixParenthesis(paren, left, right, index, sb, len);
	}
	
	private  void fixParenthesis(char [] paren, int left, int right, int index, StringBuffer sb, int len) {
		if ((index == paren.length) && (left == right)) {
			System.out.println(sb.toString());
			return ;
		}
		
		if (index == paren.length || right > left) {
			return;
		}
		
		if (paren[index] == '(') {
				sb.append('(');
				fixParenthesis(paren, left+1, right, index+1, sb, len);
				sb.deleteCharAt(sb.length()-1);
				fixParenthesis(paren, left, right, index+1, sb, len);
		} else if (paren[index] == ')') {
				sb.append(')');
				fixParenthesis(paren, left, right+1, index+1, sb, len);
				sb.deleteCharAt(sb.length()-1);
				fixParenthesis(paren, left, right, index+1, sb, len);
		} else {
			fixParenthesis(paren, left, right, index+1, sb.append(paren[index]), len);
		} 
	}
}
