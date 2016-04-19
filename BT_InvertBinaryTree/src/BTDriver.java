
public class BTDriver {

	public static void main(String [] args) {
		BinaryTree<Integer> BT = new BinaryTree<Integer>();
		
		Integer [] A = {20, 10, 30, 5, 15, 25, 35};
		BT.buildBinaryTree(A);
		BT.printBinaryTree();
		System.out.println();
		System.out.println("inverting binary tree - recursively");
		BT.invertBT();
		BT.printBinaryTree();
		System.out.println();
		System.out.println("inverting binary tree - iteratively");
		BT.invertBT();
		BT.printBinaryTree();
	}
}
