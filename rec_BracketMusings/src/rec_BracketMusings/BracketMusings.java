package rec_BracketMusings;

public class BracketMusings {

	public static void main(String [] args) {
		int n = 3;
		BracketMusings BM = new BracketMusings();
		char [] result = new char[n*2];
		BM.bracketPermutations(result, n, 0, 0, 0);
	}
	
	public void bracketPermutations(char [] result, int n, int pos, int leftIndex, int rightIndex) {
		if (pos == 2*n) {
			printArray(result);
			return;
		}
		if (leftIndex < n) {
			result[pos] = '(';
			bracketPermutations(result, n, pos+1, leftIndex+1, rightIndex);
		}
		if (rightIndex < leftIndex) {
			result[pos] = ')';
			bracketPermutations(result, n, pos+1, leftIndex, rightIndex+1);
		}
	}
	
	private void printArray(char [] result) {
		for (int i=0; i<result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}
}
