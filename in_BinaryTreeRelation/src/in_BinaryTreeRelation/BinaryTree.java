package in_BinaryTreeRelation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 Given a list of child->parent relationships, build a binary tree out of it. All the element Ids inside the tree are unique. 

 Example: 

 Given the following relationships: 

 Child Parent IsLeft 
 15 20 true 
 19 80 true 
 17 20 false 
 16 80 false 
 80 50 false 
 50 null false 
 20 50 true 


 You should return the following tree: 
 50 
 / \ 
 20 80 
 / \ / \ 
 15 17 19 16 


 Function Signature 
 */

/**
 * Represents a pair relation between one parent node and one child node inside
 * a binary tree If the _parent is null, it represents the ROOT node
 */
class Relation {
	public Integer _parent;
	public Integer _child;
	public boolean _isLeft;
	
	Relation(Integer p, Integer c, boolean isleft) {
		this._parent = p;
		this._child = c;
		this._isLeft = isleft;
	}
}

/**
 * Represents a single Node inside a binary tree
 */
class Node {
	public Integer _id;
	public Node _left;
	public Node _right;
	
	Node (Integer id) {
		this._id = id;
		this._left = null;
		this._right = null;
	}
}

public class BinaryTree {
	
	private static Node root = null;

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		Integer [] child = {15, 19, 17, 16, 80, 50, 20};
		Integer [] parent ={20, 80, 20, 80, 50, null, 50};
		boolean [] isleft = {true, true, false, false, false, false, true};
		
		int n = child.length;
				
		Relation [] relations = new Relation[n];
		for (int i=0; i<n; i++) {
			relations[i] = new Relation(parent[i], child[i], isleft[i]);
		}
		List<Relation> data = new ArrayList<Relation>();
		Collections.addAll(data, relations);
		
		root = bt.buildTree(data);
		bt.inorder(root);
		
	}
	
	public void inorder(Node node) {
		if (node == null) {
			return;
		}
		
		Stack<Node> stack = new Stack<Node>();
		
		System.out.println("inorder traversal: ");
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node._left;
			} else {
				node = stack.pop();
				System.out.print(node._id + " ");
				node = node._right;
			}
		}
		System.out.println();
	}
	
	
	/**
	 * Implement a method to build a tree from a list of parent-child
	 * relationships And return the root Node of the tree
	 */
	public Node buildTree(List<Relation> data) {
		Node root = null;
		
		int size = data.size();
		HashMap<Integer, Node> hmap = new HashMap<Integer, Node>();
		
		for (int i=0; i<size; i++) {
			if (data.get(i)._parent == null) {
				root = new Node(data.get(i)._child);
				hmap.put(data.get(i)._child, root);
				break;
			}
		}
		
		for (int i=0; i<size; i++) {
			Relation relation = data.get(i);
			Integer child = relation._child;
			Integer parent = relation._parent;
			boolean isleft = relation._isLeft;
			Node childNode = null, parentNode = null;
			if (hmap.containsKey(parent)) {
				parentNode = hmap.get(parent);
			}
			if (hmap.containsKey(child)) {
				childNode = hmap.get(child);
			}
			if (parentNode == null) {
				parentNode = new Node(parent);
				hmap.put(parent, parentNode);
			}
			if (childNode == null) {
				childNode = new Node(child);
				hmap.put(child, childNode);
			}
			
			if (isleft) {
				parentNode._left = childNode;
			} else {
				parentNode._right = childNode;
			}
		}
		
		return root;
	}

}
