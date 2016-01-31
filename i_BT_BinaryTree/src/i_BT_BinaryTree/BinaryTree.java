package i_BT_BinaryTree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTree {

	private TreeNode root;
	
	public void insertIntoBST(int value) {
		root = insertIntoBST(root, value);
	}
	
	public TreeNode getRootNode() {
		return root;
	}
	
	private TreeNode insertIntoBST(TreeNode node, int value) {
		if (node == null) {
			return new TreeNode(value);
		}
		
		if (value <= node.val) {
			node.left = insertIntoBST(node.left, value);
		} else {
			node.right = insertIntoBST(node.right, value);
		}
		return node;
	}
}
