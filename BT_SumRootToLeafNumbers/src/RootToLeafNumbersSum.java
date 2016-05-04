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
 		7
 	3        9
 2    5   8
 */
public class RootToLeafNumbersSum {
	
	private TreeNode root = null;
	
	public static void main(String [] args) {
		RootToLeafNumbersSum BT = new RootToLeafNumbersSum();
		int [] A = {7, 3, 9, 2, 5, 8};
		BT.buildBST(A);
		BT.preorder();
		System.out.println("total sum: " + BT.sumRootToLeaf());
	}
	
	public int sumRootToLeaf() {
		if (root == null) {
			return 0;
		}
		return dfs(root, 0, 0);
	}
	
	private int dfs(TreeNode node, int num, int sum) {
		if (node == null) {
			return sum;
		}
		num = num*10 + node.value;
		
		//leaf
		if (node.left == null && node.right == null) {
			sum += num;
			return sum;
		}
		
		//left subtree + right subtree
		sum = dfs(node.left, num, sum) + dfs(node.right, num, sum);
		return sum;
	}
	
	public void preorder() {
		preorder(root);
		System.out.println();
	}
	private void preorder(TreeNode node) {
		if (node == null) {
			return;
		}
		
		System.out.print(node.value + " ");
		
		if (node.left != null) {
			preorder(node.left);
		}
		
		if (node.right != null) {
			preorder(node.right);
		}
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
