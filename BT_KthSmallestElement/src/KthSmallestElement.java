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
public class KthSmallestElement {
	
	private TreeNode root = null;
	
	public static void main(String[] args) {
		KthSmallestElement BT = new KthSmallestElement();
		int [] A = { 20, 10, 30, 5, 12, 23, 35, 3, 7 };
		BT.buildBST(A);
		BT.inorder();
		System.out.println();
		for (int k=1; k<=A.length; k+=2) {
			System.out.print(k + " element: ");
			TreeNode node =  BT.kthElement(k);
			if (node != null) {
				System.out.println(node.value);
			} else {
				System.out.println("null");
			}
			System.out.println();
		}
		
	}
	
	
	
	public TreeNode kthElement(int k) {
		return kthElement(root, k);
	}
	
	private TreeNode kthElement(TreeNode node,  int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				--k;
				if (k == 0) {
					return node;
				}
				node = node.right;
				
			}
		}
		return null;
	}
	
	public void preorder() {
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		
		System.out.println("preorder traversal: ");
		while (!stack.isEmpty()) {
			node = stack.pop();
			System.out.print(node.value + " ");
			
			if (node.right != null) {
				stack.push(node.right);
			}
			
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		System.out.println();
	
	}
	
	public void inorder() {
		inorder(root);
	}
	
	private void inorder(TreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			inorder(node.left);
		}
		System.out.print(node.value + " ");
		if (node.right != null) {
			inorder(node.right);
		}
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
