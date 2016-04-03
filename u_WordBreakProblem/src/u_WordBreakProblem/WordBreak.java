package u_WordBreakProblem;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	private static Set<String> dict = new HashSet<String>();

	public static void main(String[] args) {
		String[] S = { "i", "like", "had", "play", "to", "sam", "sung",
				"samsung", "mobile", "ice", "cream", "icecream", "man", "go",
				"mango" };
		for (int i = 0; i < S.length; i++) {
			dict.add(S[i]);
		}

		String[] texts = { "ilikesamsung", "iiiiiiii", "ilikelikeimangoiii",
				"samsungandmango", "samsungandmangok", "Ihadliketoplay" };

		WordBreak WB = new WordBreak();
		for (int i = 0; i < texts.length; i++) {
			System.out.println("recursion: " + WB.breakWord(texts[i].toLowerCase()
					.toCharArray(), 0));
			System.out.println("DP: " + WB.breakWordDP(texts[i].toLowerCase()));
		}
	}

	public String breakWordDP(String word) {
		int wlen = word.length();
		int[][] T = new int[wlen][wlen];

		for (int i = 0; i < wlen; i++) {
			for (int j = 0; j < wlen; j++) {
				T[i][j] = -1;
			}
		}

		// fill up the matrix in bottom up manner
		for (int l = 1; l <= wlen; l++) {
			for (int i = 0; i < wlen - l + 1; i++) {
				int j = i + l - 1;
				String str = word.substring(i, j + 1);
				// if string between i to j is in dictionary T[i][j] is true
				if (dict.contains(str)) {
					T[i][j] = i;
					continue;
				}
				// find a k between i+1 to j such that T[i][k-1] && T[k][j] are
				// both true
				for (int k = i + 1; k <= j; k++) {
					if (T[i][k - 1] != -1 && T[k][j] != -1) {
						T[i][j] = k;
						break;
					}
				}
			}
		}

		if (T[0][word.length() - 1] == -1) {
			return null;
		}

		// create space separate word from string is possible
		StringBuffer buffer = new StringBuffer();
		int i = 0;
		int j = word.length() - 1;
		while (i <= j) {
			int k = T[i][j];
			if (i == k) {
				buffer.append(word.substring(i, j + 1));
				break;
			}
			buffer.append(word.substring(i, k) + " ");
			i = k;
		}

		return buffer.toString();
	}

	/*
	 * recursive version of the word break problem
	 */
	public String breakWord(char[] str, int index) {
		StringBuffer sb = new StringBuffer();
		for (int i = index; i < str.length; i++) {
			sb.append(str[i]);
			if (dict.contains(sb.toString())) {
				String result = breakWord(str, i + 1);
				if (result != null) {
					sb.append(" " + result);
					return sb.toString();
				}
			}
		}

		if (dict.contains(sb.toString())) {
			return sb.toString();
		}

		return null;
	}
}
