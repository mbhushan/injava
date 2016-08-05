import java.util.Stack;

/*
	    	      20
	        10            30
	    5      12   23       35
	 3     7
*/

public class MaximumPathSum {

	private TreeNode root = null;
	
	public static void main(String[] args) {
		MaximumPathSum tree = new MaximumPathSum();
		
		//int [] A = { 20, 10, 30, 5, 12, 23, 35, 3, 7 };
		//mps.buildBST(A);
		int [] B = {2, 1, 3}; 
		tree.buildBST(B);
		tree.inorder();
		System.out.println("max path sum: " + tree.maxPathSum());
		
		tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(10);
        tree.root.left.left = new TreeNode(20);
        tree.root.left.right = new TreeNode(1);
        tree.root.right.right = new TreeNode(-25);
        tree.root.right.right.left = new TreeNode(3);
        tree.root.right.right.right = new TreeNode(4);
        tree.inorder();
		System.out.println("max path sum: " + tree.maxPathSum());
	}
	
	public int maxPathSum() {
		int [] maxs = new int[1];
		maxPathSum(root, maxs);
		return maxs[0];
//		Result res = new Result();
//        res.val = Integer.MIN_VALUE;
//		findMaxUtil(root, res);
//		return res.val;
	}
	
	private int findMaxUtil(TreeNode node, Result res) {
		// Base Case
        if (node == null)
            return 0;
 
        // l and r store maximum path sum going through left and
        // right child of root respectively
        int l = findMaxUtil(node.left, res);
        int r = findMaxUtil(node.right, res);
 
        // Max path for parent call of root. This path must
        // include at-most one child of root
        int max_single = Math.max(Math.max(l, r) + node.data,
                                  node.data);
 
 
        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + node.data);
 
        // Store the Maximum Result.
        res.val = Math.max(res.val, max_top);
 
        return max_single;
	}
	
	private int maxPathSum(TreeNode node, int [] maxs) {
		if (node == null) {
			return 0;
		}
		
		int left = maxPathSum(node.left, maxs);
		int right = maxPathSum(node.right, maxs);
		
		int val = Math.max(node.data, node.data + (Math.max(left, right)));
		int maxSoFar =  Math.max(val, left + right + node.data);
		maxs[0] = Math.max(maxs[0], maxSoFar);
		
		return val;
	}
	
	public void inorder() {
		inorder(this.root);
	}
	
	public void inorder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
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
	
	private TreeNode insertIntoBST(TreeNode node, int key) {
		if (node == null) {
			return new TreeNode(key);
		}
		if (key <= node.data) {
			node.left = insertIntoBST(node.left, key);
		} else {
			node.right = insertIntoBST(node.right, key);
		}
		return node;
		
	}
}

class Result {
	int val;
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode (int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
