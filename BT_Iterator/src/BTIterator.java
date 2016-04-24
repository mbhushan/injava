import java.util.Stack;

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int value) {
		this.value = value;
		left = null;
		right = null;
	}
}

public class BTIterator {

	Stack<TreeNode> stack;
	
	public BTIterator(TreeNode node) {
		stack = new Stack<TreeNode>();
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	public int next() {
		TreeNode node = stack.pop();
		int result = node.value;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return result;
	}
}
