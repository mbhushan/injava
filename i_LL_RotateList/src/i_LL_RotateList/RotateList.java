package i_LL_RotateList;

public class RotateList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		int[] A = { 5, 3, 2, 1, 4 };

		int n = A.length;
		for (int i = n - 1; i >= 0; i--) {
			list.insertFront(A[i]);
		}
		list.printList();
		ListNode root = list.getHeadNode();
		int k = 2;
		ListNode node = rotateRight(root, k);
		printList(node);
	}

	public static void printList(ListNode head) {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + " -> ");
			curr = curr.next;
		}
		System.out.println("null");
	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0) {
			return head;
		}

		ListNode ptr = head;
		int len = 0;
		while (ptr != null) {
			++len;
			ptr = ptr.next;
		}

		// getting rotated position
		int pos = 0;
		if (k % len == 0) {
			return head;
		} else {
			pos = len - (k % len) - 1;
		}

		ptr = head;
		while (pos > 0) {
			ptr = ptr.next;
			pos--;
		}

		ListNode qtr = ptr.next;
		if (qtr == null) {
			return head;
		}
		while (qtr.next != null) {
			qtr = qtr.next;
		}
		qtr.next = head;
		qtr = ptr.next;
		ptr.next = null;

		return qtr;
	}
}
