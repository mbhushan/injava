package i_ListToBST;


class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class ListBST {

	private static ListNode h;
	private static TreeNode root;

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		
		root = sortedListToBST(head);
		inorder(root);

	}
	
	public static void inorder(TreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			inorder(node.left);
		}
		System.out.print(node.val + " ");
		if (node.right != null) {
			inorder(node.right);
		}
	}

	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;

		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}

	// get list length
	public static int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;

		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}

	// build tree bottom-up
	public static TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;

		// mid
		int mid = (start + end) / 2;

		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);

		root.left = left;
		root.right = right;

		return root;
	}

}
