package i_ConstructTreeInPreorder;

import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BuildTreeInPre {

	static int preIndex = 0;

	public TreeNode constructBinaryTree(ArrayList<Integer> preOrder,
			ArrayList<Integer> inOrder) {
		TreeNode node = null;
		ArrayList<Integer> leftPreOrder;
		ArrayList<Integer> rightPreOrder;
		ArrayList<Integer> leftInorder;
		ArrayList<Integer> rightInorder;
		int inorderPos;
		int preorderPos;

		if ((preOrder.size() != 0) && (inOrder.size() != 0)) {
			// Assign the first element of preorder traversal as root
			node = new TreeNode(((Integer) preOrder.get(0)).intValue());

			// Based upon the current node data seperate the traversals into
			// leftPreorder, rightPreorder,
			// leftInorder, rightInorder lists
			inorderPos = inOrder.indexOf(preOrder.get(0));
			leftInorder = new ArrayList<Integer> (inOrder.subList(0, inorderPos));
			rightInorder = new ArrayList<Integer> (inOrder.subList(inorderPos + 1,
					inOrder.size()));

			preorderPos = leftInorder.size();
			leftPreOrder = new ArrayList<Integer>( preOrder.subList(1,
					preorderPos + 1));
			rightPreOrder = new ArrayList<Integer>( preOrder.subList(
					preorderPos + 1, preOrder.size()));

			node.left = constructBinaryTree(leftPreOrder, leftInorder);
			node.right = constructBinaryTree(rightPreOrder, rightInorder);
		}

		return node;
	}

	public static TreeNode buildTree(ArrayList<Integer> preorder,
			ArrayList<Integer> inorder) {
		int inLen = inorder.size();
		int preLen = preorder.size();

		Integer[] inor = inorder.toArray(new Integer[inLen]);
		Integer[] preor = preorder.toArray(new Integer[preLen]);

		return buildTree(inor, preor, 0, inLen - 1);
	}

	private static TreeNode buildTree(Integer in[], Integer pre[], int inStrt,
			int inEnd) {

		if (inStrt > inEnd) {
			return null;
		}

		/*
		 * Pick current node from Preorder traversal using preIndex and
		 * increment preIndex
		 */
		TreeNode tNode = new TreeNode(pre[preIndex++]);

		/* If this node has no children then return */
		if (inStrt == inEnd) {
			return tNode;
		}

		/* Else find the index of this node in Inorder traversal */
		int inIndex = search(in, inStrt, inEnd, tNode.val);

		/*
		 * Using index in Inorder traversal, construct left and right subtress
		 */
		tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
		tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

		return tNode;
	}

	/* UTILITY FUNCTIONS */
	/*
	 * Function to find index of value in arr[start...end] The function assumes
	 * that value is present in in[]
	 */
	private static int search(Integer[] arr, int strt, int end, Integer value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (arr[i] == value) {
				return i;
			}

		}
		return i;
	}

	public static TreeNode buildTree2(ArrayList<Integer> preorder,
			ArrayList<Integer> inorder) {
		int inLen = inorder.size();
		int preLen = preorder.size();

		Integer[] inor = inorder.toArray(new Integer[inLen]);
		Integer[] preor = preorder.toArray(new Integer[preLen]);

		return construct(preor, 0, preLen - 1, inor, 0, inLen - 1);
	}

	public static TreeNode construct(Integer[] preorder, int preStart,
			int preEnd, Integer[] inorder, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		int val = preorder[preStart];
		TreeNode p = new TreeNode(val);

		// find parent element index from inorder
		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (val == inorder[i]) {
				k = i;
				break;
			}
		}

		p.left = construct(preorder, preStart + 1, preStart + (k - inStart),
				inorder, inStart, k - 1);
		p.right = construct(preorder, preStart + (k - inStart) + 1, preEnd,
				inorder, k + 1, inEnd);

		return p;
	}
}
