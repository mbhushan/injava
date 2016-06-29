package rec_FancyShuffle;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an input with duplicate characters generate a shuffle which does not have 
 * two duplicate characters together
 * 
 * Do regular permutation with repetition with additional constraint of keeping
 * duplicates away from each other.
 *
*/

public class FancyShuffle {

		public static void main(String[] args) {
			FancyShuffle fs = new FancyShuffle();
			String st = "AAABB";
			String str = "bbcdaaaaa";
			str = "AACC";
			//fs.fancyShuffle(st.toCharArray());
			fs.fancyShuffle(str.toCharArray());
		}
		
		public void fancyShuffle(char [] input) {
			Arrays.sort(input);
			HashSet<String> hset = new HashSet<String>();
			fancyShuffle(input, 0, hset);
			
			for (String st: hset) {
				System.out.println(st);
			}
		}
		
		private void fancyShuffle(char [] input, int index, HashSet<String> hset) {
			if (index == input.length) {
				hset.add(Arrays.toString(input));
				return;
			}
		
			for (int i=index; i<input.length; i++) {
				if (i != index && input[i] == input[index]) {
					continue;
				}
				if (index > 0 && input[i] == input[index-1]) {
					continue;
				}
				char ch = input[i];
				input[i] = input[index];
				input[index] = ch;
				fancyShuffle(input, index+1, hset);
				ch = input[i];
				input[i] = input[index];
				input[index] = ch;
			}
		}
}
