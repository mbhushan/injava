
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

/*
 * 20 10 30 5 12 23 35 3 7
 */
public class LowestCommonAncestor {
	private TreeNode root = null;

	public static void main(String[] args) {
		LowestCommonAncestor BT = new LowestCommonAncestor();
		int[] A = { 20, 10, 30, 5, 12, 23, 35, 3, 7 };

		BT.buildBST(A);
		TreeNode first = new TreeNode(3);
		TreeNode second = new TreeNode(12);
		TreeNode lca = BT.lowestCommonAncestor(first, second);
		if (lca != null)
			System.out.println("lca: " + lca.value);
		else {
			System.out.println("lca: null");
		}

	}

	public TreeNode lowestCommonAncestor(TreeNode p, TreeNode q) {
		return lowestCommonAncestor(root, p, q);
	}

	private TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
		if (node == null || node.equals(p) || node.equals(q))
			return node;
		TreeNode left = lowestCommonAncestor(node.left, p, q);
		TreeNode right = lowestCommonAncestor(node.right, p, q);
		if (left != null && right != null)
			return node;
		return left == null ? right : left;
	}

	public TreeNode lca(TreeNode first, TreeNode second) {
		return lca(root, first, second);
	}

	private TreeNode lca(TreeNode node, TreeNode first, TreeNode second) {
		if (node.value >= first.value && node.value < second.value) {
			return node;
		} else if (node.value >= first.value && node.value >= second.value) {
			return lca(node.left, first, second);
		} else if (node.value < first.value && node.value < second.value) {
			return lca(node.right, first, second);
		}
		return node;
	}

	public void buildBST(int[] A) {
		for (int i = 0; i < A.length; i++) {
			root = insertIntoBST(root, A[i]);
		}
	}

	private TreeNode insertIntoBST(TreeNode node, int key) {
		if (node == null) {
			return new TreeNode(key);
		}
		if (key <= node.value) {
			node.left = insertIntoBST(node.left, key);
		} else {
			node.right = insertIntoBST(node.right, key);
		}
		return node;

	}

}
