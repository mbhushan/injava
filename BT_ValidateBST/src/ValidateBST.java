
class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

public class ValidateBST {
	
	private TreeNode root = null;
	
/*
    	      20
        10            30
    5      12   23       35
 3     7
*/
	public static void main(String [] args) {
		ValidateBST BST = new ValidateBST();
		int [] A = {20, 10, 30, 5, 12, 23, 35, 3, 7};
		BST.buildBST(A);
		System.out.println("valid BST: " + BST.validateBST());
	}
	
	public boolean validateBST() {
		return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean validateBST(TreeNode node, int min, int max) {
		if (node == null) {
			return true;
		}
		
		if (node.value <= min || node.value >= max) {
			return false;
		}
		
		return (validateBST(node.left, min, node.value) && (validateBST(node.right, node.value, max)));
	}
	
	public void buildBST(int [] A) {
		if (null == A) {
			return ;
		}
		int len = A.length;
		for (int i=0; i<len; i++) {
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
