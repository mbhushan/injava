package i_BT_Iterator;

import java.io.PushbackInputStream;
import java.util.Stack;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTree {

	static Stack<TreeNode> stack = new Stack<TreeNode>();
	 public BinaryTree(TreeNode root) {
	       pushLeftTree(root); 
	    }

	    /** @return whether we have a next smallest number */
	    public static boolean hasNext() {
	        return !stack.isEmpty();
	    }

	    /** @return the next smallest number */
	    public static int next() {
	    	TreeNode tmp = stack.pop();
	    	pushLeftTree(tmp.right);
	    	return tmp.val;
	        
	    }
	    
	    private static void pushLeftTree(TreeNode node) {
	    	while (node != null) {
	    		stack.push(node);
	    		node = node.left;
	    	}
	    }
}
