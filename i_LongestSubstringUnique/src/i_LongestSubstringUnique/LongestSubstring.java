package i_LongestSubstringUnique;

public class LongestSubstring {
	
	public static void main(String[] args) {
		String [] strs = {"abcabcbb", "bbbbb"};
		for (int i=0; i<strs.length; i++) {
			System.out.println("longest substring unique: " + lengthOfLongestSubstring(strs[i]));
		}
	}

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int i = 0, j = 0;
		int maxLen = 0;
		boolean[] exist = new boolean[256];
		while (j < n) {
			if (exist[s.charAt(j)]) {
				maxLen = Math.max(maxLen, j - i);
				while (s.charAt(i) != s.charAt(j)) {
					exist[s.charAt(i)] = false;
					i++;
				}
				i++;
				j++;
			} else {
				exist[s.charAt(j)] = true;
				j++;
			}
		}
		maxLen = Math.max(maxLen, n - i);
		return maxLen;
	}
}
