package i_WordBreakAdv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class WordBreak {

	public static void main(String[] args) {
		//String []  S = {"cat", "cats", "and", "sand", "dog"};
		String [] S = {"aabbbaaa", "aaba", "a", "b", "a", "babbbabb", "baaaab"};
		String s = "catsanddog";
		s = "aaabaaaaab";
		ArrayList<String> dict = new ArrayList<String>();
		Collections.addAll(dict, S);
		
		ArrayList<String> words = wordBreak(s, dict);
		for (String st: words) {
			System.out.println(st);
		}
	}
	
	public static ArrayList<String> wordBreak(String s, ArrayList<String> dict) {
		//create an array of ArrayList<String>
	    ArrayList<String> dp[] = new ArrayList[s.length()+1];
	    dp[0] = new ArrayList<String>();
	 
	    for(int i=0; i<s.length(); i++){
	        if( dp[i] == null ) 
	            continue; 
	 
	        for(String word:dict){
	            int len = word.length();
	            int end = i+len;
	            if(end > s.length()) 
	                continue;
	 
	            if(s.substring(i,end).equals(word)){
	                if(dp[end] == null){
	                    dp[end] = new ArrayList<String>();
	                }
	                dp[end].add(word);
	            }
	        }
	    }
	 
	    HashSet<String> result = new HashSet<String>();
	    ArrayList<String> ans = new ArrayList<String>();
	    if(dp[s.length()] == null) 
	        return ans; 
	 
	    ArrayList<String> temp = new ArrayList<String>();
	    dfs(dp, s.length(), result, temp);
	    
	    for (String st: result) {
	    	ans.add(st);
	    }
	    Collections.sort(ans);
	 
	    return ans;
	}
	
	public static void dfs(ArrayList<String> dp[],int end, HashSet<String> result, ArrayList<String> tmp){
	    if(end <= 0){
	        String path = tmp.get(tmp.size()-1);
	        for(int i=tmp.size()-2; i>=0; i--){
	            path += " " + tmp.get(i) ;
	        }
	 
	        result.add(path);
	        return;
	    }
	 
	    for(String str : dp[end]){
	        tmp.add(str);
	        dfs(dp, end-str.length(), result, tmp);
	        tmp.remove(tmp.size()-1);
	    }
	}
}
