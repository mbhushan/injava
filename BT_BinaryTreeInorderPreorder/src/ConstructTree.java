import java.util.Stack;


class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int value) {
		this.left = null;
		this.right = null;
		this.value = value;
	}
}

public class ConstructTree {
	private TreeNode root = null;
	
	public static void main(String [] args) {
		ConstructTree CT = new ConstructTree();
		
		int [] inorder = {4, 2, 5, 1, 6, 7, 3, 8};
		int [] preorder = {1, 2, 4, 5, 3, 7, 6, 8};
		
		CT.buildTree(inorder, preorder);
		System.out.println("preorder: ");
		CT.preorder();
		System.out.println("postorder: ");
		CT.postorder();
	}
	
	public void postorder() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		stack.push(node);
		
		while (!stack.isEmpty()) {
			TreeNode curr = stack.peek();
			if (curr.left == null && curr.right == null) {
				System.out.print(stack.pop().value + " ");
			} else {
				if (curr.right != null) {
					stack.push(curr.right);
					curr.right = null;
				}
				if (curr.left != null) {
					stack.push(curr.left);
					curr.left = null;
				}
			}
		}
		System.out.println();
	}
	
	public void preorder() {
		Stack<TreeNode> stack = new Stack<TreeNode> ();
		TreeNode node = root;
		stack.push(node);
		
		while (!stack.isEmpty()) {
			node = stack.pop();
			System.out.print(node.value + " ");
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		System.out.println();
	}

	public void buildTree(int [] inorder, int [] preorder) {
		int instart = 0;
		int inend = inorder.length - 1;
		int prestart = 0;
		int preend = preorder.length - 1;
	    root = buildTree(inorder, instart, inend, preorder, prestart, preend);
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
}
