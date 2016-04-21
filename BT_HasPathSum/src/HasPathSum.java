import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
		HPS.inorder();
		System.out.println();
		int [] sums = {38, 43, 86, 42};
		for (int i=0; i<sums.length; i++) {
			System.out.println("has path sum: " + HPS.hasPathSum(sums[i]));
		}
	}
	
	public boolean hasPathSumIter(TreeNode node, int sum) {
		
		Queue<TreeNode> tnode = new LinkedList<TreeNode>();
		Queue<Integer> values = new LinkedList<Integer>();
		
		tnode.add(node);
		values.add(node.value);
		
		while (!tnode.isEmpty()) {
			TreeNode curr = tnode.poll();
			int sumVal = values.poll();
			
			if (curr.left == null && curr.right == null && sumVal == sum) {
				return true;
			}
			if (curr.left != null) {
				tnode.add(curr.left);
				values.add(sumVal + curr.left.value);
			}
			if (curr.right != null) {
				tnode.add(curr.right);
				values.add(sumVal + curr.right.value);
			}
		}
		return false;
	}
	
	public boolean hasPathSum(int sum) {
		if (root == null) {
			return false;
		}
		return hasPathSum(root, sum);
	}
	
	private boolean hasPathSum(TreeNode node, int sum) {
		if (node == null) {
			return false;
		}
		if (node.value == sum  && (node.left == null && node.right == null)) {
			return true;
		}
		return hasPathSum(node.left, sum - node.value) || hasPathSum(node.right, sum - node.value);
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
