package i_SubstringWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWindow {
	
	public static void main(String[] args) {
		String S = "barfoothefoobarman";
		String [] X = {"foo", "bar"};
		List<String> L = new ArrayList<String>();
		for (int i=0; i<X.length; i++) {
			L.add(X[i]);
		}
		ArrayList<Integer> R = findSubstring(S, L);
		for (Integer r: R) {
			System.out.print(r + " ");
		}
		System.out.println();
	}

	public static ArrayList<Integer> findSubstring(String S, final List<String> L) {
		 ArrayList<Integer> ans = new ArrayList<Integer>();
	        if (L == null || L.size() == 0 || S == null || S.length() == 0) {
	            return ans;
	        }
	        int num = L.size();
	        int len = L.get(0).length();
	        if (num * len > S.length()) {
	            return ans;
	        }
	        // build a hashset, for simplifying the hashmap generation later on
	        HashMap<String, Integer> set = new HashMap<String, Integer>();
	        for (String str: L) {
	            if (set.containsKey(str)) {
	                set.put(str, set.get(str) + 1);
	            } else {
	                set.put(str, 1);
	            }
	        }
	        // starting from i, check Concatenation of All Words
	        for (int i = 0; i <= S.length() - (num * len); i++) {
	            // first build a HashMap from the set that we acquired before
	            HashMap<String, Integer> map = new HashMap<String, Integer>(set);
	            for (int j = 0; j < num; j++) {
	                String str = S.substring(i + j * len, i + (j + 1) * len);
	                if (!map.containsKey(str)) {
	                    break;
	                } else if (map.get(str) > 1) {
	                    map.put(str, map.get(str) - 1);
	                } else if (map.get(str) == 1) {
	                    map.remove(str);
	                }
	            }
	            if (map.isEmpty()) {
	                ans.add(i);
	            }
	        }
	        return ans;
	}
}
