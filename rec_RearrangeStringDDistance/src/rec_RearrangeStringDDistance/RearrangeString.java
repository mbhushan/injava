package rec_RearrangeStringDDistance;

import java.util.Arrays;
import java.util.HashSet;

/*
Rearrange a string so that all same characters become d distance away
Given a string and a positive integer d. Some characters may be repeated in the given string. 
Rearrange characters of the given string such that the same characters become d distance away from each other. 
Note that there can be many possible rearrangements, the output should be one of the possible rearrangements. 
If no such arrangement is possible, that should also be reported.
Expected time complexity is O(n) where n is length of input string.

Examples:
Input:  "abb", d = 2
Output: "bab"

Input:  "aacbbc", d = 3
Output: "abcabc"

Input: "geeksforgeeks", d = 3
Output: egkegkesfesor

Input:  "aaa",  d = 2
Output: Cannot be rearranged
*/

public class RearrangeString {

	public static void main(String[] args) {
		RearrangeString rs = new RearrangeString();
		
		String [] str = {"abb", "abcabc", "aaa"};
		int [] d = {2, 3, 2};
		
		for (int i=0; i<str.length; i++) {
			rs.rearrange(str[i].toCharArray(), d[i]);
		}
		
	}
	
	
	public void rearrange(char [] input, int d) {
		Arrays.sort(input);
		HashSet<String> hset = new HashSet<String>();
		rearrange(input, 0, hset, d);
		
		if (hset.isEmpty()) {
			System.out.println("no rearrangement possible!");
		} else {
			for (String st: hset) {
				System.out.println(st);
			}
		}
	}
	

	private void rearrange(char [] input, int index, HashSet<String> hset, int d) {
		if (index == input.length) {
			hset.add(Arrays.toString(input));
			return;
		}
	
		for (int i=index; i<input.length; i++) {
			if (i != index && input[i] == input[index]) {
				continue;
			}
			boolean flag = false;
			for (int k=1; k<d; k++) {
				if (index-k >= 0 && input[i] == input[index-k]) {
					flag = true;
				}
			}
			if (flag) {
				continue;
			}
			char ch = input[i];
			input[i] = input[index];
			input[index] = ch;
			rearrange(input, index+1, hset, d);
			ch = input[i];
			input[i] = input[index];
			input[index] = ch;
		}
	}
}
