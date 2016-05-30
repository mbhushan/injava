package fx_LCA_BinaryTree;

import java.util.Stack;

public class LowestCommonAncestor {

	private TreeNode root = null;

	public static void main(String[] args) {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		int [] A = {1, 3, 4, 5, 8, 9, 10, 11, 14, 18, 21, 25, 27, 30, 35};
		lca.buildTree(A);
		lca.inorderIter();
		int n1 = 3;
		int n2 = 8;
		lca.findLCA(n1, n2);
	}
	
	public void findLCA(int n1, int n2) {
		TreeNode lca = findLCA(root, n1, n2);
		if (lca != null) {
			System.out.println("Lowest common ancestor: " + lca.value);
		} else {
			System.out.println("no LCA found!!");
		}
	}
	
	public TreeNode findLCA(TreeNode node, int n1, int n2) {
		if (node == null) {
			return null;
		}
		if (node.value == n1 || node.value == n2) {
			return node;
		}
		TreeNode left = findLCA(node.left, n1, n2);
		TreeNode right = findLCA(node.right, n1, n2);
		if (left != null && right != null) { // left and right are on either side of root;
			return node;
		}
		if (left != null) {
			return left;
		}
		return right;
	}
	
	public void inorderIter() {
		inorderIterUtil(root);
	}
	
	private void inorderIterUtil(TreeNode node) {
		if (node == null) {
			return ;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		System.out.println("inorder traversal is : ");
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
