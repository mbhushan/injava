import java.util.Stack;

//  Definition for singly-linked list.
class ListNode {
	int value;
	ListNode next;
 
	ListNode(int x) {
		value = x;
		next = null;
	}
}
 
// Definition for binary tree
class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
 
	TreeNode(int x) {
		value = x;
	}
}

public class SortedListBST {

	private static ListNode lnode;
	
	private static ListNode head = null;
	private static TreeNode root = null;
	
	public static void main(String [] args) {
		int [] A = {7,6,5,4,3,2,1};
		SortedListBST BST = new SortedListBST();
		BST.buildList(A);
		BST.printList();
		root = BST.sortedListToBST(head);
		System.out.println("preorder traversal: ");
		BST.preorder(root);
		
	}
	
	public void preorder(TreeNode node) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
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
	
	public void printList() {
		for (ListNode node=head; node != null; node=node.next) {
			System.out.print(node.value + " -> ");
		}
		System.out.println("null");
	}
	
	
	public void buildList(int [] A) {
		if (A == null || A.length < 1) {
			return;
		}
		for (int i=0; i<A.length; i++) {
			ListNode node = new ListNode(A[i]);
			node.next = head;
			head = node;
		}
	}
	
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		lnode = head;
		int len = getListLength(head);
		return sortedListTree(0, len-1);
	}
	
	private TreeNode sortedListTree(int low, int high) {
		if (low > high) {
			return null;	
		}
		int mid = low + (high - low)/2;
		TreeNode left = sortedListTree(low, mid-1);
		TreeNode node = new TreeNode(lnode.value);
		lnode = lnode.next;
		TreeNode right = sortedListTree(mid+1, high);
		
		node.left = left;
		node.right = right;
		return node;
	}
	
	private int getListLength(ListNode head) {
		int len = 0;
		ListNode node = head;
		while (node != null) {
			++len;
			node = node.next;
		}
		return len;
	} 
}
