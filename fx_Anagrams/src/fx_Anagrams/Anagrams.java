package fx_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
Write a function that takes a list of words as input, and returns a list of those words bucketized by anagrams with duplicates removed.
Example:
Input: ["star", "rats", "car", "arc", "arts", "rats", "bar"]
Output: [["star", "rats", "arts"], ["car", "arc"], ["bar"]]
*/
public class Anagrams {

	public static void main(String[] args) {
		String [] words = { "star", "rats", "car", "arc", "arts", "rats", "bar", "rats", "bar"};
		Anagrams A = new Anagrams();
		ArrayList<HashSet<String>> result = A.getAnagrams(words);
		for (HashSet<String> set: result) {
			for (String str: set) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<HashSet<String>> getAnagrams(String [] words) {
		ArrayList<HashSet<String>> result = new ArrayList<HashSet<String>>();
		if (words == null || words.length <= 1) {
			return result;
		}
		
		int len = words.length;
		HashMap<String, HashSet<String>> hmap = new HashMap<String, HashSet<String>>();
		
		for (int i=0; i<len; i++) {
			String str = words[i];
			char [] chArr = str.toCharArray();
			Arrays.sort(chArr);
			String hash = new String(chArr);
			HashSet<String> hset = new HashSet<String>();
			if (hmap.containsKey(hash)) {
				hset = hmap.get(hash);
			}
			hset.add(str);
			hmap.put(hash, hset);
		}
		
		for (String key: hmap.keySet()) {
			result.add(hmap.get(key));
		}
		return result;
	}
}
