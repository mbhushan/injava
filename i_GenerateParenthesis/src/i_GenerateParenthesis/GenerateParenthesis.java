package i_GenerateParenthesis;

import java.util.ArrayList;

public class GenerateParenthesis {
	
	private static ArrayList<String> result;
	
	public static void main(String[] args) {
		int a = 3;
		generateParenthesis(a);
	}
	
	public static ArrayList<String> generateParenthesis(int a) {
		char [] str = new char[a*2];
		result = new ArrayList<String>();
		generateCombinations(str, a, 0, 0, 0);
		
		return result;
	}

	private static void generateCombinations(char[] str, int n, int left,
			int right, int index) {
		if (index == (n * 2)) {
			StringBuffer sb = new StringBuffer(new String(str));
			System.out.println(sb.toString());
			result.add(sb.toString());
		}
		if (left < n) {
			str[index] = '(';
			generateCombinations(str, n, left + 1, right, index + 1);
		}
		if (right < left) {
			str[index] = ')';
			generateCombinations(str, n, left, right + 1, index + 1);
		}
	}
}
