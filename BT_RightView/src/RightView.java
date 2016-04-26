import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
	    	      20
	        10            30
	    5      12   23       35
	 3     7
*/

public class RightView {
	
	private TreeNode root = null;
	
	public static void main(String [] args) {
		int [] A = { 20, 10, 30, 5, 12, 23, 35, 3, 7 };
		RightView RV = new RightView();
		RV.buildBST(A);
		
		ArrayList<TreeNode> result = RV.rightView();
		System.out.println("right view of the tree is: ");
		for (TreeNode node : result) {
			System.out.print(node.value + " ");
		}
		System.out.println();
	}
	
	public ArrayList<TreeNode> rightView() {
		
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		TreeNode node = root;
		Queue<TreeNode> Q = new LinkedList<TreeNode>();
		Q.add(node);
		
		while (!Q.isEmpty()) {
			int size = Q.size();
			for (int i=0; i<size; i++) {
				TreeNode top = Q.poll();
				if (i == 0) {
					result.add(top);
				}
				if (top.right != null) {
					Q.add(top.right);
				}
				if (top.left != null) {
					Q.add(top.left);
				}
			}
		}
		return result;
	}
	

	public void buildBST(int [] A) {
		for (int i=0; i<A.length; i++) {
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
