package i_SLL_PartitionList;

public class PartitionList {

	public static void main(String[] args) {
		//int[] A = {9, 8 , 7, 6, 5, 4, 3, 2, 1, 0 };
		int [] A = {6, 5, 4, 3, 2, 1};

		SingleLinkedList  list = new SingleLinkedList();
		int len = A.length;
		for (int i = 0; i < len; i++) {
			list.insertFront(A[i]);
		}
		list.printList();
		ListNode head = list.getHeadNode();
		
		int x = 0;
		ListNode node = partition(head, x);
		for (ListNode curr = node; curr != null ; curr = curr.next) {
			System.out.print(curr.val + " -> ");
		}
		System.out.println("null");
	}
	
	public static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		int listlen = 0;
		ListNode last = head;
		while (last.next != null) {
			last = last.next;
			++listlen;
		}
		
		ListNode ptr = new ListNode(0);
		ptr.next = head;
        head = ptr; // used to save the result head.
        
        while (listlen > 0){  // in case  of non-stop loop, count n.
            if (ptr.next.val < x){  // val<x keep the node
                ptr = ptr.next;
            }else{                  // val>=x move to last
                last.next = new ListNode(ptr.next.val);    // add node to the last
                last = last.next;
                ptr.next = ptr.next.next;                    //delete current node
            }
            listlen--;
        }
        
        
        
		return head.next;
	}
}
