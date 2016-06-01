package fx_LCA_BT;

import java.util.Stack;


/*
 * implement LCA for BT
 * http://articles.leetcode.com/lowest-common-ancestor-of-a-binary-tree-part-ii/
 */

public class LCA {
	
	private TreeNode root = null;

	public static void main(String[] args) {
		LCA obj = new LCA();

		int [] A = {2, 3, 4, 5, 6, 7, 8, 9, 11, 13, 15, 17, 18, 20, 23};
		obj.buildTree(A);
		obj.inorder();
		
		int n1 = 11;
		int n2 = 18;
		obj.lcaBT(n1, n2);
		obj.lcaBST(n1, n2);
		
	}
	
	public void lcaBST(int n1, int n2) {
		TreeNode node = lcaBST(root, n1, n2);
		if (node != null) {
			System.out.println("LCA is: " + node.value);
		} else {
			System.out.println("LCA not found!");
		}
	}
	
	private TreeNode lcaBST(TreeNode node, int n1, int n2) {
		if (node == null) {
			return null;
		}
		if (Math.max(n1, n2) < node.value) {
			return lcaBST(node.left, n1, n2);
		} else if (Math.min(n1, n2) > node.value) {
			return lcaBST(node.right, n1, n2);
		} else {
			return node;
		}
	}
	
	public void lcaBT(int n1, int n2) {
		TreeNode node = lcaBT(root, n1, n2);
		if (node != null) {
			System.out.println("LCA is: " + node.value);
		} else {
			System.out.println("LCA not found!");
		}
	}
	
	private TreeNode lcaBT(TreeNode node, int n1, int n2) {
		if (node == null) {
			return null;
		}
		if (node.value == n1 || node.value == n2) {
			return node;
		}
		TreeNode left = lcaBT(node.left, n1, n2);
		TreeNode right = lcaBT(node.right, n1, n2);
		
		if (left != null && right != null) {
			return node;
		}
		
		if (left != null) {
			return left;
		}
		return right;
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
	
	public void buildTree(int [] A) {
		root = buildBT(A, 0, A.length-1);
	}
	
	private TreeNode buildBT(int [] A, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = low + (high - low)/2;
		TreeNode node = new TreeNode(A[mid]);
		node.left = buildBT(A, low, mid-1);
		node.right = buildBT(A, mid+1, high);
		
		return node;
	}
}

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int x) {
		this.value = x;
		this.left = null;
		this.right = null;
	}
}
