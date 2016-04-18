package str_IsomorphicStrings;

import java.util.HashMap;

/*
Given two strings s and t, determine if they are isomorphic. 
Two strings are isomorphic if the characters in s can be replaced to get t.

For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
 */
public class Isomorphic {
	
	public static void main(String [] args) {
		Isomorphic iso = new Isomorphic();
		String [] A = {"egg", "add"};
		String [] B = {"foo", "bar"};
		
		for (int i=0; i<A.length; i++) {
			System.out.println(A[i] +" and " + B[i] +  " are isomorphic: " + iso.isIsomorphic(A[i], B[i]));
		}
	}

	public boolean isIsomorphic (String A, String B) {
		if (A == null || B == null) {
			return false;
		}
		if (A.length() != B.length()) {
			return false;
		}
		if (A.length() == 0 && B.length() == 0) {
			return true;
		}
		HashMap<Character, Character> hmap = new HashMap<Character, Character>();
		int len = A.length();
		for (int i=0; i<len; i++) {
			char a = A.charAt(i);
			char b = B.charAt(i);
			if (a == b) {
				continue;
			} else if (hmap.containsKey(a)) {
				char val = hmap.get(a);
				if (val != b) {
					return false;
				}
			}
			hmap.put(a, b);
		}
		return true;
	}
	
}
