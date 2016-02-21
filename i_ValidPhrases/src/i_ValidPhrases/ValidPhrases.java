package i_ValidPhrases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidPhrases {

	private static Set<String> dictionary = new HashSet<String>();
	private static List<String>[] phrases;

	public static void main(String[] args) {
		String s = "myinterviewtrainer";
		s = "aaaabbbbababbaababbbabbabaaabbaaaabbababbaabababaabbbababaaababbbbbaaababababbbbbaaaabbabbabaabbababbaaaaabbaababababbbaaaabaaabaabaababbabaaabaaababababbaabbbbbaabbabbaaaaabbabbbabbbbaaaaabababbaababbabbbabbbababaabaababbbaaaaababababbaabaabaabbbbaaabbbbbbababbabbabaabbaababbbbbbabaababbbbababbabbbbbbabbbbbbaabbbbbbabaabbabaabbbaaaababaababbbabaabbbbabbbbbbbababbaabbbaaabaabaabaabbbab";
		//String [] strs = {"trainer", "my", "interview"};
         String[] strs = { "bbabaaaaba", "abbaa", "bbabbaaba", "bbaabbab", "ab",
				"b", "abaaaababa", "aa", "babaa", "aaa", "baa", "ab",
				"baaabbbba", "aaaba", "a", "bbaababaab", "baaaaaaa", "aaab",
				"bbabbbbaaa", "ab", "aaa", "bbb", "a", "bab", "aaaaaa", "aa",
				"b", "ababaabbb", "bbb", "babbbbba", "bbabb", "ab", "a",
				"baabaabbb", "aaabab", "aba", "a", "babba", "aaaababbbb", "b",
				"baab", "baabbbb", "babbb", "ababaa", "babbaa", "abaaa",
				"babababab", "bab", "aa", "abbaa", "abb", "bbbaaaaba",
				"bbbabababb", "aaaa", "ba", "bbaabbbaab", "bababb", "bbbb",
				"baaabbaab", "bababbbaaa", "bbaab", "ab", "bbbaaa", "aaaa",
				"aab", "baabaabaa", "bb", "ba", "bbbb", "abbaababab",
				"baaaaaa", "baaabbbb", "baab" };
		ArrayList<String> b = new ArrayList<String>();
		Collections.addAll(b, strs);
		int res = wordBreak(s, b);
		System.out.println("ans: " + res);
	}

	public static int wordBreak(String a, ArrayList<String> b) {
		int N = b.size();
		for (int i = 0; i < N; i++) {
			dictionary.add(b.get(i));
		}

		if (wordBreakDP(a)) {
			return 1;
		}
		return 0;

	}
	
	public static boolean wordBreakDP(String s) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state
 
        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i]) 
                continue;
 
            for(String a: dictionary){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;
 
                if(t[end]) continue;
 
                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }
 
        return t[s.length()];
    }

	static boolean wordBreakHelper(String str) {
		int size = str.length();

		// Base case
		if (size == 0)
			return true;

		// Try all prefixes of lengths from 1 to size
		for (int i = 1; i <= size; i++) {
			// The parameter for dictionaryContains is str.substr(0, i)
			// str.substr(0, i) which is prefix (of input string) of
			// length 'i'. We first check whether current prefix is in
			// dictionary. Then we recursively check for remaining string
			// str.substr(i, size-i) which is suffix of length size-i
			if (dictionary.contains(str.substring(0, i))
					&&  wordBreakHelper(str.substring(i, size)))
				return true;
		}

		// If we have tried all prefixes and none of them worked
		return false;
	}

	public static int wordBreak1(String a, ArrayList<String> b) {
		int N = b.size();
		for (int i = 0; i < N; i++) {
			dictionary.add(b.get(i));
		}

		List<String> ans = putSpaces(a);
		if (ans.isEmpty()) {
			return 0;
		}
		for (String s : ans) {
			System.out.println(s + " ");
		}
		System.out.println();
		return 1;
	}

	public static List<String> putSpaces(String str) {
		if (null == str) {
			return null;
		}
		int len = str.length();
		phrases = new List[len];
		return putSpaces(str, 0);
	}

	private static List<String> putSpaces(String str, int index) {
		if (phrases[index] != null) {
			return phrases[index];
		}
		List<String> result = new ArrayList<String>();
		int len = str.length();
		for (int i = 0; i < len; i++) {
			String word = str.substring(0, i + 1);
			if (dictionary.contains(word)) {
				if (word.equals(str)) {
					result.add(word);
				} else {
					List<String> next = putSpaces(str.substring(i + 1), index
							+ i + 1);
					for (String st : next) {
						result.add(word + " " + st);
					}
				}
			}
		}
		return (phrases[index] = result);
	}
}
