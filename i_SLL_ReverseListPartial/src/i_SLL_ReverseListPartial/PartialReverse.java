package i_SLL_ReverseListPartial;

public class PartialReverse {

	public static void main(String[] args) {
		
		SingleLinkedList  list = new SingleLinkedList();
		//int[] A = {9, 8 , 7, 6, 5, 4, 3, 2, 1, 0 };
		int [] A = {6, 5, 4, 3, 2, 1};

		int len = A.length;
		for (int i = 0; i < len; i++) {
			list.insertFront(A[i]);
		}
		list.printList();
		ListNode head = list.getHeadNode();
		int m = 2;
		int n = 4;
		ListNode node = reverseBetween(head, m, n);
		for (ListNode curr = node; curr != null ; curr = curr.next) {
			System.out.print(curr.val + " -> ");
		}
		System.out.println("null");
	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if(m==n) return head;
		 
	    ListNode prev = null;//track (m-1)th node
	    ListNode first = new ListNode(0);//first's next points to mth
	    ListNode second = new ListNode(0);//second's next points to (n+1)th
	 
	    int i=0;
	    ListNode p = head;
	    while(p!=null){
	        i++;
	        if(i==m-1){
	            prev = p;
	        }
	 
	        if(i==m){
	            first.next = p;
	        }
	 
	        if(i==n){
	            second.next = p.next;
	            p.next = null;
	        }
	 
	        p= p.next;
	    }
	    if(first.next == null)
	        return head;
	 
	    // reverse list [m, n]    
	    ListNode p1 = first.next;
	    ListNode p2 = p1.next;
	    p1.next = second.next;
	 
	    while(p1!=null && p2!=null){
	        ListNode t = p2.next;
	        p2.next = p1;
	        p1 = p2;
	        p2 = t;
	    }
	 
	    //connect to previous part
	    if(prev!=null)
	        prev.next = p1;
	    else
	        return p1;
	 
	    return head;
	}
}
