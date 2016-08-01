
/*
Check for Children Sum Property in a Binary Tree
Given a binary tree, write a function that returns true if the tree satisfies below property.

For every node, data value must be equal to sum of data values in left and right children. Consider data value as 0 for NULL children.
*/

public class ChildrenSumProperty {
	
	private TreeNode root = null;
	
	public static void main(String[] args) {
		ChildrenSumProperty cs = new ChildrenSumProperty();
		
		cs.root = new TreeNode(10);
        cs.root.left = new TreeNode(8);
        cs.root.right = new TreeNode(2);
        cs.root.left.left = new TreeNode(3);
        cs.root.left.right = new TreeNode(5);
        cs.root.right.right = new TreeNode(2);
		
	}
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
