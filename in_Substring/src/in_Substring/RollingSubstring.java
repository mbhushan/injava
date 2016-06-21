package in_Substring;

import java.util.HashMap;

/*
Given string say ABCGRETCABCG and substring length let us take length as 3, 
find the count of possible substrings, for example in above string ABC => 2 and BCG => 2 , 
where CGR and other 3 word length substrings has a count of 1.
*/
public class RollingSubstring {
	public static void main(String[] args) {
		RollingSubstring rs = new RollingSubstring();
		String input = "ABCGRETCABCG";
		int k = 3;
		rs.rollingSubstring(input, k);
		
	}
	
	public void rollingSubstring(String input, int k) {
		if (input == null || input.length() < k) {
			return;
		}
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		int len = input.length();
		for (int i=0; i+k <= len; i++) {
			String substr = input.substring(i, i+k);
			int freq = 1;
			if (hmap.containsKey(substr)) {
				freq = hmap.get(substr);
				++freq;
			}
			hmap.put(substr, freq);
		}
		
		for (String key: hmap.keySet()) {
			System.out.println(key + ": " + hmap.get(key));
		}
	}
}
