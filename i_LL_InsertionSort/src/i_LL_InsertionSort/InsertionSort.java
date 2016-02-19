package i_LL_InsertionSort;



public class InsertionSort {
	
	public static void main(String[] args) {
		LinkedList list= new LinkedList();
		int[] A = { 5, 3, 2, 1, 4 };

		int n = A.length;
		for (int i = n - 1; i >= 0; i--) {
			list.insertFront(A[i]);
		}
		list.printList();
		ListNode root = list.getHeadNode();
		ListNode node = insertionSortList(root);
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

	public static ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return head;
		}
		
		ListNode p = new ListNode(-1);
		p.next = head;
		head = p;
		ListNode q;
		
		while (p.next != null) {
			q = head;
			boolean flag = false;
			
			while (!q.equals(p)) {
                if (q.next.val > p.next.val) {
                    ListNode tmp1 = p.next;
                    p.next = p.next.next;
                    tmp1.next = q.next;
                    q.next = tmp1;
                    flag = true;
                    break;
                }else{
                    q = q.next;    
                }
            }
            if (!flag){
                p = p.next;
            }
			
		}
		
		return head.next;
	}

}
