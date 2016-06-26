package rec_BracketCombination;


public class BracketCombination {

	public static void main(String[] args) {
		BracketCombination bc = new BracketCombination();
		
		int n = 3;
		char [] data = new char[n*2];
		bc.bracketCombination(n, 0, 0, 0, data);
		
	}
	
	public int bracketCombination(int n, int left, int right, int index, char [] data) {
		if (index == n*2) {
			System.out.println(new String(data));
			return 1;
		}
		
		int count = 0;
		if (left < n) {
			data[index] = '(';
			count += bracketCombination(n, left+1, right, index+1, data);
		}
		
		if (right < left) {
			data[index] = ')';
			count += bracketCombination(n, left, right+1, index+1, data);
		}
		
		return count;
	}
}
