import java.util.Collections;
import java.util.HashSet;


public class WordBreak {
	

	private HashSet<String> dict ;
	private String [] words = {
			"to","am", "i", "where", "we", "are", "indians", "bangalore", "coders", "looking", "work", "like", "code", "free", "time"
	};
	
	WordBreak() {
		dict = new HashSet<String>();
		Collections.addAll(dict, words);
	}
	
	public static void main(String [] args) {
		WordBreak WB = new WordBreak();
		String str = "weindiansliketocode";
		String result = WB.breakWord(str.toCharArray(), 0);
		System.out.println("After word break:");
		System.out.println(result);
		
	}
	
	public String breakWord(char [] str, int low) {
		StringBuffer sb = new StringBuffer();
		for (int i=low; i<str.length; i++) {
			sb.append(str[i]);
			if (dict.contains(sb.toString())) {
				String result = breakWord(str, i+1);
				if (result != null) {
					return sb.toString() + " " + result;
				}
			}
		}
		if (dict.contains(sb.toString())) {
			return sb.toString();
		}
		return null;
	}
}
