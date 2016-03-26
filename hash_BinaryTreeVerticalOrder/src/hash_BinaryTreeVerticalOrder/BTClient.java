package hash_BinaryTreeVerticalOrder;

public class BTClient {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		int [] A = {6, 3, 9, 1, 5, 7, 11, 4};
		for (int i=0; i<A.length; i++) {
			bt.insertBinaryTree(A[i]);
		}
		System.out.println("printing binary tree: ");
		bt.inorder();
		System.out.println("printing vertical order: ");
		bt.verticalTraversal();
	}
}
