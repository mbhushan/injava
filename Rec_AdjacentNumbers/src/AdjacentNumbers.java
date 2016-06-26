import java.util.ArrayList;


/**
 * Generate all combination of size k and less of adjacent numbers
 * e.g 1,2,3,4 k = 2
 * 1 2 3 4
 * 12 3 4
 * 1 23 4
 * 1 2 3 34
 * 12 34
 */

public class AdjacentNumbers {
	
	public static void main(String[] args) {
		AdjacentNumbers an = new AdjacentNumbers();

		int [] digits = {1,2,3,4};
		int k = 2;
		
		int ans = an.findCombinations(digits, k);
		System.out.println("total combination: " + ans);
		
	}
	
	public int findCombinations(int [] digits, int k) {
		return findCombinations(digits, k, 0, new ArrayList<Integer>());
	}
	
	private int findCombinations(int [] digits, int k, int index, ArrayList<Integer> list) {
		if (index >= digits.length) {
			System.out.println(list.toString());
			return 1;
		}
		
		int count = 0;
		for (int i=1; i<=k; i++) {
			if (index+i <= digits.length) {
				int num = formNumber(digits, index, index+i);
				list.add(num);
				count += findCombinations(digits, k, index+i, list);
				list.remove(list.size()-1);
			}
		}
		
		return count;
	}
	
	private int formNumber(int [] digits, int start, int end) {
		int num = 0;
		for (int i=start; i<end; i++) {
			num = num*10 + digits[i];
		}
		return num;
	}
	
	
}
