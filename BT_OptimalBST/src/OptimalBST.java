
public class OptimalBST {

	
	public int optimalBST(int [] A, int [] F) {
		int low = 0;
		int high = A.length - 1;
		int level = 0;
		return optimalBSTUtil(A, F, low, high, level);
	}
	
	private int optimalBSTUtil(int [] A, int [] F, int low, int high, int level) {
		if (low > high) {
			return 0;
		}
		
		int min = Integer.MAX_VALUE;
		for (int i=low; i<=high; i++) {
			int val = optimalBSTUtil(A, F, low, i-1, level+1) + 
					optimalBSTUtil(A, F, i+1, high, level+1) + level*F[i];
			if (val < min) {
				min = val;
			}
		}
		return min;
	}
	
	public static void main(String [] args) {
		int [] A = {10, 12, 20, 35, 46};
        int [] F = {34, 8, 50, 21, 16};
        OptimalBST OBT = new OptimalBST();
        System.out.println("optimal BST value: " + OBT.optimalBST(A, F));
	}
}
