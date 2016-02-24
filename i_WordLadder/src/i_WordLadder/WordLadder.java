package i_WordLadder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder {
	
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		String [] S = {"hot","dot","dog","lot","log"};
		ArrayList<String> dictV = new ArrayList<String>();
		for (int i=0; i<S.length; i++) {
			dictV.add(S[i]);
		}
		System.out.println("ladder length: " + ladderLength(beginWord, endWord, dictV));
	}
	
	static class WordNode{
	    String word;
	    int numSteps;
	 
	    public WordNode(String word, int numSteps){
	        this.word = word;
	        this.numSteps = numSteps;
	    }
	}

	public static int ladderLength(String beginWord, String endWord, ArrayList<String> dictV) {
		int size = dictV.size();
		Set<String> wordDict = new HashSet<String>();
		for (int i=0; i<size; i++) {
			wordDict.add(dictV.get(i));
		}
		
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));
 
        wordDict.add(endWord);
 
        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
 
            if(word.equals(endWord)){
                return top.numSteps;
            }
 
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
 
                    String newWord = new String(arr);
                    if(wordDict.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        wordDict.remove(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
        }
 
        return 0;
	}
}
