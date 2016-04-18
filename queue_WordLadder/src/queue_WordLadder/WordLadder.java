package queue_WordLadder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class WNode {
	String word;
	WNode prev;
	
	public WNode (String word, WNode prev) {
		this.word = word;
		this.prev = prev;
	}
}

public class WordLadder {
	private static String [] S = {"hot","dot","dog","lot","log"};
	private static HashSet<String> dict = new HashSet<String>();
	
	public WordLadder() {
		Collections.addAll(dict, S);
	}
	
	public static void main(String [] args) {
		WordLadder WL = new WordLadder();
		String start = "hit";
		String end = "cog";
		ArrayList<ArrayList<String>> result = WL.findLadders(start, end);
		for (ArrayList<String> list: result) {
			for (String st: list) {
				System.out.print(st + " ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<String>> findLadders(String start, String end) {
		ArrayList<ArrayList<String>>  result = new ArrayList<ArrayList<String>> ();
		Queue<WNode> Q = new LinkedList<WNode>();
		WNode node = new WNode(start, null);
		Q.add(node);
		
		HashSet<String> visited = new HashSet<String>();
		visited.add(start);
		
		while (!Q.isEmpty()) {
			WNode curr = Q.remove();
			
			if (hasChain(curr.word, end)) {
				ArrayList<String> wlist = new ArrayList<String>();
				wlist.add(end);
				WNode tmp = curr;
				while ( tmp != null) {
					wlist.add(tmp.word);
					tmp = tmp.prev; 
				}
				Collections.reverse(wlist);
				result.add(wlist);
			}
			
			for (String str: dict) {
				if (visited.contains(str)) 
					continue;
				if (hasChain(curr.word, str)) {
					visited.add(str);
					Q.add(new WNode(str, curr));
				}
			}
			
		}
		
		return result;
	}
	
	private boolean hasChain(String first, String second) {
		if (first.length() != second.length()) {
			return false;
		}
		int len = first.length();
		int count = 0;
		for (int i=0; i<len; i++) {
			if (first.charAt(i) != second.charAt(i)) {
				++count;
			}
			if (count > 1) {
				return false;
			}
		}
		return count == 1;
	}
}
