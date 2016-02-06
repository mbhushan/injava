package i_BT_HeightBalanced;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BalancedBT {
	
	 private static TreeNode root;
	
	 public static void main(String args[]) {
		 BalancedBT tree = new BalancedBT();
	        tree.root = new TreeNode(1);
	        tree.root.left = new TreeNode(2);
	        tree.root.right = new TreeNode(3);
	        tree.root.left.left = new TreeNode(4);
	        tree.root.left.right = new TreeNode(5);
	        tree.root.left.left.left = new TreeNode(8);
	 
	        if(tree.isBalanced(root) == 1)
	            System.out.println("Tree is balanced");
	        else
	            System.out.println("Tree is not balanced");
	    }

	public static int isBalanced(TreeNode a) {
		if (a == null) {
			return 1;
		}
		int leftHt = 0;
		int rightHt = 0;
		
		leftHt = height(a.left);
        rightHt = height(a.right);
        
        if (Math.abs(leftHt - rightHt) <= 1 && isBalanced(a.left) > 0 && isBalanced(a.right) > 0) {
            return 1;
        }
        
        return 0;
		
	}
	
	private static int height(TreeNode node) {
        
        if (node == null) {
            return 0;
        }
 
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
