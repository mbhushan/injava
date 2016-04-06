package u_AllPalindromicSubstrings;

import java.util.HashSet;

public class PalindromicSubstrings {
	
	public static void main(String [] args) {
		PalindromicSubstrings PS = new PalindromicSubstrings();
		String input = "abaaa";
		HashSet<String> hset = PS.getAllPalindromes(input);
		System.out.println("printing all the palindromes:");
		for (String st: hset) {
			System.out.println(st);
		}
	}
	
	public HashSet<String> getAllPalindromes(String input) {
		HashSet<String> hset = new HashSet<String>();
		int len = input.length();
		for (int i=0; i<len-1; i++) {
			oddLengthPalidrome(input, i, hset);
			if (input.charAt(i) == input.charAt(i+1)) {
				evenLengthPalidrome(input, i, i+1, hset);
			}
		}
		return hset;
	}
	
	private void evenLengthPalidrome(String input, int firstCenter,int secondCenter, HashSet<String> hset) {
		int i = firstCenter;
		int j = secondCenter;
		int len = input.length();
		
		while (i>=0 && j<len) {
			if (input.charAt(i) == input.charAt(j)) {
				String palindrome = input.substring(i, j+1);
				if (!hset.contains(palindrome)) {
					hset.add(palindrome);
				}
				--i;
				++j;
			} else {
				break;
			}
		}
		return;
	}

	private void oddLengthPalidrome(String input, int center, HashSet<String> hset) {
		int i = center;
		int j = center;
		int len = input.length();
		
		while (i>=0 && j<len) {
			if (input.charAt(i) == input.charAt(j)) {
				String palindrome = input.substring(i, j+1);
				if (!hset.contains(palindrome)) {
					hset.add(palindrome);
				}
				--i;
                ++j;
			} else {
				break;
			}
			
		}
		return ;
	}
}
