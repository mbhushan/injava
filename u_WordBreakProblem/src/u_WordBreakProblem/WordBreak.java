package u_WordBreakProblem;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	private static Set<String> dict = new HashSet<String>();
	public static void main(String [] args) {
		String [] S = {"i", "like", "had", "play", "to", "sam", "sung", "samsung", "mobile", "ice", 
				  "cream", "icecream", "man", "go", "mango"};
		for (int i=0; i<S.length; i++) {
			dict.add(S[i]);
		}
		
		String [] texts = {
				"ilikesamsung", "iiiiiiii", "ilikelikeimangoiii", "samsungandmango", "samsungandmangok", "Ihadliketoplay"
		};
		
		WordBreak WB = new WordBreak();
		for (int i=0; i<texts.length; i++) {
			System.out.println(WB.breakWord(texts[i].toLowerCase().toCharArray(), 0));
		}
	}
	
	/*
	 * recursive version of the word break problem
	 */
	public String breakWord(char [] str, int index) {
		StringBuffer sb = new StringBuffer();
		for (int i=index; i<str.length; i++) {
			sb.append(str[i]);
			if (dict.contains(sb.toString())) {
				String result = breakWord(str, i+1);
				if (result != null) {
					sb.append(" " + result);
					return sb.toString();
				}
			}
		}
		
		if (dict.contains(sb.toString())) {
			return sb.toString();
		}
		
		return null;
	}
}
