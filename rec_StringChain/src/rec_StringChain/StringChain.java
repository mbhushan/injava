package rec_StringChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array of strings, find if the strings can be chained to form a circle
Given an array of strings, find if the given strings can be chained to form a circle. 
A string X can be put before another string Y in circle if the last character of X is same as first character of Y.

Examples:

Input: arr[] = {"geek", "king"}
Output: Yes, the given strings can be chained.
Note that the last character of first string is same
as first character of second string and vice versa is
also true.

Input: arr[] = {"for", "geek", "rig", "kaf"}
Output: Yes, the given strings can be chained.
The strings can be chained as "for", "rig", "geek" 
and "kaf"

Input: arr[] = {"aab", "bac", "aaa", "cda"}
Output: Yes, the given strings can be chained.
The strings can be chained as "aaa", "aab", "bac" 
and "cda"

Input: arr[] = {"aaa", "bbb", "baa", "aab"};
Output: Yes, the given strings can be chained.
The strings can be chained as "aaa", "aab", "bbb" 
and "baa"

Input: arr[] = {"aaa"};
Output: Yes

Input: arr[] = {"aaa", "bbb"};
Output: No
*/

public class StringChain {

	public static void main(String[] args) {
		StringChain sc = new StringChain();
		
		//String [] words = {"for", "geek", "rig", "kaf"};
		String [] words = { "aaa", "bbb", "baa", "aab" };
		//String [] words = {"ab", "bc", "cd", "da"};
		//String [] words = { "ab", "bc", "cd", "db", "bf", "fg", "ga" };
		System.out.println("possible chain: " + sc.chainPossible(words));
	}
	
	@Test
	public void testWordChaining() {
		List<String[]> list = new ArrayList<>();

		list.add(new String[] { "for", "geer", "rig", "raf" });
		list.add(new String[] { "aaa", "bbb", "baa", "aab" });
		list.add(new String[] { "aaa" });
		list.add(new String[] { "aaa", "bbb" });
		list.add(new String[] { "aab", "bac", "aaa", "cda" });
		list.add(new String[] { "geek", "king" });
		list.add(new String[] { "geek", "kink", "kick" });
		list.add(new String[] { "aa", "cd", "dc" });
		list.add(new String[] { "ab", "bc", "cd", "db", "bf", "fg", "ga" });
		list.add(new String[] { "abb" });
		list.add(new String[] { "ab", "bc", "cd", "db", "bf", "fg", "fg" });
		list.add(new String[] { "ab", "bc", "cd", "db", "bf", "fg", "gh" });
		boolean [] result = {true, true, true, false, true, true, false, false, true, false, false, false};
		
		StringChain sc = new StringChain();
		int i =0;
		for (String [] words: list) {
			Assert.assertEquals(result[i++], sc.chainPossible(words));
			System.out.println("test passed for index: " + Arrays.toString(words));
		}
		
	}
	
	
	//assumes all chars are lower case.
	public boolean chainPossible(String [] words) {
		if (words == null || words.length < 1) {
			return false;
		}
		return chainPossible(words, 1, words[0].charAt(words[0].length()-1));
	}
	
	private boolean chainPossible(String [] words, int index, char prev) {
		if (index == words.length) {
			return prev == words[0].charAt(0);
		}

		for (int i=index; i<words.length; i++) {
			if (words[i].charAt(0) == prev) {
				//swap i & index
				String temp = words[i];
				words[i] = words[index];
				words[index] = temp;
				boolean flag = chainPossible(words, index+1, words[index].charAt(words[index].length()-1));
				if (flag) {
					return true;
				}
			}
		}
		
		return false;
	}
}
