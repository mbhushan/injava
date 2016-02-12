package i_CreateBinaryTree;

import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class CreateTree {
	
	public static void main(String[] args) {
		Integer [] in = {2, 1, 3};
		Integer [] post = {2, 3, 1};
	}

	
	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
		int inLen = inorder.size();
		int postLen = postorder.size();
		
		Integer [] inor = inorder.toArray(new Integer[inLen]);
		Integer [] postor = postorder.toArray(new Integer[postLen]);
		
		return buildTree(inor, 0, inLen-1, postor, 0, postLen-1);
		
		
	}
	
	 
	public static TreeNode buildTree(Integer[] inorder, int inStart, int inEnd,
			Integer[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return null;
	 
		int rootValue = postorder[postEnd];
		TreeNode root = new TreeNode(rootValue);
	 
		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == rootValue) {
				k = i;
				break;
			}
		}
	 
		root.left = buildTree(inorder, inStart, k - 1, postorder, postStart,
				postStart + k - (inStart + 1));
		// Becuase k is not the length, it it need to -(inStart+1) to get the length
		root.right = buildTree(inorder, k + 1, inEnd, postorder, postStart + k- inStart, postEnd - 1);
		// postStart+k-inStart = postStart+k-(inStart+1) +1
	 
		return root;
	}
}
