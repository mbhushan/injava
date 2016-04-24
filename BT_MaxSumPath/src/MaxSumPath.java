
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

public class MaxSumPath {
	private TreeNode root = null;
	

	public static void main(String [] args) {
		int [] A = { 20, 10, 30, 5, 12, 23, 35, 3, 7 };
		MaxSumPath MSP = new MaxSumPath();
		MSP.buildBST(A);
		System.out.println("max path sum value: " + MSP.maxPathSum());
		System.out.println("max path sum value: " + MSP.getMaxPath());
	}
	
	public int getMaxPath() {
		return getMax(root);
	}
	
	private int getMax(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = getMax(node.left);
		int right = getMax(node.right);
		return (node.value + (left > right ? left : right));
	}
	
	public int maxPathSum() {
		int [] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		return maxPathSum(root, max);
	}
	
	private int maxPathSum(TreeNode node, int [] max) {
		if (node == null) {
			return 0;
		}
		int left = maxPathSum(node.left, max);
		int right = maxPathSum(node.right, max);
		int currValue = Math.max(node.value, Math.max(node.value + left, node.value + right));
		max[0] = Math.max(max[0], Math.max(currValue, node.value + left + right));
		return currValue;
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
