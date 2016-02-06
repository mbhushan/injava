package i_TriePrefix;

import java.util.ArrayList;
import java.util.Arrays;

public class TriePrefix {
    
    public static final int R = 256;
    private static Node root;
     
    private static class Node{
        private int count;
        private boolean isEnd;
        private Node next[] = new Node[R];
         
        public Node(){
            count = 0;
            isEnd = false;
        }
 
        public Node(int count, boolean isEnd){
            this.count = count;
            this.isEnd = isEnd;
        }
    }
     
    public static void insert(String str){
        if(root == null) root = new Node();
        Node curr = root;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(curr.next[c] == null){
                curr.next[c] = new Node(1, false);
            }else{
                curr.next[c].count++;
            }
            curr = curr.next[c];
        }
        curr.isEnd = true;
    }
     
    public static String shortestPrefix(String str){
        Node curr = root;
        int len = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            curr = curr.next[c];
            len++;
            if(curr.count == 1) break;
        }
        return str.substring(0, len);
    }
    
    public static ArrayList<String> prefix(ArrayList<String> strings) {
    	for(String word : strings){
            insert(word);
        }
    	int size = strings.size();
        String[] res = new String[size];
        for(int i = 0; i < size; i++){
            res[i] = shortestPrefix(strings.get(i));
            //System.out.println(res[i]);
        }
        ArrayList<String> prefixes = new ArrayList<String>( Arrays.asList(res));
        return prefixes;
    }
    
    public static void main(String[] args) {
		String[] strs = {"zebra", "dog", "duck", "dot"};
		
		ArrayList<String> strings = new ArrayList<String>();
		for (int i=0; i<strs.length; i++) {
			strings.add(strs[i]);
		}
		
		ArrayList<String> result = prefix(strings);
		for (String st: result) {
			System.out.print(st + " ");
		}
		System.out.println();
			
	}
     
//    public static void main(String[] args){
//        TriePrefix trie = new TriePrefix();
//        String[] words = {"by", "sea", "sells", "she", "shells", "shore", "the"};
//        String[] words1 = {"zebra", "dog", "duck", "dot"};
//for(String word : words1){
//            trie.insert(word);
//        }
//        String[] res = new String[words1.length];
//        for(int i = 0; i < words1.length; i++){
//            res[i] = trie.shortestPrefix(words1[i]);
//            System.out.println(res[i]);
//        }
//    }
 
}