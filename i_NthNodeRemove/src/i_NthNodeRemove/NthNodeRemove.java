package i_NthNodeRemove;

import i_NthNodeRemove.SingleLinkedList.ListNode;

public class NthNodeRemove {

	public static void main(String[] args) {
		int[] A = { 1, 1, 1 };
		int b = 6;

		SingleLinkedList sll = new SingleLinkedList();

		int n = A.length;
		for (int i = n - 1; i >= 0; i--) {
			sll.insertFront(A[i]);
		}
		sll.printList();
		ListNode head = sll.getHeadNode();
		//head = removeNthFromEnd(head, b);
		head = deleteDuplicates(head);
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println("null");
	}
	
	public static ListNode deleteDuplicates(ListNode a) {
		if (a == null ) {
			return a;
		}
		if (a.next == null) {
			return a;
		}
		ListNode front = a.next;
		ListNode back = a;
		
		while (front != null) {
			while ((front != null) && (front.data == back.data)) {
				back.next = front.next;
				front = back.next;
			}
			if (front != null) {
				front = front.next;
			}
			back = back.next;
		}
		return a;
	}

	public static ListNode removeNthFromEnd(ListNode a, int b) {
		if (a == null) { return a; }
		
		ListNode front = a;
		ListNode back = a;
		for (int i = 1; i <= b; i++) {
			front = front.next;
			if (front == null) {
				ListNode temp = a;
				a = a.next;
				temp = null;
				return a;
			}
			
		}

		while (front.next != null) {
			front = front.next;
			back = back.next;
		}
		System.out.println("back: " + back.data);
		
		ListNode temp = back.next;
		back.next = temp.next;
		temp.next = null;
		return a;
	}
}
