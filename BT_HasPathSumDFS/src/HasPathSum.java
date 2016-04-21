import java.util.ArrayList;


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
public class HasPathSum {
	
	private TreeNode root = null;

	/*
	    	      20
	        10            30
	    5      12   23       35
	 3     7
	*/
		public static void main(String[] args) {
			HasPathSum HPS = new HasPathSum();
			int[] A = { 20, 10, 30, 5, 12, 23, 35, 3, 7 };
			HPS.buildBST(A);
			
			ArrayList<ArrayList<Integer>> result = HPS.pathSum(42);
			for (ArrayList<Integer> R: result) {
				for (Integer i: R) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}

	public ArrayList<ArrayList<Integer>> pathSum(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(root.value);
		dfs(root, sum-root.value, result, list);
		
		return result;
	}
	
	private void dfs(TreeNode node, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
		if (node.left == null && node.right == null && sum == 0) {
			ArrayList<Integer> nlist = new ArrayList<Integer>();
			nlist.addAll(list);
			result.add(nlist);
		}
		//lets search the left node
		if (node.left != null) {
			list.add(node.left.value);
			dfs(node.left, sum-node.left.value, result, list);
			list.remove(list.size()-1);
		}
		//lets search the right node
		if (node.right != null) {
			list.add(node.right.value);
			dfs(node.right, sum-node.right.value, result, list);
			list.remove(list.size()-1);
		}
	}
	
	public void buildBST(int[] A) {
		if (null == A) {
			return;
		}
		int len = A.length;
		for (int i = 0; i < len; i++) {
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
