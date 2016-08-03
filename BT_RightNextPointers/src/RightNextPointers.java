import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RightNextPointers {

	private TreeNode root = null;
	
	public static void main(String[] args) {

		RightNextPointers rn = new RightNextPointers();
		int[] A = { 4, 2, 5, 1, 3, 7 };
		
		rn.buildTree(A);
		rn.connectNodesSameLevel();
		rn.printLevels();
	}
	
	public void printLevels() {
		printLevels(root);
	}
	
	private void printLevels(TreeNode node) {
		while (node != null) {
			TreeNode curr = node;
			while (curr != null) {
				System.out.print(curr.data + " ");
				curr = curr.next;
			}
			if (node.left != null) {
				node = node.left;
			} else if (node.right != null) {
				node = node.right;
			} else {
				node = null;
			}
			System.out.println();
		}
	}
	
	public void connectNodesSameLevel() {
		connectNodesSameLevel(root);
	}
	
	private void connectNodesSameLevel(TreeNode node) {
		
		TreeNode marker = new TreeNode(null);
		Queue<TreeNode> Q = new LinkedList<TreeNode>();
		
		Q.add(node);
		Q.add(marker);
		
		while (!Q.isEmpty()) {
			TreeNode curr = Q.remove();
			if (curr == marker) {
				if (!Q.isEmpty()) {
					Q.add(marker);
				}
			} else {
				if (Q.peek() != marker) {
					curr.next = Q.peek();
				} else {
					curr.next = null;
				}
				if (curr.left != null) {
					Q.add(curr.left);
				}
				if (curr.right != null) {
					Q.add(curr.right);
				}
			}
		}
		System.out.println("setting next ptr done!");
	}
	
	
	public void inorder() {
		inorder(root);
	}
	
	private void inorder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		System.out.println("inorder traversal : ");
		
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
	
	public void buildTree(int [] A) {
		for (int x: A) {
			root = insertIntoBST(root, x);
		}
	}
	
	private TreeNode insertIntoBST(TreeNode node, int data) {
		if (node == null) {
			return new TreeNode(data);
		}
		if (data <= node.data) {
			node.left = insertIntoBST(node.left, data);
		} else {
			node.right = insertIntoBST(node.right, data);
		}
		return node;
	}

}

class TreeNode {
	Integer data;
	TreeNode left;
	TreeNode right;
	TreeNode next;

	TreeNode(Integer data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.next = null;
	}
}
