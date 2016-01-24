package i_ListCycle;



public class DetectCycle {

	public static void main(String[] args) {
		SingleLinkedList  list = new SingleLinkedList();
		int[] A = {9, 8 , 7, 6, 5, 4, 3, 2, 1, 0 };

		int n = A.length;
		ListNode mark = null;
		for (int i = 0; i < n; i++) {
			list.insertFront(A[i]);
		}
		list.printList();
		ListNode head = list.getHeadNode();
		ListNode curr = head;
		while (curr.next != null) {
			if (curr.val == 4) {
				mark = curr;
			}
			curr = curr.next;
		}
		curr.next = mark;
		ListNode ptr = detectCycle(head);
		System.out.println("cycle start at: " + ptr.val);
	}

	public static ListNode detectCycle(ListNode head) {
		if (head == null){return head;}
        ListNode p=head;
        ListNode q=head;
        while (true){
            if (p.next != null) {
            	p=p.next;
            } else {
            	return null;
            }
            if (q.next != null && q.next.next != null) {
            	q=q.next.next; 
            } else {
            	return null;
            }
            if (p.equals(q)) { //if find the loop, then looking for the loop start
                q = head;
                while (!p.equals(q)){
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
        }
	}

}
