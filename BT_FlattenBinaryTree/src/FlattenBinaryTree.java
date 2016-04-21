import java.util.Stack;


class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

public class FlattenBinaryTree {
	
	private TreeNode root = null;
/*
    	      20
        10            30
    5      12   23       35
 3     7
*/
	public static void main(String [] args) {
		FlattenBinaryTree FBT = new FlattenBinaryTree();
		int [] A = {20, 10, 30, 5, 12, 23, 35, 3, 7};
		FBT.buildBST(A);
		FBT.inorderRec();
		System.out.println();
		System.out.println("inorder iteratively: ");
		FBT.inorder();
		System.out.println("flattening the binary tree: ");
		FBT.flatten();
		FBT.printFlattenList();
	}
	
	public void printFlattenList() {
		for (TreeNode curr = root; curr != null; curr=curr.right) {
			System.out.print(curr.value + " -> ");
		}
		System.out.println("null");
	}
	public void flatten() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		
		while (node != null || !stack.isEmpty()) {
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				node.right = node.left;
				node.left = null;
			} else if (!stack.isEmpty()) {
				TreeNode curr = stack.pop();
				node.right = curr;
			}
			node = node.right;
			
		}
	}
	
	public void inorderRec() {
		inorderRec(root);
	}
	
	private void inorderRec(TreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			inorderRec(node.left);
		}
		System.out.print(node.value + " ");
		if (node.right != null) {
			inorderRec(node.right);
		}
	}
	
	public void inorder() {
		if (root == null) {
			System.out.println("root is null!!");
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		//stack.push(node);
		
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
		if (null == A) {
			return ;
		}
		int len = A.length;
		for (int i=0; i<len; i++) {
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
