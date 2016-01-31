package i_BT_BinaryTree;

import java.util.LinkedList;

public class BinaryTreeClient {

	private static TreeNode root;

	public static void main(String[] args) {
		int[] A = { 12, 9, 15, 13, 20, 14, 25, 30 };
		BinaryTree bt = new BinaryTree();

		int len = A.length;
		for (int i = 0; i < len; i++) {
			bt.insertIntoBST(A[i]);
		}
		
		root = bt.getRootNode();
		System.out.println("max depth: " + maxDepth(root));
		System.out.println("min depth: " + minDepth1(root));
		System.out.println("min depth: " + minDepth(root));
		System.out.println("min depth: " + minDepth2(root));
	}
	
	public static int minDepth2(TreeNode a) {
        if(a == null){
            return 0;
        }
 
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> counts = new LinkedList<Integer>();
 
        nodes.add(a);
        counts.add(1);
 
        while(!nodes.isEmpty()){
            TreeNode curr = nodes.remove();
            int count = counts.remove();
 
            if(curr.left != null){
                nodes.add(curr.left);
                counts.add(count+1);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                counts.add(count+1);
            }
 
            if(curr.left == null && curr.right == null){
                return count;
            }
        }
 
        return 0;
    }
	
	public static int minDepth(TreeNode a) {
		if (a == null) {
			return 0;
		}
		if (a.left == null && a.right == null) {
			return 1;
		}
		if (a.left == null) {
			return minDepth(a.right) + 1;
		}
		if (a.right == null) {
			return minDepth(a.left) + 1;
		}
		return Math.min(minDepth(a.left), minDepth(a.right)) + 1;
	}
	
	public static int maxDepth(TreeNode a) {
		if (a == null) {
			return 0;
		}
		int left = maxDepth(a.left);
		int right = maxDepth(a.right);
		
		return Math.max(left, right) + 1;
	}
	
	public static int minDepth1(TreeNode a) {
		return minDepthBT(a, 0);
	}
	
	public static int minDepthBT(TreeNode node, int depth) {
		if (node == null){
			return depth;
		} 
		if (node.left == null && node.right == null) { return depth+1; }
		   
		  int x = node.left != null ? minDepthBT(node.left, depth+1) : depth;
		  int y = node.right != null ? minDepthBT(node.right, depth+1): depth;
		   
		  return (x > y) ? y : x;
		
	}
}
