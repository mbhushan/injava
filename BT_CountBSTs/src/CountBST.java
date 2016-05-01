
public class CountBST {

	public int countBST(int n) {
		int []count = new int[n+1];
		count[0] = 1;
		count[1] = 1;
		
		for (int i=2; i <= n; i++) {
			for (int j=0; j<=i-1; j++) {
				count[i] = count[i] + count[j] * count[i-j-1];
			}
		}
		return count[n];
	}
	
	public static void main(String [] args) {
		CountBST CB = new CountBST();
		int n = 7;
		for (int i=1; i<=n; i++) {
			System.out.println("unique BSTs with " + i + " nodes: " + CB.countBST(i));
		}
	}
}
