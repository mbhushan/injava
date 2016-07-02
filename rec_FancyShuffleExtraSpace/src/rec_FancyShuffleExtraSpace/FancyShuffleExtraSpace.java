package rec_FancyShuffleExtraSpace;

import java.util.Arrays;
import java.util.HashMap;


/* 
* Given an input with duplicate characters generate a shuffle which does not have 
* two duplicate characters together
* 
* Do regular permutation with repetition with additional constraint of keeping
* duplicates away from each other.
*
*/

public class FancyShuffleExtraSpace {

	public static void main(String[] args) {
		FancyShuffleExtraSpace fs = new FancyShuffleExtraSpace();
		
		String [] st = {"aab", "abb", "aaa", "aabb", "aabbc"};
		
		for (int i=0; i<st.length; i++) {
			fs.shuffle(st[i].toCharArray());
		}
		
	}
	
	public void shuffle(char [] input) {
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		
		for (int i=0; i<input.length; i++) {
			int count = 0;
			if (hmap.containsKey(input[i])) {
				count = hmap.get(input[i]);
			}
			++count;
			hmap.put(input[i], count);
		}
		
		int size = hmap.size();
		char [] A = new char[size];
		int [] freq = new int[size];
		int index = 0;
		for (Character ch: hmap.keySet()) {
			A[index] = ch;
			freq[index] = hmap.get(ch);
			++index;
		}
		
//		System.out.println("A array: " + Arrays.toString(A));
//		System.out.println("A freq: " + Arrays.toString(freq));
		
		char [] result = new char[input.length];
		//assuming char with ASCII value 0 does not exists in the input
		shuffle(A, freq, 0, result, (char)0);
		System.out.println("result: " + Arrays.toString(result));
	}
	
	private boolean shuffle(char [] A, int [] freq, int index, char [] result, char lastVal) {
		if (index == result.length) {
			//System.out.println(Arrays.toString(result));
			return true;
		}
		
		for (int i=0; i<A.length; i++) {
			if (lastVal == A[i]) {
				continue;
			}
			if (freq[i] == 0) {
				continue;
			}
			result[index] = A[i];
			freq[i]--;
			if (shuffle(A, freq, index+1, result, A[i])) {
				return true;
			}
			freq[i]++;
		}
		return false;
	}
}
