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

public class BinaryTree {
	private TreeNode root ;
	
	BinaryTree() {
		root = null;
	}
	
	
	public void preorder() {
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			System.out.print(curr.value + " ");
			if (curr.right != null) {
				stack.push(curr.right);
			}
			if (curr.left != null) {
				stack.push(curr.left);
			}
		}
	}
	
	
	public void inorder() {
		inorder(root);
	}
	
	private void inorder(TreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			inorder(node.left);
		}
		System.out.print(node.value + " ");
		if (node.right != null) {
			inorder(node.right);
		}
	}
	
	public void buildBinaryTree(int [] A) {
		if (null == A) {
			return ;
		}
		int len = A.length;
		for (int i=0; i<len; i++) {
			root = insertIntoBT(root, A[i]);
		}
	}
	
	private TreeNode insertIntoBT(TreeNode node, int key) {
		if (node == null) {
			return new TreeNode(key);
		}
		if (key <= node.value) {
			node.left = insertIntoBT(node.left, key);
		} else {
			node.right = insertIntoBT(node.right, key);
		}
		return node;
	}
}
