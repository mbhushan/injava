package i_WordLadder2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
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
		ArrayList<ArrayList<String>> result = findLadders(beginWord, endWord, dictV);
		for (ArrayList<String> r: result) {
			System.out.println(r);
		}
	}
	

	static class WordNode{
	    String word;
	    int numSteps;
	    WordNode pre;
	    public WordNode(String word, int numSteps, WordNode pre){
	        this.word = word;
	        this.numSteps = numSteps;
	        this.pre = pre;
	    }
	     public WordNode(String word, int numSteps){
	        this.word = word;
	        this.numSteps = numSteps;        
	    }
	}

	public static ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dictV) {
		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> current = new ArrayList<String>();
        Queue<WordNode> queue  = new LinkedList<WordNode>();
        queue.offer(new WordNode(start, 1, null));                
        
        Set<String> dict = new HashSet<String>(dictV);
        dict.add(end);
        int minStep  = 0;
        
        Set<String> visited = new HashSet<String>();
        Set<String> unvisited  = new HashSet<String>();
        unvisited.addAll(dict);
        
        int preNumSteps = 0;
        
        while(!queue.isEmpty()){   
            //System.out.println("Queue : " + queue);
            WordNode top = queue.poll();
            //System.out.println("For Word : " + top.word);
            String word = top.word;
            int currNumSteps = top.numSteps;
            
            if(word.equals(end)){
                if(minStep == 0)
                    minStep = top.numSteps;
                if(top.numSteps == minStep && minStep != 0){
                    ArrayList<String> t = new ArrayList<String>();
                    t.add(top.word);
                    while(top.pre != null){
                        t.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(t);
                    continue;
                }
            }
            
            if(preNumSteps < currNumSteps)
                unvisited.removeAll(visited);
            
            preNumSteps = currNumSteps;
            
            char[] arr = word.toCharArray();
            for(int i = 0; i < arr.length; i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char temp = arr[i];
                    if(arr[i] != c)
                        arr[i] = c;
                    String newWord = new String(arr);
                    if(unvisited.contains(newWord)){                       
                        queue.offer(new WordNode(newWord, top.numSteps + 1, top));
                        visited.add(newWord);
                    }
                    arr[i] = temp;
                }
            }
            
        }
        
        
        return result;
		
	}
	
	
}
