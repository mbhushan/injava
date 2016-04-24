
class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int value) {
		this.value = value;
		left = null;
		right = null;
	}
	
}
/*
	    	      20
	        10            30
	    5      12   23       35
	 3     7
*/


public class HeightBalanced {

	private TreeNode root = null;
	
	public static void main(String [] args) {
		int [] A = { 20, 10, 30, 5, 12, 23, 35, 3, 7 };
		HeightBalanced HB = new HeightBalanced();
		HB.buildBST(A);
		System.out.println("is height balanced: " + HB.isBalanced());

	}
	
	public boolean isBalanced() {
		if (root == null)
			return true;
 
		if (getHeight(root) == -1)
			return false;
 
		return true;
	}
 
	public int getHeight(TreeNode node) {
		if (node == null)
			return 0;
 
		int left = getHeight(node.left);
		int right = getHeight(node.right);
 
		if (left == -1 || right == -1)
			return -1;
 
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
	
	public void buildBST(int [] A) {
		for (int i=0; i<A.length; i++) {
			root = insertIntoBST(root, A[i]);
		}
	}
	
	private TreeNode insertIntoBST(TreeNode node, int key) {
		if (node == null) {
			return new TreeNode(key);
		}
		if (key <= node.value) {
			node.left = insertIntoBST(node.left, key);
		} else {
			node.right = insertIntoBST(node.right, key);
		}
		return node;
		
	}
}
