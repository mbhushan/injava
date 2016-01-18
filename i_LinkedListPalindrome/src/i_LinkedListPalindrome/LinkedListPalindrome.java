package i_LinkedListPalindrome;

import i_LinkedListPalindrome.LinkedList.Node;

public class LinkedListPalindrome {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		 //int [] A = {1, 3, 3, 4, 3, 3, 1};
		 //int [] A = {1, 3, 4, 5, 6, 7, 8, 9};
		int[] A = { 8, 3 };

		int n = A.length;
		for (int i = n - 1; i >= 0; i--) {
			list.insertFront(A[i]);
		}
		list.printList();
		Node node = list.getHeadNode();
		int ans = lPalin(node);
		System.out.println("ans: " + ans);

	}
	
	public static void printList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println("null");
	}

	public static int lPalin(Node A) {
		Node front = A;
		Node back = A;

		if (front.next == null) {
			return 1;
		}

		while (front.next.next != null) {
			back = back.next;
			front = front.next.next;
			if (front.next == null) {
				break;
			}
		}
		Node result = null;
		Node current = back;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = result;
			result = current;
			current = next;
		}

		back = result;

		front = A;
		//print
		Node test = back;
		while (test != null) {
			System.out.print(test.data + " => ");
			test = test.next;
		}
		System.out.println();
		while (back != null && front != null) {
			if (back.data != front.data) {
				return 0;
			}
			back = back.next;
			front = front.next;
		}
		return 1;
	}

	public static Node reverse(Node headRef) {
		Node result = null;
		Node current = headRef;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = result;
			result = current;
			current = next;
		}
		headRef = result;
		return headRef;
	}

}
