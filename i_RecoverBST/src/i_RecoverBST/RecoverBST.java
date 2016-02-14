package i_RecoverBST;

import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class RecoverBST {

	private static TreeNode pre = null;
	private static TreeNode first = null;
	private static TreeNode second = null;

	public static ArrayList<Integer> recoverTree(TreeNode a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		inOrder(a);
		if (first != null && second != null) {
			result.add(second.val);
			result.add(first.val);
		}
		return result;
	}

	private static void inOrder(TreeNode root) {
		if (root == null) {
			return;
		} else {
			inOrder(root.left);
			if (pre == null) {
				pre = root;
			} else {
				if (pre.val > root.val) {
					if (first == null) {
						first = pre;
					}
					second = root;
				}
				pre = root;
			}
			inOrder(root.right);

		}
	}
}
