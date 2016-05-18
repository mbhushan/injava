

public class BinaryTree {
	private TreeNode root;
	
	public BinaryTree() {
		root = null;
	}

	public int largestBST() {
		MinMax node = findLargest(root);
		return node.size;
	}
	
	private MinMax findLargest(TreeNode node) {
		if (node == null) {
			return new MinMax();
		}
		
		MinMax left = findLargest(node.left);
		MinMax right = findLargest(node.right);
		
		MinMax mm = new MinMax();
		if (!left.isBST || !right.isBST || (left.max > node.value) || (right.min <= node.value)) {
			mm.isBST = false;
			mm.size = Math.max(left.size, right.size);
			return mm;
		}
		
		mm.isBST = true;
		mm.size = left.size + right.size + 1;
		mm.min = node.left != null ? left.min : node.value;
		mm.max = node.right != null ? right.max : node.value;
		
		return mm;
	}
	
	private TreeNode buildTree(int [] inorder, int instart, int inend, int [] preorder, int prestart, int preend) {
		if (prestart > preend || instart > inend) {
			return null;
		}
		
		int rootValue = preorder[prestart];
		TreeNode node = new TreeNode(rootValue);
		
		int k = 0;
		for (int i=instart; i<=inend; i++) {
			if (inorder[i] == rootValue) {
				k = i;
				break;
			}
		}
		
		node.left = buildTree(inorder, instart, k-1, preorder,  prestart+1, prestart + (k - instart));
		node.right = buildTree(inorder, k+1, inend, preorder,  prestart + (k - instart) + 1, preend);
		return node;
	}
	
	public void createTree(int [] inorder, int [] preorder) {
		this.root = buildTree(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
	}

	public static void main(String[] args) {
		BinaryTree BT = new BinaryTree();

		int inorder[]  = {-7,-6,-5,-4,-3,-2,1,2,3,16,6,10,11,12,14};
        int preorder[] = {3,-2,-3,-4,-5,-6,-7,1,2,16,10,6,12,11,14};
        
        BT.createTree(inorder, preorder);
        System.out.println("largest BST: " + BT.largestBST());
	}
	
	
}

class MinMax {
	int min;
	int max;
	boolean isBST;
	int size;
	
	public MinMax() {
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		isBST = true;
		size = 0;
	}
}

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}
