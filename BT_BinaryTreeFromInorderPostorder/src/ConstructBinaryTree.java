import java.util.Stack;


/*
http://www.programcreek.com/2013/01/construct-binary-tree-from-inorder-and-postorder-traversal/

Given inorder and postorder traversal of a tree, construct the binary tree.
Analysis
This problem can be illustrated by using a simple example.

in-order:   4 2 5  (1)  6 7 3 8
post-order: 4 5 2  6 7 8 3  (1)
From the post-order array, we know that last element is the root. We can find the root in in-order array. 
Then we can identify the left and right sub-trees of the root from in-order array.

Using the length of left sub-tree, we can identify left and right sub-trees in post-order array. 
Recursively, we can build up the tree.
 */
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

public class ConstructBinaryTree {
	
	private TreeNode root = null;
	
	public static void main(String [] args) {
		int [] inorder = {4, 2, 5, 1, 6, 7, 3, 8};
		int [] postorder = {4, 5, 2,  6, 7, 8, 3 , 1};
		ConstructBinaryTree CBT = new ConstructBinaryTree();
		CBT.buildTree(inorder, postorder);
		CBT.inorder();
	}
	
	public void inorder() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		
		while (!stack.isEmpty() || node != null) {
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
	

	public void buildTree(int [] inorder, int [] postorder) {
		int inStart = 0;
		int inEnd = inorder.length - 1;
		int postStart = 0;
		int postEnd = postorder.length - 1;
		
		root = buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
	}
	
	private TreeNode buildTree(int [] inorder, int instart, int inend, int [] postorder, int pstart, int pend) {
		if (instart > inend || pstart > pend) {
			return null;
		}
		int rootValue = postorder[pend];
		TreeNode node = new TreeNode(rootValue);
		int k = 0;
		for (int i=instart; i<= inend; i++) {
			if (inorder[i] == rootValue) {
				k = i;
				break;
			}
		}
		node.left = buildTree(inorder, instart, k-1, postorder, pstart, pstart + (k - (instart + 1)));
		node.right = buildTree(inorder, k+1, inend, postorder, pstart + (k - instart), pend -1);
		return node;
	}
	
}
