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

public class SortedArrayBST {

	private TreeNode root = null;
	
	public static void main(String [] args) {
		int [] A = {1, 2, 3, 4, 5, 6, 7};
		SortedArrayBST BST = new SortedArrayBST();
		BST.sortedArrayToBST(A);
		System.out.println("inorder traversal: ");
		BST.inorder();
	}
	
	
	public void inorder() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		
		while (!stack.isEmpty() || node!= null) {
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
	
	
	public void sortedArrayToBST(int [] A) {
		root = buildBST(A, 0, A.length-1);
	}
	
	private TreeNode buildBST(int [] A, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = low + (high - low)/2;
		TreeNode node = new TreeNode(A[mid]);
		node.left = buildBST(A, low, mid-1);
		node.right = buildBST(A, mid+1, high);
		return node;
	}
	
}
