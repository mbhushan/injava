/**
 * Given a preorder sequence how many unique trees can be created
 * Solution is catalan number. Number of tree is exactly same
 * as number of unique BST create with array of size n
 * 
 * The way it works for preorder sequence is as follows
 * 
 * Suppose our preorder sequence is 1 2 3 4
 * So we need to compute following things
 * count(3)* 2 (combination of 2,3 and 4 on both side of 1)
 * count(1)*count(2) (combination of 2 on one side and 3, 4 on other side)
 * count(2)*count(1) (combinatino of 2,3 on one side and 4 on other side)
 * count(3)*2 can be broken into count(3)*count(0) + count(0)*count(3)
 * 
 * So our final result is
 * count(0)*count(3) + count(1)*count(2) + count(2)*count(1) + count(3)*count(0)
 * which is a catalan number
 */

public class CountBTreePreorder {

	public static void main(String[] args) {
		CountBTreePreorder cbt = new CountBTreePreorder();
		
		for (int i=1; i<=10; i++) {
			System.out.println("n : " + i + "; trees: " + cbt.countTrees(i));
		}
	}
	
	public int countTrees(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int [] T = new int[n+1];
		T[0] = 1;
		T[1] = 1;
		
		for (int i=2; i<=n; i++) {
			for (int j=0; j<i; j++) {
				T[i] += (T[j] * T[i-j-1]);
			}
		}
		return T[n];
	}
}
