
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
public class CheckSymmetry {
private TreeNode root = null;
	
	public static void main(String [] args) {
		int [] A = { 20, 10, 30, 5, 12, 23, 35, 3, 7 };
		CheckSymmetry CS = new CheckSymmetry();
		CS.buildBST(A);
		System.out.println("is symmetric: " + CS.isSymmetric());

	}
	
	public boolean isSymmetric() {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}
	 
	public boolean isSymmetric(TreeNode l, TreeNode r) {
		if (l == null && r == null) {
			return true;
		} else if (r == null || l == null) {
			return false;
		}
	 
		if (l.value != r.value)
			return false;
	 
		if (!isSymmetric(l.left, r.right))
			return false;
		if (!isSymmetric(l.right, r.left))
			return false;
	 
		return true;
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
