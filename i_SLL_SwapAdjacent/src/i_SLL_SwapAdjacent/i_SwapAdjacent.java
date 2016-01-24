package i_SLL_SwapAdjacent;


public class i_SwapAdjacent {
	
	public static void main(String[] args) {
		SingleLinkedList  list = new SingleLinkedList();
		//int[] A = {9, 8 , 7, 6, 5, 4, 3, 2, 1, 0 };
		int [] A = {6, 5, 4, 3, 2, 1};

		int n = A.length;
		ListNode mark = null;
		for (int i = 0; i < n; i++) {
			list.insertFront(A[i]);
		}
		list.printList();
		ListNode head = list.getHeadNode();
		ListNode node = swapPairs(head);
		for (ListNode curr = node; curr != null; curr=curr.next) {
			System.out.print(curr.val + " -> ");
		}
		System.out.println("null");
	}

	public static ListNode swapPairs(ListNode a) {
		if (a == null || a.next == null) {
			return a;
		}
		ListNode front = a.next;
		ListNode back = a;
		ListNode mark = null;
		
		while (true) {
			back.next = front.next;
			front.next = back;
			if (mark != null) {
				mark.next = front;
				mark = back;
			}
			if (a.equals(back)) {
				a = front;
				mark = back;
			}
			//mark.next = back;
			back = back.next;
			if (back != null && back.next != null) {
				//mark.next = back;
				front = back.next;
			} else {
				break;
			}
		}
		
		return a;
	}
}
