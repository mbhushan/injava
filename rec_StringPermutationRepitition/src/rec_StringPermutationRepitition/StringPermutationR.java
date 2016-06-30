package rec_StringPermutationRepitition;

import java.util.Arrays;

public class StringPermutationR {

	public static void main(String[] args) {
		StringPermutationR sp = new StringPermutationR();
		
		String st = "aab";
		sp.permuteWithRep(st.toCharArray());
	}
	
	public void permuteWithRep(char [] input) {
		permuteWithRep(input, 0);
	}
	
	private void permuteWithRep(char [] input, int index) {
		if (index == input.length) {
			System.out.println(Arrays.toString(input));
		}
		
		for (int i=index; i<input.length; i++) {
			if (i!=index && (input[i] == input[index])) {
				continue;
			}
			
			char ch = input[i];
			input[i] = input[index];
			input[index] = ch;
			permuteWithRep(input, index+1);
			ch = input[i];
			input[i] = input[index];
			input[index] = ch;
		}
	}
}
