import java.util.Stack;


public class InorderSuccessor {
	
	private TreeNode root = null;
	
	public static void main(String[] args) {
		InorderSuccessor in = new InorderSuccessor();
		int [] A = {20, 8, 22, 4, 12, 10, 14};
		
		in.buildBST(A);
		in.inorder();
	}
	
	public TreeNode inorderSuccessor(TreeNode node, TreeNode x) {
		if (node == null) {
			return null;
		}
		if (node.right != null) {
			return minTree(node.right);
		}
		
		TreeNode curr = node;
		TreeNode succ = null;
		while (curr != null) {
			if (x.data < curr.data) {
				succ = curr;
				curr = curr.left;
			} else if (x.data > curr.data) {
				curr = curr.right;
			} else {
				break;
			}
		}
		return succ;
	}
	
	private TreeNode minTree(TreeNode node) {
		if (node == null) {
			return null;
		}
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	public void inorder() {
		inorder(root);
	}
	
	 private void inorder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		System.out.println("inorder traversal: ");
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				System.out.print(node.data + " ");
				node = node.right;
			}
		}
		System.out.println();
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
		if (key <= node.data) {
			node.left = insertIntoBST(node.left, key);
		} else {
			node.right = insertIntoBST(node.right, key);
		}
		return node;
		
	}
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode (int data) {
		this.data =data;
		this.left = null;
		this.right = null;
	}
}
