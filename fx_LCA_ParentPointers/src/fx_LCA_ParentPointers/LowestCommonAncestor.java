package fx_LCA_ParentPointers;

import java.util.HashSet;
import java.util.Stack;

/*
			8
	3				10
1		6				14
	4		7		13
 */
public class LowestCommonAncestor {

	private TreeNode root = null;
			
	public static void main(String[] args) {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		int [] A = {8, 3, 10, 1, 6, 14, 4, 7, 13};
		
		lca.buildBST(A);
		lca.inorder();
		
		int n1 = 1;
		int n2 = 4;
		
		TreeNode node1 = lca.findNode(n1);
		TreeNode node2 = lca.findNode(n2);
		
		if (node1 != null) {
			System.out.println("node1: " + node1.value);
		}
		if (node2 != null) {
			System.out.println("node2: " + node2.value);
		}
		lca.findLCA(node1, node2);
	}
	
	public void findLCA(TreeNode n1, TreeNode n2) {
		TreeNode node = findLCA(root, n1, n2);
		if (node != null) {
			System.out.println("lca: " + node.value);
		} else {
			System.out.println("lca not found!");
		}
	}
	
	private TreeNode findLCA(TreeNode node, TreeNode n1, TreeNode n2) {
		HashSet<TreeNode> hset = new HashSet<TreeNode>();
		//hset.add(node);
		
		while (n1 != null || n2 != null) {
			if (n1 != null) {
				if (hset.contains(n1)) {
					return n1;
				}
				hset.add(n1);
				n1 = n1.parent;
			}
			
			if (n2 != null) {
				if (hset.contains(n2)) {
					return n2;
				}
				hset.add(n2);
				n2 = n2.parent;
			}
		}
		return null;
	}
	
	public TreeNode findNode(int x) {
		return findNode(root, x);
	}
	
	private TreeNode findNode(TreeNode node, int x) {
		if (node == null) {
			return null;
		}
		
		if (node.value == x) {
			return node;
		} else if (x < node.value) {
			return findNode(node.left, x);
		} else if (x > node.value){
			return findNode(node.right, x);
		}
		return null;
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
		if (A == null) { 
			return;
		}
		
		for (int i=0; i<A.length; i++) {
			root = insertIntoBST(root, A[i]);
		}
	}
	
	private TreeNode insertIntoBST(TreeNode node, int val) {
		if (node == null) {
			return new TreeNode(val);
		}
		
		if (val < node.value) {
			node.left = insertIntoBST(node.left, val);
			node.left.parent = node;	
		} else if (val > node.value) {
			node.right = insertIntoBST(node.right, val);
			node.right.parent = node;
		}
		return node;
	}
}

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	
	public TreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
}
