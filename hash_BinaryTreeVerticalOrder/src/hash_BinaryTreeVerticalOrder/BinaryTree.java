package hash_BinaryTreeVerticalOrder;

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
			new Node(val);
		}
		if (val <= node.value) {
			node.left = insertIntoBinaryTree(node.left, val);
		} else {
			node.right = insertIntoBinaryTree(node.right, val);
		}
		return node;
	}
}
