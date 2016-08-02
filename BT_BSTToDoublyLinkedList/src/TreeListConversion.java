import java.util.Stack;


public class TreeListConversion {
	
	private Node root = null;
	
	public static void main(String[] args) {
		TreeListConversion tc = new TreeListConversion();
		int [] A = {4, 2, 5, 1, 3};
		
		tc.buildBST(A);
		tc.inorder();
		tc.treeToList();
	}
	
	public void treeToList() {
		Node node = treeToList(root);
		
		System.out.println("printing doubly linked list: ");
		Node curr = node;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.right;
			if (curr == node) {
				break;
			}
		}
		System.out.println();
	}
	
	private Node treeToList(Node node) {
		if (node == null) {
			return null;
		}
		
		Node aList = treeToList(node.left);
		Node bList = treeToList(node.right);
		
		node.left = node;
		node.right = node;
		
		aList = append(aList, node);
		aList = append(aList, bList);
		
		return aList;
	}
	
	private Node append(Node a, Node b) {
		if (a == null) { return b; }
		if (b == null) { return a; }
		
		Node aLast = a.left;
		Node bLast = b.left;
		
		join(aLast, b);
		join(bLast, a);
		
		return a;
	}
	
	private void join(Node a, Node b) {
		a.right = b;
		b.left = a;
	}
	
	public void inorder() {
		inorder(root);
	}
	
	private void inorder(Node node) {
		Stack<Node> stack = new Stack<Node>();
		
		System.out.println("inorder traversal: ");
		
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
	
	public void buildBST(int [] A) {
		for (int i=0; i<A.length; i++) {
			root = insertIntoBST(root, A[i]);
		}
	}
	
	private Node insertIntoBST(Node node, int data) {
		if (node == null) {
			return new Node(data);
		}
		if (data <= node.data) {
			node.left = insertIntoBST(node.left, data);
		} else {
			node.right = insertIntoBST(node.right, data);
		}
		return node;
	}
}

class Node {
	int data;
	Node left;
	Node right;
	
	Node (int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
