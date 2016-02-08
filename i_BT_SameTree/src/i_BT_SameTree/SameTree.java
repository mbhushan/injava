package i_BT_SameTree;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class SameTree {
	private static TreeNode root1, root2;
	
	 public static void main(String[] args) {
		 
		 SameTree tree = new SameTree();
	 
	        tree.root1 = new TreeNode(1);
	        tree.root1.left = new TreeNode(2);
	        tree.root1.right = new TreeNode(3);
	        tree.root1.left.left = new TreeNode(4);
	        tree.root1.left.right = new TreeNode(5);
	 
	        tree.root2 = new TreeNode(1);
	        tree.root2.left = new TreeNode(2);
	        tree.root2.right = new TreeNode(3);
	        tree.root2.left.left = new TreeNode(4);
	        tree.root2.left.right = new TreeNode(5);
	 
	        if (tree.isSameTree(root1, root2) == 1) {
	            System.out.println("Both trees are identical");
	        } else {
	            System.out.println("Trees are not identical");
	        }
	 
	    }

	public static int isSameTree(TreeNode a, TreeNode b) {
		
		if (a == null && b == null) {
			return 1;
		}
		
		if (a != null && b != null) {
			if ((a.val == b.val) &&
					isSameTree(a.left, b.left) == 1 &&
					isSameTree(a.right, b.right) == 1
					) {
					return 1;	
					}
		}
		return 0;
	
		
	}
}
