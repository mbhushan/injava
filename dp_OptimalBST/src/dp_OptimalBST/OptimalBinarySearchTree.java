package dp_OptimalBST;

public class OptimalBinarySearchTree {

	public static void main(String[] args) {
		OptimalBinarySearchTree obst = new OptimalBinarySearchTree();
		
		int [] keys = {10, 12, 16, 21};
		int [] freq = {4, 2, 6, 3};
		
		System.out.println("min cost: " + obst.minCost(keys, freq));
	}
	
	public int minCost(int [] keys, int [] freq) {
		int [][] T = new int[keys.length][keys.length];
		
		for(int i=0; i < T.length; i++){
            T[i][i] = freq[i];
        }
		
		for (int L=2; L <= keys.length; L++) {
			for (int i=0; i<=keys.length-L; i++) {
				int j = i + L -1;
				T[i][j] = Integer.MAX_VALUE;
				int sum = getSum(freq, i, j);
				for (int k=i; k<=j; k++) {
					int val = sum + (k-1 < i? 0: T[i][k-1]) + 
							(k+1 > j ? 0: T[k+1][j]);
					if (val < T[i][j]) {
						T[i][j] = val;
					}
				}
			}
		}
		
		return T[0][keys.length-1];
	}
	
	private int getSum(int [] freq, int i, int j) {
		int total = 0;
		for (int x=i; x<=j; x++) {
			total += freq[x];
		}
		return total;
	}
}
