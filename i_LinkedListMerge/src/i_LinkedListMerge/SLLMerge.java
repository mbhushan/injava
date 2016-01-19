package i_LinkedListMerge;

import i_LinkedListMerge.LinkedList.ListNode;

public class SLLMerge {

	public static void main(String[] args) {
		LinkedList X = new LinkedList();
		LinkedList Y = new LinkedList();
		
		int [] A = {7, 6};
		int [] B = {5, 3, 1};
		for (int i=0; i<A.length; i++) {
			X.insertFront(A[i]);
		}
		
		for (int i=0; i<B.length; i++) {
			Y.insertFront(B[i]);
		}
		X.printSLL();
		Y.printSLL();
		mergeTwoLists(X.getHeadNode(), Y.getHeadNode());
	}
	
	public static ListNode mergeTwoLists(ListNode a, ListNode b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}
		ListNode bCurr = b;
		ListNode aCurr = a;
		ListNode aPrev = a;
		ListNode bPrev = b;
		while (bCurr != null && aCurr != null) {
			if (bCurr.val <= aCurr.val) {
				ListNode node = bCurr;
				bPrev = bCurr;
				bCurr = bCurr.next;
				node.next = aCurr;
				//handle first node
				if (a.equals(aCurr)) {
					a = node;
				} else {
					aPrev.next = node;
				}
				aPrev = node;
			} else {
				aPrev = aCurr;
				aCurr = aCurr.next;
			}
			System.out.println("stuck man");
		}
		if (aCurr == null) {
			aPrev.next = bCurr;
		}
		if (bCurr == null) {
			bPrev.next = aCurr;
		}
		System.out.println("printing list:");
		ListNode tmp = a;
		while (tmp != null) {
			System.out.print(tmp.val + " -> ");
			tmp = tmp.next;
		}
		System.out.println("null");
		return a;
	}
}
