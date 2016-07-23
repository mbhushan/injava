public class CountUniqueBST {

	public static void main(String[] args) {
		CountUniqueBST cbt = new CountUniqueBST();

		for (int i = 0; i < 10; i++) {
			System.out.println("n: " + i + " BST: " + cbt.uniqueBST(i));
			System.out.println("n: " + i + " BST DP: " + cbt.uniqueBSTreeDP(i));
		}
	}
	
	public int uniqueBSTreeDP(int n) {
		
		if (n ==0 || n == 1) {
			return 1;
		}
		
		int [] T = new int[n+1];
		
		T[0] = 1;
		T[1] = 1;
		
		for (int i=2; i<=n; i++) {
			for (int j=0; j<i; j++) {
				T[i] += T[j] * T[i-j-1];
			}
		}
		return T[n];
	}

	public int uniqueBST(int n) {
		if (n <= 1) {
			return 1;
		} else {

			int left, right, ans = 0;

			for (int i = 1; i <= n; i++) {
				left = uniqueBST(i-1);
				right = uniqueBST(n - i);
				ans += left * right;
			}
			return ans;
		}
	}
}
