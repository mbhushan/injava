package i_BT_MaxPathSum;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class MaxPathSum {
	
	private static int res = Integer.MIN_VALUE;
	private static TreeNode root;
	
	 public static void main(String args[]) {
		 MaxPathSum tree = new MaxPathSum();
	        tree.root = new TreeNode(10);
	        tree.root.left = new TreeNode(2);
	        tree.root.right = new TreeNode(10);
	        tree.root.left.left = new TreeNode(20);
	        tree.root.left.right = new TreeNode(1);
	        tree.root.right.right = new TreeNode(-25);
	        tree.root.right.right.left = new TreeNode(3);
	        tree.root.right.right.right = new TreeNode(4);
	        System.out.println("maximum path sum is : " +
	        		maxPathSum(root));
	    }

	public static int maxPathSum(TreeNode a) {
		findMaxUtil(a);
		return res;
	}
	
	private static int findMaxUtil(TreeNode node)
    {
 
        // Base Case
        if (node == null)
            return 0;
 
        // l and r store maximum path sum going through left and
        // right child of root respectively
        int l = findMaxUtil(node.left);
        int r = findMaxUtil(node.right);
 
        // Max path for parent call of root. This path must
        // include at-most one child of root
        int max_single = Math.max(Math.max(l, r) + node.val,
                                  node.val);
 
 
        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + node.val);
 
        // Store the Maximum Result.
        res = Math.max(res, max_top);
 
        return max_single;
    }
}
