import java.util.LinkedList;
import java.util.Queue;


/*
 * Invert Binary Tree (Java)
Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
*/

class Node<T> {
	T value;
	Node<T> left;
	Node<T> right;
	
	Node(T val) {
		this.value = val;
		this.left = null;
		this.right = null;
	}
}

public class BinaryTree<T extends Comparable<T>>{
	private Node<T> root;
	
	public BinaryTree() {
		root = null;
	}
	
	public Node<T> getBinaryTreeRoot() {
		return this.root;
	}
	
	public void invertBTIterative() {
		invertBTIterUtil(root);
	}
	
	@SuppressWarnings("unchecked")
	private void invertBTIterUtil(Node<T> node) {
		Queue<T> Q = new LinkedList<T>();
		Q.add((T)node);
		
		while (!Q.isEmpty()) {
			Node<T> tmp = (Node<T>) Q.remove();
			if (tmp.left != null) {
				Q.add((T) node.left);
			}
			if (tmp.right != null) {
				Q.add((T)node.right);
			}
			Node<T> swp = tmp.left;
			tmp.left = tmp.right;
			tmp.right = swp;
		}
	}
	
	public void invertBT() {
		invertBinaryTree(root);
	}
	
	private void invertBinaryTree(Node<T> node) {
		Node<T> temp = node.left;
		node.left = node.right;
		node.right = temp;
		
		if (node.left != null) {
			invertBinaryTree(node.left);
		}
		if (node.right != null) {
			invertBinaryTree(node.right);
		}

	}
	
	public void printBinaryTree() {
		printInorderBT(root);
	}
	
	private void printInorderBT(Node<T> node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			printInorderBT(node.left);
		}
		
		System.out.print(node.value + " ");
		
		if (node.right != null) {
			printInorderBT(node.right);
		}
	}
	
	public void buildBinaryTree(T [] keys) {
		int len = keys.length;
		for (int i=0; i<len; i++) {
			root = insertIntoBT(root, keys[i]);
		}
	}
	
	private Node<T> insertIntoBT(Node<T> node, T key) {
		if (node == null) {
			return new Node<T>(key);
		}
		if (key.compareTo(node.value) <= 0) {
			node.left = insertIntoBT(node.left, key);
		} else {
			node.right = insertIntoBT(node.right, key);
		}
		return node;
	}

}
