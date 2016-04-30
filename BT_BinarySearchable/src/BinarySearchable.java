import java.util.ArrayList;
import java.util.HashSet;


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
public class BinarySearchable {

	private TreeNode root = null;
	
	public static void main(String [] args) {
		int [] A = {1, 3, 2, 5, 4};
		BinarySearchable BS = new BinarySearchable();
		BS.buildBinaryTree(A);
		BS.inorder();
		BS.preorder();
		BS.getBinarySearchable();
	}
	
	public void getBinarySearchable() {
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		binarySearchable(root, left, right);
		HashSet<Integer> hset = new HashSet<Integer>();
		System.out.println("left values");
		for (Integer val : left) {
			System.out.print(val + " ");
			hset.add(val);
		}
		System.out.println();
		System.out.println("right values:");
		for (Integer val: right) {
			System.out.print(val + " ");
			hset.add(val);
		}
		System.out.println();
		System.out.println("final values which are binary searchable: ");
		for (Integer value: hset) {
			System.out.print(value + " ");
		}
		System.out.println();
		
	}
	
	public void binarySearchable(TreeNode node, ArrayList<Integer> left, ArrayList<Integer> right) {
		if (node == null) {
			return;
		}
		binarySearchable(node.left, left, right);
		binarySearchable(node.right, left, right);
		if (node.left != null) {
			ArrayList<Integer> toRem = new ArrayList<Integer>();
			for (Integer v: left) {
				if (v > node.value) {
					toRem.add(v);
				}
			}
			for (Integer v: toRem) {
				left.remove(v);
			}
			if (node.left.value < node.value) {
				left.add(node.left.value);
				left.add(node.value);
			}
		}
		if (node.right != null) {
			ArrayList<Integer> toRem = new ArrayList<Integer>();
			for (Integer v: right) {
				if (v < node.value) {
					toRem.add(v);
				}
			}
			for (Integer v: toRem) {
				right.remove(v);
			}
			if (node.right.value > node.value) {
				right.add(node.right.value);
				right.add(node.value);
			}
		}
	}
	
	public void preorder() {
		System.out.println("preorder traversal: ");
		preorder(root);
		System.out.println();
	}
	
	private void preorder(TreeNode node) {
		if (node == null) {
			return ;
		}
		System.out.print(node.value + " ");
		
		if (node.left != null) {
			preorder(node.left);
		}
		
		if (node.right != null) {
			preorder(node.right);
		}
	}
	
	public void inorder() {
		System.out.println("inorder traversal: ");
		inorder(root);
		System.out.println();
	}
	
	private void inorder(TreeNode node) {
		if (node == null) {
			return ;
		}
		if (node.left != null) {
			inorder(node.left);
		}
		System.out.print(node.value + " ");
		if (node.right != null) {
			inorder(node.right);
		}
	}
	
	public void buildBinaryTree(int [] A) {
		int len = A.length;
		int low = 0;
		int high = len-1;
		root = binaryTree(A, low, high);
	}
	
	private TreeNode binaryTree(int [] A, int low, int high) {
		if (low > high) {
			return null;
		}
		int mid = low + (high - low)/2;
		TreeNode node = new TreeNode(A[mid]);
		node.left = binaryTree(A, low, mid-1);
		node.right = binaryTree(A, mid+1, high);
		return node;
	}
	
}
