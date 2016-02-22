package i_LevelOrderBT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BinaryTree {

	private static TreeNode root;
	
	 public static void main(String args[]) {
		 BinaryTree tree = new BinaryTree();
	        tree.root = new TreeNode(10);
	        tree.root.left = new TreeNode(2);
	        tree.root.right = new TreeNode(10);
	        tree.root.left.left = new TreeNode(20);
	        tree.root.left.right = new TreeNode(1);
	        tree.root.right.right = new TreeNode(-25);
	        tree.root.right.right.left = new TreeNode(3);
	        tree.root.right.right.right = new TreeNode(4);
	        
	        ArrayList<ArrayList<Integer>> result =  levelOrder(root);
	        for (ArrayList<Integer> r: result) {
	        	System.out.println(r);
	        }
	    }
	 
		public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode node) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			if (node == null) {
				return result;
			}
			TreeNode marker = new TreeNode(Integer.MIN_VALUE);
			Queue<TreeNode> Q = new LinkedList<TreeNode>();
			Q.add(node);
			Q.add(marker);
			
			ArrayList<Integer> A = new ArrayList<Integer>();
			while (!Q.isEmpty()) {
				TreeNode tmp = Q.remove();
				if (tmp.equals(marker)) {
					//System.out.println();
					result.add(A);
					A = new ArrayList<Integer>();
					if (!Q.isEmpty()) {
						Q.add(marker);
					}
				} else {
					//System.out.print(tmp.val + " ");
					A.add(tmp.val);
					if (tmp.left != null) {
						Q.add(tmp.left);
					}
					if (tmp.right != null) {
						Q.add(tmp.right);
					}
				}
				
			}
			return result;
		}
}
