package hash_BinaryTreeVerticalOrder;

import java.util.Stack;

class Node {
	int value;
	Node left;
	Node right;
	Node(int v) {
		value = v;
		left = null;
		right = null;
	}
	
	Node() {
	}
}
public class BinaryTree {

	private Node root = null;
	
	public void insertBinaryTree(int val) {
			root = insertIntoBinaryTree(root, val);
	}
	
	private Node insertIntoBinaryTree(Node node, int val) {
		if (node == null) {
			return new Node(val);
		}
		if (val <= node.value) {
			node.left = insertIntoBinaryTree(node.left, val);
		} else {
			node.right = insertIntoBinaryTree(node.right, val);
		}
		return node;
	}
	
	public void inorder() {
		if (root == null) {
			return ;
		}
		Node node = root;
		Stack<Node> stack = new Stack<Node>();
		while (node != null || !stack.isEmpty()) {
			if (node == null) {
				node = stack.pop();
				System.out.print(node.value + " ");
				node = node.right;
			}
			if (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		System.out.println();
	}
	
}
