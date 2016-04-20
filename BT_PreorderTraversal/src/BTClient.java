
/*
    	      20
        10            30
    5      12   23       35
 3     7
 */
public class BTClient {

	public static void main(String [] args) {
		BinaryTree BT = new BinaryTree();
		int [] A = {20, 10, 30, 5, 12, 23, 35, 3, 7};
		BT.buildBinaryTree(A);
		BT.inorder();
	}
}
