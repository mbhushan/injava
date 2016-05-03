import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

public class BSTGeneration {
	
	public static void main(String [] args) {
		BSTGeneration BT = new BSTGeneration();
		int n = 3;
		List<TreeNode> result = BT.generateTrees(n);
		for (TreeNode r: result) {
			BT.preorder(r);
			System.out.println();
		}
	}
	
	private void preorder(TreeNode node) {
		if (node == null) {
			return;
		}
		
		System.out.print(node.value + " ");
		
		if (node.left != null) {
			inorder(node.left);
		}
		
		if (node.right != null) {
			inorder(node.right);
		}
	}
	
	
	private void inorder(TreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			inorder(node.left);
		}
		System.out.print(node.value + " ");
		if (node.right != null) {
			inorder(node.right);
		}
		
	}
	public List<TreeNode> generateTrees(int n) {
		return generateTree(1, n);
	}

	public ArrayList<TreeNode> generateTree(int start, int end) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		
		if (start > end) {
			list.add(null);
			return list;
		}
		
		for (int i=start; i<=end; i++) {
			List<TreeNode> lefts = generateTree(start, i-1);
			List<TreeNode> rights = generateTree(i+1, end);
			for (TreeNode left: lefts) {
				for (TreeNode right: rights) {
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;
					list.add(node);
				}
			}
		}
		return list;
	}
}
