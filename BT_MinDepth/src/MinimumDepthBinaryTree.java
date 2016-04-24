import java.util.LinkedList;
import java.util.Queue;
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

public class MinimumDepthBinaryTree {
	private TreeNode root = null;

	public static void main(String [] args) {
		int [] A = { 20, 10, 30, 5, 12, 23, 35, 3, 7 };
		MinimumDepthBinaryTree MBT = new MinimumDepthBinaryTree();
		MBT.buildBST(A);
		//MBT.postorder();
		System.out.println("min depth of binary tree: " + MBT.minimumDepth());
		System.out.println("min depth of binary tree  - recursive: " + MBT.minDepth());
	}
	
	public int minDepth() {
		return minDepthRec(root);
	}
	
	private int minDepthRec(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left =  minDepthRec(node.left);
		int right = minDepthRec(node.right);
		return Math.min(left, right) + 1;
	}
	
	public int minimumDepth() {
		if (root == null) {
			return 0;
		}
		
		Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
		Queue<Integer> countQ = new LinkedList<Integer>();
		TreeNode node = root;
		if (root.left == null && root.right == null) {
			System.out.println("root is single");
		}
		nodeQ.add(node);
		countQ.add(1);
		while (!nodeQ.isEmpty()) {
			node = nodeQ.remove();
			int count = countQ.remove();
			System.out.println("count: " + count);
			if (node.left == null && node.right == null) {
				return count;
			}
			if (node.left != null) {
				nodeQ.add(node.left);
				countQ.add(count+1);
			}
			if (node.right != null) {
				nodeQ.add(node.right);
				countQ.add(count+1);
			}
		}
		return 0;
	}
	
	public void postorder() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		stack.push(node);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.peek();
			if (curr.left == null && curr.right == null) {
				System.out.print(stack.pop().value + " ");
			}
			if (curr.right != null) {
				stack.push(curr.right);
				curr.right = null;
			}
			if (curr.left != null) {
				stack.push(curr.left);
				curr.left = null;
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
		if (key <= node.value) {
			node.left = insertIntoBST(node.left, key);
		} else {
			node.right = insertIntoBST(node.right, key);
		}
		return node;
		
	}
		
 }
