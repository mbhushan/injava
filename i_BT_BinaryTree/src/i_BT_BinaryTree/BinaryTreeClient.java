package i_BT_BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeClient {

	private static TreeNode root;

	public static void main(String[] args) {
		// int[] A = { 12, 9, 15, 13, 20, 14, 25, 30 };
		int[] A = { 10, 5, 15, 2, 7, 12, 18 };
		BinaryTree bt = new BinaryTree();

		int len = A.length;
		for (int i = 0; i < len; i++) {
			bt.insertIntoBST(A[i]);
		}

		root = bt.getRootNode();
		// System.out.println("max depth: " + maxDepth(root));
		// System.out.println("min depth: " + minDepth1(root));
		// System.out.println("min depth: " + minDepth(root));
		System.out.println("min depth: " + minDepth2(root));
		ArrayList<Integer> R = inorderTraversal(root);
		// R = postorderIterative(root);
		// R = preOrderIterative(root);
		for (Integer r : R) {
			System.out.print(r + " ");
		}
		System.out.println();

		root = invertBinaryTree(root);
		R = inorderTraversal(root);
		for (Integer r : R) {
			System.out.print(r + " ");
		}
		System.out.println();

		printSpiralLevelOrder(root);

	}
	
	public static int lca(TreeNode a, int n1, int n2) {
		
		// Initialize n1 and n2 as not visited
        boolean v1 = false, v2 = false;
 
        // Find lca of n1 and n2 using the technique discussed above
        TreeNode lca = findLCAUtil(a, v1, v2, n1, n2);
 
        // Return LCA only if both n1 and n2 are present in tree
        if (v1 && v2 || v1 && find(lca, n2) || v2 && find(lca, n1)) {
            return lca.val;
        }
 
        // Else return NULL
        return -1;
	}
	
	// This function returns pointer to LCA of two given values n1 and n2.
    // v1 is set as true by this function if n1 is found
   // v2 is set as true by this function if n2 is found
   private static TreeNode findLCAUtil(TreeNode node, boolean v1, boolean v2, int n1, int n2) {
        // Base case
        if (node == null) {
            return null;
        }
 
        // If either n1 or n2 matches with root's key, report the presence
        // by setting v1 or v2 as true and return root (Note that if a key
        // is ancestor of other, then the ancestor key becomes LCA)
        if (node.val == n1) {
            v1 = true;
            return node;
        }
        if (node.val == n2) {
            v2 = true;
            return node;
        }
 
        // Look for keys in left and right subtrees
        TreeNode left_lca = findLCAUtil(node.left, v1, v2, n1, n2);
        TreeNode right_lca = findLCAUtil(node.right, v1, v2, n1, n2);
 
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null) {
            return node;
        }
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }
	
	 // Returns true if key k is present in tree rooted with root
    public static boolean find(TreeNode node, int k) {
        // Base Case
        if (root == null) {
            return false;
        }
 
        // If key is present at root, or in left subtree or right subtree,
        // return true;
        if (node.val == k || find(node.left, k) || find(node.right, k)) {
            return true;
        }
 
        // Else return false
        return false;
    }

	public static ArrayList<ArrayList<Integer>>  printSpiralLevelOrder(TreeNode node) {
		if (node == null) {
			return null;
		}
		Stack<TreeNode> stackOne = new Stack<TreeNode>();
		Stack<TreeNode> stackTwo = new Stack<TreeNode>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		stackOne.add(node);

		ArrayList<Integer> row = new ArrayList<Integer>();
		while (!stackOne.isEmpty() || !stackTwo.isEmpty()) {
			
			while (!stackOne.isEmpty()) {
				TreeNode temp = stackOne.pop();
				//System.out.print(temp.val + " ");
			    row.add(temp.val);	
				if (temp.left != null) {
					stackTwo.push(temp.left);
				}
				if (temp.right != null) {
					stackTwo.push(temp.right);
				}
			}
			if (row.size() > 0) {
				result.add(row);
				row = new ArrayList<Integer>();
			}
			//System.out.println();
			while (!stackTwo.isEmpty()) {
				TreeNode temp = stackTwo.pop();
				//System.out.print(temp.val + " ");
				row.add(temp.val);
				if (temp.right != null) {
					stackOne.push(temp.right);
				}
				if (temp.left != null) {
					stackOne.push(temp.left);
				}
			}
			if (row.size() > 0) {
				result.add(row);
				row = new ArrayList<Integer>();
			}
			//System.out.println();
		}
		System.out.println("printing result for spiral order:");
		for (ArrayList<Integer> R : result) {
			System.out.println(R);
		}
		
		return result;
		
	}

	public static void spiralLevelOrder(TreeNode node) {
		Stack<TreeNode> S1 = new Stack<TreeNode>();
		Stack<TreeNode> S2 = new Stack<TreeNode>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		S1.push(node);
		spiralLevelOrderRecur(S1, S2, 1, result);
		System.out.println("printing arraylist:");
		for (ArrayList<Integer> R : result) {
			System.out.println(R);
		}
	}

	private static void spiralLevelOrderRecur(Stack<TreeNode> S1,
			Stack<TreeNode> S2, int level, ArrayList<ArrayList<Integer>> result) {
		ArrayList<Integer> row = new ArrayList<Integer>();
		while (!S1.isEmpty()) {
			TreeNode node = S1.pop();

			if (node != null) {
				row.add(node.val);
				// System.out.print(node.val +" ");
			} else {
				return;
			}

			int p = level % 2;
			if (p == 1) {
				S2.push(node.right);
				S2.push(node.left);
			} else {
				S2.push(node.left);
				S2.push(node.right);
			}

		}
		// System.out.println();
		result.add(row);
		if (!S2.isEmpty()) {
			spiralLevelOrderRecur(S2, S1, level + 1, result);
		}
	}

	// public int hasPathSum(TreeNode a, int b) {
	// if(checkPathSum(a, b)) {
	// return 1;
	// }
	// return 0;
	// }

	boolean haspathSum(TreeNode node, int sum) {
		if (node == null) {
			return (sum == 0);
		} else {
			boolean ans = false;

			/* otherwise check both subtrees */
			int subsum = sum - node.val;
			if (subsum == 0 && node.left == null && node.right == null) {
				return true;
			}
			if (node.left != null) {
				ans = ans || haspathSum(node.left, subsum);
			}
			if (node.right != null) {
				ans = ans || haspathSum(node.right, subsum);
			}
			return ans;
		}
	}

	public static boolean checkPathSum(TreeNode a, int b) {
		if (a == null) {
			return b == 0;
		} else {
			b = b - a.val;
			return (checkPathSum(a.left, b) || checkPathSum(a.right, b));
		}

	}

	public static TreeNode sortedArrayToBST(final List<Integer> a) {
		if (a == null) {
			return null;
		}
		int start = 0;
		int end = a.size() - 1;
		return sortedArrayToBST(a, start, end);
	}

	private static TreeNode sortedArrayToBST(List<Integer> A, int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(A.get(mid).intValue());
		node.left = sortedArrayToBST(A, start, mid - 1);
		node.right = sortedArrayToBST(A, mid + 1, end);
		return node;
	}

	public static int isSymmetric(TreeNode a) {
		if (a == null) {
			return 1;
		}
		if (isSymmetric(a.left, a.right)) {
			return 1;
		}
		return 0;
	}

	public static boolean isSymmetric(TreeNode l, TreeNode r) {
		if (l == null && r == null) {
			return true;
		} else if (r == null || l == null) {
			return false;
		}

		if (l.val != r.val)
			return false;

		if (!isSymmetric(l.left, r.right))
			return false;
		if (!isSymmetric(l.right, r.left))
			return false;

		return true;
	}

	public static TreeNode invertBinaryTree(TreeNode node) {
		if (node == null) {
			return node;
		}
		node.left = invertBinaryTree(node.left);
		node.right = invertBinaryTree(node.right);
		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;
		return node;
	}

	public static ArrayList<Integer> preOrderIterative(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> values = new ArrayList<Integer>();

		while (node != null || !stack.isEmpty()) {
			if (null == node) {
				node = stack.pop();
			}

			// System.out.print(node.data + " -> ");
			values.add(node.val);

			if (node.right != null) {
				stack.push(node.right);
			}
			node = node.left;
		}
		return values;
	}

	public static ArrayList<Integer> postorderIterative(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> values = new ArrayList<Integer>();

		while (node != null || !stack.isEmpty()) {

			if (node == null) {
				while (!stack.isEmpty() && (node == stack.peek().right)) {
					node = stack.pop();
					// System.out.print(node.data + " -> ");
					values.add(node.val);
				}
				node = stack.isEmpty() ? null : stack.peek().right;
			}
			if (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return values;
	}

	public static ArrayList<Integer> inorderTraversal(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> values = new ArrayList<Integer>();

		while (node != null || !stack.isEmpty()) {

			if (null == node) {
				node = stack.pop();
				// System.out.print(node.val + " -> ");
				values.add(node.val);
				node = node.right;
			}
			if (node != null) {
				stack.push(node);
				node = node.left;
			}

		}

		return values;
	}

	public static int minDepth2(TreeNode a) {
		if (a == null) {
			return 0;
		}

		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		LinkedList<Integer> counts = new LinkedList<Integer>();

		nodes.add(a);
		counts.add(1);

		while (!nodes.isEmpty()) {
			TreeNode curr = nodes.remove();
			int count = counts.remove();

			if (curr.left != null) {
				nodes.add(curr.left);
				counts.add(count + 1);
			}

			if (curr.right != null) {
				nodes.add(curr.right);
				counts.add(count + 1);
			}

			if (curr.left == null && curr.right == null) {
				return count;
			}
		}

		return 0;
	}

	public static int minDepth(TreeNode a) {
		if (a == null) {
			return 0;
		}
		if (a.left == null && a.right == null) {
			return 1;
		}
		if (a.left == null) {
			return minDepth(a.right) + 1;
		}
		if (a.right == null) {
			return minDepth(a.left) + 1;
		}
		return Math.min(minDepth(a.left), minDepth(a.right)) + 1;
	}

	public static int maxDepth(TreeNode a) {
		if (a == null) {
			return 0;
		}
		int left = maxDepth(a.left);
		int right = maxDepth(a.right);

		return Math.max(left, right) + 1;
	}

	public static int minDepth1(TreeNode a) {
		return minDepthBT(a, 0);
	}

	public static int minDepthBT(TreeNode node, int depth) {
		if (node == null) {
			return depth;
		}
		if (node.left == null && node.right == null) {
			return depth + 1;
		}

		int x = node.left != null ? minDepthBT(node.left, depth + 1) : depth;
		int y = node.right != null ? minDepthBT(node.right, depth + 1) : depth;

		return (x > y) ? y : x;

	}
}
