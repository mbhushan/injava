package pc_GenerateParenthesis;

import java.util.ArrayList;

public class GenerateParenthesis {

	public static void main(String[] args) {
		GenerateParenthesis GP = new GenerateParenthesis();
		
		int n = 3;
		ArrayList<String> result = GP.generateParenthesis(n);
		for (String st: result) {
			System.out.println(st);
		}
	}
	
	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		dfs(result, "", n, n);
		
		return result;
	}
	
	private void dfs(ArrayList<String> result, String sb, int left, int right) {
		if (left > right) {
			return ;
		}
		
		if (left == 0 && right == 0) {
			result.add(sb);
			return;
		}
		
		if (left > 0) {
			dfs(result, sb+'(', left-1, right);
		}
		
		if (right > 0) {
			dfs(result, sb+')', left, right-1);
		}
	}
}
