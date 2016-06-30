package rec_StringPermutation;

import java.util.Arrays;

/**
* Generate all permutations of string in lexicographically sorted order where repetitions of
* character is possible in string.
*/

public class StringPermutation {

	public static void main(String[] args) {
		StringPermutation sp = new StringPermutation();
		String st = "abc";
		sp.stringPerm(st.toCharArray());
	}
	
	public void stringPerm(char [] input) {
		stringPerm(input, 0);
	}
	
	private void stringPerm(char [] input, int index) {
		if (index == input.length) {
			System.out.println(Arrays.toString(input));
			return;
		}
		
		for (int i=index; i < input.length; i++) {
			char ch = input[index];
			input[index] = input[i];
			input[i] = ch;
			stringPerm(input, index+1);
			ch = input[index];
			input[index] = input[i];
			input[i] = ch;
		}
	}
}
