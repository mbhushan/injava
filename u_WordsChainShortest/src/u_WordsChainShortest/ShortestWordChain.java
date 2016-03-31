package u_WordsChainShortest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	String word;
	int dist;
	
	Node() {}
	Node (String w, int d) {
		word = w;
		dist = d;
	}
}
public class ShortestWordChain {

	private static HashSet<String> dict = new HashSet<String>();
	
	public static void main(String[] args) {
		String [] S = {"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"};
		
		for (int i=0; i<S.length; i++) {
			dict.add(S[i]);
		}
		String start = "TOON";
		String end = "PLEA";
		System.out.println("shortest word chain: " + shortestWordChain(start, end));
	}
	
	public static int shortestWordChain(String start, String end) {
		Queue<Node> Q = new LinkedList<Node>();
		Node node = new Node(start, 1);
		Q.add(node);
		
		while (!Q.isEmpty()) {
			Node curr = Q.remove();
			ArrayList<String> remList = new ArrayList<String>();
			for (String word: dict) {
				if (isAdjacent(curr.word, word)) {
					Node newNode = new Node(word, curr.dist + 1);
					if (word.equals(end)) {
						return newNode.dist;
					}
					remList.add(word);
					Q.add(newNode);
				}
			}
			for (String s: remList) {
				dict.remove(s);
			}
		}
		return 0;
	}
	
	private static boolean isAdjacent(String first, String second) {
		int flen = first.length();
		int count = 0;
		for (int i=0; i<flen ;i++) {
			if (first.charAt(i) != second.charAt(i)) {
				++count;
			}
			if (count > 1) {
				return false;
			}
		}
		return (count == 1);
	}
}
