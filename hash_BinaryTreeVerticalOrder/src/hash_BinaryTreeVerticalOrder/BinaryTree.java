package hash_BinaryTreeVerticalOrder;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	
	public void verticalTraversal() {
		HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<Integer, ArrayList<Integer>>();
		
		verticalTraversal(root, hmap, 0);
		
		int min = 0;
		int max = 0;
		for (Integer key : hmap.keySet()) {
			if (key < min) {
				min = key; 
			}
			if (key > max) {
				max = key;
			}
		}
		
		for (int key = min; key <= max; key++) {
			ArrayList<Integer> list = hmap.get(key);
			for (int v: list) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
		
	}
	
	private void verticalTraversal(Node node, HashMap<Integer, ArrayList<Integer>> hmap, int hd) {
		if (node == null) {
			return ;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (hmap.containsKey(hd)) {
			list = hmap.get(hd);
		}
		list.add(node.value);
		hmap.put(hd, list);
		
		verticalTraversal(node.left, hmap, hd-1);
		verticalTraversal(node.right, hmap, hd+1);
		
	}
	
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
