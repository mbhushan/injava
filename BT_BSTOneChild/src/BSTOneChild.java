/*
Check if each internal node of a BST has exactly one child
Given Preorder traversal of a BST, check if each non-leaf node has only one child. Assume that the BST contains unique entries.

Examples

Input: pre[] = {20, 10, 11, 13, 12}
Output: Yes
The give array represents following BST. In the following BST, every internal
node has exactly 1 child. Therefor, the output is true.
        20
       /
      10
       \
        11
          \
           13
           /
         12
In Preorder traversal, descendants (or Preorder successors) of every node appear after the node. 
In the above example, 20 is the first node in preorder and all descendants of 20 appear after it. 
All descendants of 20 are smaller than it. For 10, all descendants are greater than it. 
In general, we can say, if all internal nodes have only one child in a BST, 
then all the descendants of every node are either smaller or larger than the node. 
The reason is simple, since the tree is BST and every node has only one child, 
all descendants of a node will either be on left side or right side, means all descendants will either be smaller or greater.

Since all the descendants of a node must either be larger or smaller than the node. We can do following for every node in a loop.
1. Find the next preorder successor (or descendant) of the node.
2. Find the last preorder successor (last element in pre[]) of the node.
3. If both successors are less than the current node, or both successors are greater than the current node, then continue. 
Else, return false.
*/

public class BSTOneChild {

	public static void main(String[] args) {
		BSTOneChild bst = new BSTOneChild();
		
		int pre[] = new int[]{8, 3, 5, 7, 6};
		System.out.println("has only one child: " + bst.hasOnlyOneChild(pre));
		
	}
	
	public boolean hasOnlyOneChild(int [] pre) {
		
		for (int i=0; i<pre.length-1; i++) {
			int nextDiff = pre[i] - pre[i+1];
			int lastDiff = pre[i] - pre[pre.length-1];
			if (nextDiff * lastDiff < 0) {
				return false;
			}
		}
		return true;
	}
}
