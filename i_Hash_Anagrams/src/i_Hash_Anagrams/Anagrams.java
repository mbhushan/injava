package i_Hash_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	public static void main(String[] args) {
		//String[] S = { "cat", "dog", "god", "tca" };
		String [] S = {"abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"};
		List<String> A = new ArrayList<String>();
		for (int i = 0; i < S.length; i++) {
			A.add(S[i]);
		}
		ArrayList<ArrayList<Integer>> R = anagrams(A);

		for (int i = 0; i < R.size(); i++) {
			for (int j = 0; j < R.get(i).size(); j++) {
				System.out.print(R.get(i).get(j) + ", ");
			}
			System.out.println();
		}
	}

	public static ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
		if (null == a) {
			return null;
		}
		int size = a.size();
		HashMap<String, ArrayList<Integer>> hmap = new HashMap<String, ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < size; i++) {
			String word = a.get(i).toLowerCase();
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			String newWord = new String(chars);
			ArrayList<Integer> values = new ArrayList<Integer>();

			if (hmap.containsKey(newWord)) {
				values = hmap.get(newWord);
			}
			values.add(i + 1);
			hmap.put(newWord, values);
			// System.out.println("hmap size: " + hmap.size());
		}

		for (Map.Entry<String, ArrayList<Integer>> entry : hmap.entrySet()) {
			ArrayList<Integer> R = entry.getValue();
////			if (R.size() < 2) {
////				continue;
//			}
			result.add(R);
			// for (int j=0; j<R.size(); j++){
			// System.out.print(R.get(j) + ", ");
			// }
			// System.out.println();

		}
		return result;
	}
}
