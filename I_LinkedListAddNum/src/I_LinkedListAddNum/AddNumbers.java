package I_LinkedListAddNum;

public class AddNumbers {
	
	public static void main(String[] args) {
		SingleLinkedList X = new SingleLinkedList();
		SingleLinkedList Y = new SingleLinkedList();
		
		int [] A = {1};
		int [] B = {9, 9, 9};
		for (int i=0; i<A.length; i++) {
			X.insertFront(A[i]);
		}
		
		for (int i=0; i<B.length; i++) {
			Y.insertFront(B[i]);
		}
		X.printSLL();
		Y.printSLL();
		addTwoNumbers(X.getHeadNode(), Y.getHeadNode());
		
	}

	public static ListNode addTwoNumbers(ListNode a, ListNode b) {
		ListNode node =  addLinkedList(a, b, 0);
		ListNode curr = node;
		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println();
		return a;
	}
	
	public static ListNode addLinkedList(ListNode A, ListNode B, int carry) {
		  if (null == A && null == B) {
			  if (carry > 0) {
				  return new ListNode(carry);
			  }
		   return null;
		  }
		  
		  int value = carry;
		  if (null != A) {
		   value += A.val;
		  }
		  if (null != B) {
		   value += B.val;
		  }
		  carry = (value >= 10) ? 1 : 0;
		  value = value%10;
		  ListNode node = new ListNode(value);
		 // node.val = value;
		  node.next = addLinkedList((null == A) ? null: A.next, (null == B) ? null: B.next, carry);
		  return node;
		 }
}
