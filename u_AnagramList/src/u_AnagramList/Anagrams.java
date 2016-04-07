package u_AnagramList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Anagrams {

	
	public static void main(String [] args) {
		Anagrams anagrams = new Anagrams();
		String [] strings = {"least",
				"slate",
				"stale",
				"steal",
				"tales",
				"teals",
				"pares",
				"parse",
				"pears",
				"reaps",
				"spare",
				"spear"};
		ArrayList<String> wlist = new ArrayList<String>();
		Collections.addAll(wlist, strings);
		String [] target = {"teals", "mani", "parse"};
		for (String word: target) {
			ArrayList<String> result = anagrams.findAnagrams(word, wlist);
			System.out.println("anagrams for " + word);
			for (String str: result) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
	
	
	public ArrayList<String> findAnagrams(String word, ArrayList<String> wlist) {
		ArrayList<String> result = new ArrayList<String>();
		
		if (word == null || wlist == null) {
			return result;
		}
		
		char [] wordChars = word.toLowerCase().toCharArray();
		Arrays.sort(wordChars);
		//result.add(word);
		for (String str:  wlist) {
			if (str.equals(word)) {
				continue;
			}
			char [] strChars = str.toLowerCase().toCharArray();
			Arrays.sort(strChars);
			if (new String(wordChars).equals(new String(strChars))) {
				result.add(str);
			}
		}
		
		return result;
	}
}
