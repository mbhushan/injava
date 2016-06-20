package trie_InsertSearch;

import java.util.HashMap;

public class TrieOperations {
	
	public static void main(String[] args) {
		TrieOperations to = new TrieOperations();
		String [] words = {"abcd", "abc", "abgl", "mani", "manib", "manibhushan" };
		for (int i=0; i<words.length; i++) {
			to.insert(words[i]);
		}
		
		String [] wordSearches = {"manib", "man", "abcd", "abg", "manibhushan"};
		for (int i=0; i<wordSearches.length; i++) {
			System.out.println("word search for - " + wordSearches[i] + ": " + to.search(wordSearches[i], false));
			System.out.println("prefix search for - " + wordSearches[i] + ": " + to.search(wordSearches[i], true));
		}
		
		System.out.println();
		String st = "manishreyansh";
		System.out.println("finding longest prefix for word - " + st + ": " + to.longestPrefix(st));
	}
	
	private TrieNode root;
	
	public TrieOperations() {
		root = new TrieNode((char)-1);
	}
	
	//get the longest prefix match for the given word
	public String longestPrefix(String input) {
		if (input == null || input.length() < 1) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		int len = input.length();
		TrieNode curr = root;
		
		for (int i=0; i<len; i++) {
			char ch = input.charAt(i);
			HashMap<Character, TrieNode> child = curr.getChildren();
			
			if (child.containsKey(ch)) {
				sb.append(ch);
				curr = child.get(ch);
			} else {
				break;
			}
		}
		return sb.toString();
	}
	
	public boolean search(String input, boolean isPrefix) {
		if (input == null || input.length() < 1) {
			return false;
		}
		
		int len = input.length();
		TrieNode curr = root;
		
		int index = 0;
		while (index < len) {
			char ch = input.charAt(index);
			HashMap<Character, TrieNode> child = curr.getChildren();
			if (!child.containsKey(ch)) {
				return false;
			}
			curr = child.get(ch);
			++index;
		}
		if (!isPrefix && !curr.isLeaf()) {
			return false;
		}
		return true;
	}
	
	public void insert(String word) {
		if (word == null || word.length() < 1) {
			return;
		}
		int len = word.length();
		TrieNode curr = root;
		
		for (int i=0; i<len; i++) {
			char ch = word.charAt(i);
			HashMap<Character, TrieNode> child = curr.getChildren();
			if (child.containsKey(ch)) {
				curr = child.get(ch);
				
			} else {
				TrieNode tnode = new TrieNode(ch);
				child.put(ch, tnode);
				curr = tnode;
			}
		}
		curr.setLeafFlag(true);
	}
}

class TrieNode {
	private char data;
	private HashMap<Character, TrieNode> children;
	private boolean isLeaf;
	
	public TrieNode(char ch) {
		this.data = ch;
		children = new HashMap<Character, TrieNode>();
		isLeaf = false;
	}
	
	public HashMap<Character, TrieNode> getChildren() { return this.children; }
	public boolean isLeaf() { return this.isLeaf; }
	public void setLeafFlag(boolean flag) { this.isLeaf = flag; }
}
