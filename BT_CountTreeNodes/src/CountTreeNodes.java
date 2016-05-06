import java.util.Stack;


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
public class CountTreeNodes {
	
	private TreeNode root = null;
	
	public static void main(String[] args) {
		CountTreeNodes CT = new CountTreeNodes();

		int [] A = { 20, 10, 30, 5, 12, 23, 35, 3, 7 };
		
		CT.buildBST(A);
		CT.inorder();
		System.out.println();
		System.out.println("total nodes in the tree: " + CT.countNodes());
		
		
	}
	
	public int countNodes() {
		return countNodes(root);
	}
	
	private int countNodes(TreeNode node) {
		if (node == null) { 
			return 0;
		}
		
		int left = getLeftHeight(node) + 1;
		int right = getRightHeight(node) + 1;
		
		if (left == right) {
			return (int)(Math.pow(2, (left-1))) - 1;
		} else {
			return countNodes(node.left) + 1 + countNodes(node.right);
		}
	}
	
	private int getLeftHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		int height = 0;
		while (node != null) {
			node = node.left;
			++height;
		}
		return height;
	}
	
	private int getRightHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int height = 0;
		while (node != null) {
			node = node.right;
			++height;
		}
		return height;
	}
	
	public void inorder() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				System.out.print(node.value + " ");
				node = node.right;
			}
		}
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
