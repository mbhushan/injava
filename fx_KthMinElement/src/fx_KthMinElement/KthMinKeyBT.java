package fx_KthMinElement;

import java.util.Stack;

public class KthMinKeyBT {

	public TreeNode root;
	
	public KthMinKeyBT() {
		root = null;
	}
	
	public void buildBST(int [] A) {
		for (int i=0; i<A.length; i++) {
			root = insertIntoBST(root, A[i]);
		}
	}
	
	private TreeNode insertIntoBST(TreeNode node, int data) {
		if (node == null) {
			return new TreeNode(data);
		}
		
		if (data <= node.value) {
			node.left = insertIntoBST(node.left, data);
		} else {
			node.right = insertIntoBST(node.right, data);
		}
		return node;
	}
	
	public static void main(String[] args) {
		KthMinKeyBT BT = new KthMinKeyBT();
		
		int [] A = {20, 8, 22, 4, 12, 10, 14};
		BT.buildBST(A);
		int K = 3;
		System.out.println(K + " min element: " + BT.kthMin(K));
		
	}
	
	public Integer  kthMin(int K) {
		return kthMinElement(root, K);
	}
	
	private Integer kthMinElement(TreeNode node, int K) {
		if (node == null) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int count = 0;
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				++count;
				if (count == K) {
					return node.value;
				}
				node = node.right;
			}
		}
		return null;
	}
}

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