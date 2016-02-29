package i_UniqueBSTs;

import java.util.ArrayList;
import java.util.LinkedList;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class UniqueBST {
	
	public static void main(String[] args) {
		int a = 4;
		ArrayList<TreeNode> R = generateTrees(a);
		for (TreeNode r: R) {
			System.out.print(r.val + " ");
		}
		System.out.println();
	}

	public static ArrayList<TreeNode> generateTrees(int a) {
		return generateTrees(1, a);
	}
	
	
	public static ArrayList<TreeNode> generateTrees(int start, int end) {
	    ArrayList<TreeNode> list = new ArrayList<TreeNode>();
	 
	    if (start > end) {
	        list.add(null);
	        return list;
	    }
	 
	    for (int i = start; i <= end; i++) {
	        ArrayList<TreeNode> lefts = generateTrees(start, i - 1);
	        ArrayList<TreeNode> rights = generateTrees(i + 1, end);
	        for (TreeNode left : lefts) {
	            for (TreeNode right : rights) {
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
