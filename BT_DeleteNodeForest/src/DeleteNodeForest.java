import java.util.ArrayList;


class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	boolean shouldDelete = false;
	
	TreeNode(int value, boolean shouldDelete) {
		this.value = value;
		this.left = null;
		this.right = null;
		this.shouldDelete = shouldDelete;
	}
}

public class DeleteNodeForest {
	
	private TreeNode root = null;

	public static void main(String [] args) {
		DeleteNodeForest DNF = new DeleteNodeForest();
		int [] A = {2, 5, 6, 7, 9, 12, 15, 17, 19};
		boolean [] B = {true, false, false, true, false, true, true, false, false};
		DNF.buildBinaryTree(A, B);
		DNF.inorder();
		ArrayList<TreeNode> result = DNF.getForestNodes();
		System.out.println("forest root nodes: ");
		for (TreeNode node: result) {
			if (node == null) continue;
			System.out.println(node.value);
		}
	}
	
	public ArrayList<TreeNode> getForestNodes() {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		getForestNodes(root, result);
		return result;
	}
	
	private void getForestNodes(TreeNode node, ArrayList<TreeNode> result) {
		if (node == null) {
			return;
		}
			if (node != null && node.shouldDelete) {
				if (node.left != null && !node.left.shouldDelete)
					result.add(node.left);
				if (node.right != null && !node.right.shouldDelete)
					result.add(node.right);
			}
			
		if (node.left != null)
			getForestNodes(node.left, result);
		
		if (node.right != null)
			getForestNodes(node.right, result);
	}
	
	private TreeNode getNextDeleteNode(TreeNode node) {
		if (node == null) {
			return null;
		}
		if (node != null && node.shouldDelete) {
			return node;
		}
		if (node.left != null)
			getNextDeleteNode(node.left);
		if (node.right != null)
			getNextDeleteNode(node.right);
		return null;
	}

	
	public void inorder() {
		System.out.println("inorder traversal: ");
		inorder(root);
		System.out.println();
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

	public void buildBinaryTree(int [] A, boolean [] B) {
		int len = A.length;
		int low = 0;
		int high = len-1;
		root = binaryTree(A, B, low, high);
	}
	
	private TreeNode binaryTree(int [] A, boolean []B, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = low + (high - low)/2;
		TreeNode node = new TreeNode(A[mid], B[mid]);
		node.left = binaryTree(A,B, low, mid-1);
		node.right = binaryTree(A, B, mid+1, high);
		return node;
	}
	
}
