package u_LongestPrefixMatching;

import java.util.HashMap;

/*
Longest prefix matching – A Trie based solution in Java
Given a dictionary of words and an input string, find the longest prefix of the string which is also a word in dictionary.
Examples:

Let the dictionary contains the following words:
{are, area, base, cat, cater, children, basement}
Below are some input/output examples:
--------------------------------------
Input String            Output
--------------------------------------
caterer                 cater
basemexy                base
child                   < Empty >
Solution
We build a Trie of all dictionary words. Once the Trie is built, traverse through it using characters of input string. 
If prefix matches a dictionary word, store current length and look for a longer match. Finally, return the longest match.
*/
class TrieNode {
	private char value;
	private HashMap<Character, TrieNode> children;
	private boolean isLeafNode;
	
	public TrieNode(char ch) {
		value = ch;
		children = new HashMap<Character, TrieNode>();
		isLeafNode = false;
	}
	
	public HashMap<Character, TrieNode> getChildren() { return children; }
	public char getValue() { return value; }
	public void setIsLeafNode(boolean val) { isLeafNode = val; }
	public boolean isLeafNode() { return isLeafNode; }
}

public class Trie {
	
	public static void main(String [] args) {
		Trie dict = new Trie();
        dict.insert("are");
        dict.insert("area");
        dict.insert("base");
        dict.insert("cat");
        dict.insert("cater");
        dict.insert("basement");
 
        String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));              
 
        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));                      
 
        input = "are";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));              
 
        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));              
 
        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));                      
 
        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));
	}

	private TrieNode root;
    public Trie() {
    	root = new TrieNode((char)0);
	}
    
    //method to find the longest prefix match.
    public String getMatchingPrefix(String input) {
    	StringBuffer sb = new StringBuffer();
    	int len = input.length();
    	
    	//init reference to traverse through the trie.
    	TrieNode crawl = root;
    	int prevMatch = 0;
    	
    	//lets traverse through the trie now :)
    	for (int level=0; level<len; level++) {
    		char ch = input.charAt(level);
    		HashMap<Character, TrieNode> child = crawl.getChildren();
    		if (child.containsKey(ch)) {
    			sb.append(ch);
    			crawl = child.get(ch);
    			if (crawl.isLeafNode()) {
    				prevMatch = level+1;
    			}
    		} else {
    			break;
    		}
    	}
    	if (!crawl.isLeafNode()) {
    		return (sb.toString()).substring(0, prevMatch);
    	}
    	
    	return sb.toString();
    }
    
    //insert a string into Trie.
    public void insert(String word) {
    	int len = word.length();
    	TrieNode crawl = root;
    	
    	//lets see through all the characters of the give word
    	for (int level=0; level<len; level++) {
    		HashMap<Character, TrieNode> child = crawl.getChildren();
    		char ch = word.charAt(level);
    		//if there is already the child for the current char of the word.
    		if (child.containsKey(ch)) {
    			crawl = child.get(ch);
    		} else { //create a new child
    			TrieNode tnode = new TrieNode(ch);
    			child.put(ch, tnode);
    			crawl = tnode;
    		}
    	}
    	//setting the bool value to true for last char.
    	crawl.setIsLeafNode(true);
    }
	
}
