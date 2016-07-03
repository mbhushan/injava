package rec_CombinationRepeatedKeys;

import java.util.ArrayList;
import java.util.Arrays;

public class Combinations {

	public static void main(String[] args) {
		Combinations com = new Combinations();
		
		//int [] digits = {1,1,2,3,3};
		int [] digits = {1,2,3};
		
		System.out.println("total combinations: " + com.findCombination(digits));
	}
	
	public int findCombination(int [] digits) {
		if (digits == null || digits.length < 1) {
			return 0;
		}
		Arrays.sort(digits);
		
		int [] count = new int[1];
		findCombinations(digits, 0, new ArrayList<Integer>(), count);
		
		return count[0];
	}
	
	private void findCombinations(int [] digits, int index, ArrayList<Integer> list, int [] count) {
//		if (list.size() >= 1) {
			System.out.println(list.toString());
			++count[0];
//			return 1;
//		}
		
		for (int i=index; i<digits.length; i++) {
			if (i != index && digits[i] == digits[i-1]) {
				continue;
			}
			list.add(digits[i]);
			findCombinations(digits, i+1, list, count);
			list.remove(list.size()-1);
		}
	}
}
