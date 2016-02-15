package i_CartesianTree;

import java.util.ArrayList;
import java.util.Collections;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class CartesianTree {
	
	public static void main(String[] args) {
        Integer [] inorder = {5, 10, 40, 30, 28};
        ArrayList<Integer> A = new ArrayList<Integer>();
        Collections.addAll(A, inorder);
        TreeNode node = buildTree(A);
 
        /* Let us test the built tree by printing Insorder traversal */
        System.out.println("Inorder traversal of the constructed tree is ");
        printInorder(node);
        System.out.println();
	}

	 static void printInorder(TreeNode node) {
	        if (node == null) {
	            return;
	        }
	 
	        /* first recur on left child */
	        printInorder(node.left);
	 
	        /* then print the data of node */
	        System.out.print(node.val + " ");
	 
	        /* now recur on right child */
	        printInorder(node.right);
	    }
	public static TreeNode buildTree(ArrayList<Integer> a) {
		int N = a.size();
		TreeNode node = null;
		Integer [] inorder = a.toArray(new Integer[N]);
		node = buildCartesianTree(inorder, 0, N-1, node);
		return node;
		
		
    }
	
	private static TreeNode buildCartesianTree(Integer [] inorder, int start, int end, TreeNode node) {
		if (start > end) {
			return null;
		}
		
		int maxIndex = findMax(inorder, start, end);
		node = new TreeNode(inorder[maxIndex]);
		
		if (start == end) {
			return node;
		}
		
		node.left = buildCartesianTree(inorder, start, maxIndex-1, node.left);
		node.right = buildCartesianTree(inorder, maxIndex+1, end, node.right);

		return node;
	}
	
	private static int findMax(Integer arr[], int strt, int end) {
        int i, max = arr[strt], maxind = strt;
        for (i = strt + 1; i <= end; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxind = i;
            }
        }
        return maxind;
    }
}
