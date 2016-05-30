package fx_LCA_BST;

import java.util.Stack;

public class LowetCommonAncestorBST {
	private TreeNode root = null;
	
	public static void main(String[] args) {
		LowetCommonAncestorBST lca = new LowetCommonAncestorBST();
		
		int [] A = {2, 3, 4, 5, 6, 7, 8, 9, 11, 13, 15, 17, 18, 20, 23};
		lca.buildBST(A);
		lca.inorder();
		int n1 = 11;
		int n2 = 18;
		lca.lca(n1, n2);
	}
	
	public void lca(int n1, int n2)  {
		TreeNode node = lca(root, n1, n2);
		if (node != null) {
			System.out.println("LCA: " + node.value);
		} else {
			System.out.println("LCA not found!");
		}
	}
	
	private TreeNode lca(TreeNode node, int n1, int n2) {
		if (node == null) {
			return null;
		}
		
		if (Math.max(n1, n2) < node.value) {
			return lca(node.left, n1, n2);
		} else if (Math.min(n1, n2) > node.value) {
			return lca(node.right, n1, n2);
		} else {
			return node;
		}
	}
	
	
	public void inorder() {
		inorder(root);
	}
	
	private void inorder(TreeNode node) {
		if (node == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
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
		System.out.println();
	}
	
	public void buildBST(int [] A) {
		if (A == null || A.length < 1) {
			return ;
		}
		
		root = buildBST(A, 0, A.length-1);
	}
	
	private TreeNode buildBST(int [] A, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = low + (high - low)/2;
		TreeNode node = new TreeNode(A[mid]);
		
		node.left = buildBST(A, low, mid-1);
		node.right = buildBST(A, mid+1, high);
		
		return node;
	}
}

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
