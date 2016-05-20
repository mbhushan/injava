package pc_MobileDigits;

import java.util.ArrayList;
import java.util.HashMap;

/*
Given a digit string, return all possible letter combinations that the number could represent. 
(Check out your cellphone to see the mappings) Input:Digit string "23", Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

public class MobileDigits {

	public static void main(String[] args) {
		MobileDigits MD = new MobileDigits();
		String digits = "2378";
		ArrayList<String> result = MD.letterCombination(digits);
		for (String st: result) {
			System.out.println(st);
		}
	}
	
	public ArrayList<String> letterCombination(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		
		if (digits == null || digits.length() < 1) {
			return result; 
		}
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
	    map.put(2, "abc");
	    map.put(3, "def");
	    map.put(4, "ghi");
	    map.put(5, "jkl");
	    map.put(6, "mno");
	    map.put(7, "pqrs");
	    map.put(8, "tuv");
	    map.put(9, "wxyz");
	    map.put(0, "");
	    
	    StringBuffer sb = new StringBuffer();
	    dfs(digits, 0, sb, map, result);
		
		return result;
	}
	
	private void dfs(String digits, int step, StringBuffer sb, HashMap<Integer, String> hmap, ArrayList<String> result) {
		if (step == digits.length()) {
			result.add(sb.toString());
			return;
		}
		
		Character curr = digits.charAt(step);
		String str = hmap.get(Character.getNumericValue(curr));
		int len = str.length();
		for (int i=0; i<len; i++) {
			sb.append(str.charAt(i));
			dfs(digits, step+1, sb, hmap, result);
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
