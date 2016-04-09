package rec_AdjacentCombination;

/*
 * Generate all combination of size k and less of adjacent numbers
 * e.g 1,2,3,4 k = 2
 * 1 2 3 4
 * 12 3 4
 * 1 23 4
 * 1 2 3 34
 * 12 34
 */
public class AdjacentCombination {
	
	
	public static void main(String [] args) {
		int [] input = {1,2,3};
		int K = 3;
		int [] result = new int[input.length];
		AdjacentCombination AJ = new AdjacentCombination();
		AJ.combination(input, result, K, 0, 0);
	}

	public void combination(int [] input, int [] result, int K, int pos, int index) {
		if (pos == input.length) {
			for (int i=0; i< index; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i=pos; i<pos+K && i<input.length; i++) {
			result[index] = formNumber(input, pos, i);
			combination(input, result, K, pos+1, index+1);
		}
	}
	
	private int formNumber(int [] input, int start, int end) {
		int num = 0;
		for (int i=start; i<=end; i++) {
			num = num * 10 + input[i];
		}
		return num;
	}
}
