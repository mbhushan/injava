package in_WordLadderShortest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
Given two valid dictionary words of same length, write a function which returns the minimum number of 
steps to go from the first to the second word. 
You can change only one character at a time. Also, the word formed at every step should be a valid dictionary word. 

Eg: Provide minimum steps to go from 'cat' to 'dog' 
cat -> bat -> bet -> bot -> bog -> dog 
Ans: 5
*/
public class WordLadder {
	private String [] words = {
			"cat", "man", "bat", "bit", "cam", "hat", "bog", "pig", "dog", "hop", 
			"bot", "fat", "fit", "tin", "bet", "min", "lol",
			"new", "fat", "fog", "cog", "dog", "fag", "cag"
	};
	private HashSet<String> dict = new HashSet<String>();
	public WordLadder() {
		for (String str: words) {
			dict.add(str);
		}
	}
	
	public ArrayList<ArrayList<String>> findWordChains(String start, String end) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (start == null || end == null) {
			return result;
		}
		
		HashSet<String> visited = new HashSet<String>();
		Queue<WNode> Q = new LinkedList<WNode>();
		Q.add(new WNode(start, null));
		
		while (!Q.isEmpty()) {
			WNode curr = Q.remove();
			
			if (hasChain(curr.word, end)) {
				ArrayList<String> buff = new ArrayList<String>();
				buff.add(end);
				WNode ptr = curr;
				while (ptr != null) {
					buff.add(ptr.word);
					ptr = ptr.prev;
				}
				Collections.reverse(buff);
				result.add(buff);
			}
			
			for (String str: dict) {
				if (!visited.contains(str) && hasChain(curr.word, str)) {
					visited.add(str);
					Q.add(new WNode(str, curr));
				}
			}
		}
		
		return result;
	}
	
	private boolean hasChain(String first, String second) {
		int n = first.length();
		int m = second.length();
		int count = 0;
		
		int i = 0;
		int j = 0;
		
		while (i < n && j < m) {
			if (first.charAt(i) != second.charAt(j)) {
				++count;
			}
			if (count > 1) {
				return false;
			}
			++i;
			++j;
		}
		if (i < n) {
			count += (n-1 - i);
		}
		if (j < m) {
			count += (m-1 - j);
		}
		return count == 1;
	}
	
	public static void main(String[] args) {
		WordLadder wl = new WordLadder();
		String start = "cat";
		String end = "dog";
		ArrayList<ArrayList<String>> result = wl.findWordChains(start, end);
		for (ArrayList<String> list: result) {
			for (String str: list) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
}

class WNode {
	String word;
	WNode prev;
	
	public WNode(String word, WNode prev) {
		this.word = word;
		this.prev = prev;
	}
}
