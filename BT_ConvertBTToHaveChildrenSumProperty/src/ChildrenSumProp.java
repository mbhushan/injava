import java.util.Stack;


/*
Convert an arbitrary Binary Tree to a tree that holds Children Sum Property
Question: Given an arbitrary binary tree, convert it to a binary tree that holds Children Sum Property. You can only increment data values in any node (You cannot change structure of tree and cannot decrement value of any node).

For example, the below tree doesn’t hold the children sum property, convert it to a tree that holds the property.

             50
           /     \     
         /         \
       7             2
     / \             /\
   /     \          /   \
  3        5      1      30
Algorithm:
Traverse given tree in post order to convert it, i.e., first change left and right children to hold the children sum property then change the parent node.

Let difference between node’s data and children sum be diff.

     diff = node’s children sum - node’s data  
If diff is 0 then nothing needs to be done.

If diff > 0 ( node’s data is smaller than node’s children sum) increment the node’s data by diff.

If diff < 0 (node’s data is greater than the node's children sum) then increment one child’s data. 
We can choose to increment either left or right child if they both are not NULL. Let us always first increment the left child. 
Incrementing a child changes the subtree’s children sum property so we need to change left subtree also. 
So we recursively increment the left child. If left child is empty then we recursively call increment() for right child. 
Let us run the algorithm for the given example. First convert the left subtree (increment 7 to 8).

             50
           /     \     
         /         \
       8             2
     / \             /\
   /     \          /   \
  3        5      1      30
Then convert the right subtree (increment 2 to 31)

          50
        /    \     
      /        \
    8            31
   / \           / \
 /     \       /     \
3       5    1       30
Now convert the root, we have to increment left subtree for converting the root.

          50
        /    \     
      /        \
    19           31
   / \           /  \
 /     \       /      \
14      5     1       30
Please note the last step – we have incremented 8 to 19, and to fix the subtree we have incremented 3 to 14.
 */
public class ChildrenSumProp {
	
	private TreeNode root = null;
	
	public static void main(String[] args) {
		ChildrenSumProp cs = new ChildrenSumProp();
		
		cs.root = new TreeNode(50);
        cs.root.left = new TreeNode(7);
        cs.root.right = new TreeNode(2);
        cs.root.left.left = new TreeNode(3);
        cs.root.left.right = new TreeNode(5);
        cs.root.right.left = new TreeNode(1);
        cs.root.right.right = new TreeNode(30);
        
        cs.inorder(cs.root);
        cs.fixTreeChildrenSumProp(cs.root);
        cs.inorder(cs.root);
		
	}
	
	public void fixTreeChildrenSumProp(TreeNode node) {
		if (node == null || (node.left == null && node.right == null)) {
			return;
		}
		
		fixTreeChildrenSumProp(node.left);
		fixTreeChildrenSumProp(node.right);
		
		int parentData = node.data;
		int leftData = node.left != null ? node.left.data : 0;
		int rightData = node.right != null ? node.right.data : 0;
		
		int diff = parentData - (leftData + rightData);
		if (diff < 0) {
			node.data += Math.abs(diff);
		} else if (diff > 0) {
			fixChildren(node, diff);
		}
	}
	
	private void fixChildren(TreeNode node, int diff) {
		if (node == null || (node.left == null && node.right == null)) {
			return;
		}
		
		if (node.left != null) {
			node.left.data += diff;
			fixChildren(node.left, diff);
			
		} else {
			node.right.data += diff;
			fixChildren(node.right, diff);
		}
	}
	
	public void inorder(TreeNode node) {
		System.out.println("inorder of binary tree: ");
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
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