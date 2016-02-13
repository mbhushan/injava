package i_BTree2Sum;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BTreeSum {

	public static int t2Sum(TreeNode A, int B) {
		Stack<TreeNode> instack = new Stack<TreeNode>();
		Stack<TreeNode> revInStack = new Stack<TreeNode>();

		int done1 = 0, done2 = 0;
		int val1 = 0, val2 = 0;
		TreeNode curr1 = A;
		TreeNode curr2 = A;
		
		while (true) {
			
			while (done1 == 0) {
				if (curr1 != null) {
					instack.push(curr1);
					curr1 = curr1.left;
				} else {
					if (!instack.isEmpty()) {
						curr1 = instack.pop();
						val1 = curr1.val;
						curr1 = curr1.right;
						
					} 
					done1 = 1;
				}
			}
			
			while (done2 == 0) {
				if (curr2 != null) {
					revInStack.push(curr2);
					curr2 = curr2.right;
				} else {
					if (!revInStack.isEmpty()) {
						curr2 = revInStack.pop();
						val2 = curr2.val;
						curr2 = curr2.left;
					}
					done2 = 1;
				}
			}
			
			if ((val1 != val2) && (val1 + val2) == B) {
				System.out.println("val1: val2 = " + val1 + ": " + val2);
	            return 1;
	        } else if ((val1 + val2) < B) {
	        	done1 = 0;
	        } else if ((val1 + val2) > B) {
	        	done2 = 0;
	        }
			if (val1 >= val2) {
				return 0;
			}
		}
	}
}
