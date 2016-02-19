package i_LL_ReorderList;

public class ReorderList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		int[] A = { 5, 5, 4, 4, 3, 3, 2, 2, 1, 1 };

		int n = A.length;
		for (int i = n - 1; i >= 0; i--) {
			list.insertFront(A[i]);
		}
		list.printList();
		ListNode root = list.getHeadNode();
		ListNode node = reorderList(root);
		printList(node);
		System.out.println("removing duplicates..");
		list = new LinkedList();
		int[] B = { 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5 };

		n = B.length;
		for (int i = n - 1; i >= 0; i--) {
			list.insertFront(B[i]);
		}
		list.printList();
		root = list.getHeadNode();
		node = deleteDuplicates(root);
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

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode res = new ListNode(0);
		ListNode head = res;
		while (l1 != null && l2 != null) {
			res.next = new ListNode((l1.val + l2.val + carry) % 10);
			carry = (l1.val + l2.val + carry) / 10;
			l1 = l1.next;
			l2 = l2.next;
			res = res.next;
		}

		while (l1 != null) {
			res.next = new ListNode((l1.val + carry) % 10);
			carry = (l1.val + carry) / 10;
			l1 = l1.next;
			res = res.next;
		}

		while (l2 != null) {
			res.next = new ListNode((l2.val + carry) % 10);
			carry = (l2.val + carry) / 10;
			l2 = l2.next;
			res = res.next;
		}

		if (carry > 0) {
			res.next = new ListNode(carry);
		}

		return head.next;
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = new ListNode(-1);
		prev.next = head;
		head = prev;
		ListNode ptr = head;

		while (ptr.next != null) {
			ListNode p2 = ptr.next;
			while ((p2.next != null) && (p2.val == p2.next.val)) {
				p2 = p2.next;
			}
			if (p2 != ptr.next) {
				ptr.next = p2.next;
			} else {
				ptr = ptr.next;
			}
		}
		return head.next;
	}

	public static ListNode reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode slow = head, fast = head.next.next;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		if (fast != null) {
			slow = slow.next;
		}

		ListNode mid = slow, cur = slow.next;
		while (cur.next != null) {
			ListNode mov = cur.next;
			cur.next = mov.next;
			mov.next = mid.next;
			mid.next = mov;
		}

		cur = head;
		while (!cur.equals(mid) && (mid.next != null)) {
			ListNode mov = mid.next;
			mid.next = mov.next;
			mov.next = cur.next;
			cur.next = mov;
			cur = cur.next.next;
		}

		return head;
	}
}
