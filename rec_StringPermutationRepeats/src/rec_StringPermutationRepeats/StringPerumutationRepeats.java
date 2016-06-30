package rec_StringPermutationRepeats;

import java.util.Arrays;

/*
Print all permutations with repetition of characters
Given a string of length n, print all permutation of the given string. Repetition of characters is allowed. Print these permutations in lexicographically sorted order 
Examples:

Input: AB
Ouput: All permutations of AB with repetition are:
      AA
      AB
      BA
      BB

Input: ABC
Output: All permutations of ABC with repetition are:
       AAA
       AAB
       AAC
       ABA
       ...
       ...
       CCB
       CCC
*/
public class StringPerumutationRepeats {

	public static void main(String[] args) {
		StringPerumutationRepeats spr = new StringPerumutationRepeats();
		String st = "ABC";
		
		spr.permute(st.toCharArray());
	}
	
	public void permute(char [] input) {
		permute(input, 0, new char[input.length]);
	}
	
	private void permute(char [] input, int index, char [] data) {
		if (index == input.length) {
			System.out.println(Arrays.toString(data));
			return;
		}
		
		for (int i=0; i<input.length; i++) {
			data[index] = input[i];
			permute(input, index+1, data);
		}
	}
	
}
