package fx_SuccessorPredecessorBST;

/*
			8
	3				10
1		6				14
	4		7		13
*/
public class SuccessorPredecessor {

	private TreeNode root = null; 

	public static void main(String[] args) {
		SuccessorPredecessor SP = new SuccessorPredecessor();
		
		int [] A = {8, 3, 10, 1, 6, 14, 4, 7, 13};
		int x = 4;
		
		SP.buildBST(A);

		for (int i=0; i<A.length; i++) {
			TreeNode node = SP.findNode(A[i]);
			//TreeNode p = SP.inorderSuccessor(node);
			TreeNode p = SP.inorderSuccessorNoParentPtr(node);
			if (p == null) {
				System.out.println("successor of " + A[i] + " is: " + "null");
				continue;
			}
			System.out.println("successor of " + A[i] + " is: " + p.value);
		}
		System.out.println("");
		
		//predecessors of BST nodes.
		System.out.println("predecessors of BST nodes: ");
		for (int i=0; i<A.length; i++) {
			TreeNode node = SP.findNode(A[i]);
			TreeNode p = SP.inorderPredecessor(node);
			if (p == null) {
				System.out.println("predecessor of " + A[i] + " is: " + "null");
				continue;
			}
			System.out.println("predecessor of " + A[i] + " is: " + p.value);
		}
	}
	
	public TreeNode inorderPredecessor(TreeNode node) {
		if (node.left != null) {
			return maxValue(node.left);
		}
		
		TreeNode pr = node.parent;
		while (pr != null && pr.left != null && pr.left.equals(node)) {
			node = pr;
			pr = pr.parent;
		}
		return pr;
	}
	
	public TreeNode inorderPredecessorNoParentPtr(TreeNode node) {
		if (node.left != null) {
			return maxValue(node.left);
		}
		
		TreeNode curr = root;
		TreeNode pred = null;
		while (curr != null) {
			if (node.value < curr.value) {
				curr = curr.left;
			} else if (node.value > curr.value) {
				pred = curr;
				curr = curr.right;
			} else {
				break;
			}
		}
		return pred;
	}
	
	private TreeNode maxValue(TreeNode node) {
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}
	public TreeNode inorderSuccessorNoParentPtr(TreeNode node) {
		if (node.right != null) {
			return minValue(node.right);
		}
		TreeNode curr = root;
		TreeNode succ = null;
		while (curr != null) {
			if (node.value < curr.value) {
				succ = curr;
				curr = curr.left;
			} else if (node.value > curr.value) {
				curr = curr.right;
			} else {
				break;
			}
		}
		return succ;
	}
	
	public TreeNode inorderSuccessor(TreeNode node) {
		if (node.right != null) {
			return minValue(node.right);
		}
		TreeNode prnt = node.parent;
		while (prnt != null && prnt.right != null && prnt.right.equals(node)) {
			node = prnt;
			prnt = prnt.parent;
		}
		
		return prnt;
	}
	
	private TreeNode minValue(TreeNode node) {
		TreeNode curr = node;
		while (curr.left != null) {
			curr = curr.left;
		}
		return curr;
	}
	
	public TreeNode findNode(int x) {
		return findNode(root, x);
	}
	
	private TreeNode findNode(TreeNode node, int x) {
		if (node == null) {
			return null;
		}
		
		if (node.value == x) {
			return node;
		} else if (x < node.value) {
			return findNode(node.left, x);
		} else if (x > node.value){
			return findNode(node.right, x);
		}
		return null;
	}
	
	public void buildBST(int [] A) {
		if (A == null) { 
			return;
		}
		
		for (int i=0; i<A.length; i++) {
			root = insertIntoBST(root, A[i]);
		}
	}
	
	private TreeNode insertIntoBST(TreeNode node, int val) {
		if (node == null) {
			return new TreeNode(val);
		}
		
		if (val < node.value) {
			node.left = insertIntoBST(node.left, val);
			node.left.parent = node;
		} else if (val > node.value) {
			node.right = insertIntoBST(node.right, val);
			node.right.parent = node;
		}
		return node;
	}
}

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	
	public TreeNode(int x) {
		this.value = x;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}