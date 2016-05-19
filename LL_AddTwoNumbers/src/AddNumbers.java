/*
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class AddNumbers {

	public static void main(String[] args) {
		AddNumbers AN = new AddNumbers();
		LinkedList AL = new LinkedList();
		
		int [] A = {2, 4, 3};
		int [] B = {5, 6, 4};
		
		for (int i=A.length-1; i>=0; i--) {
			AL.insertFront(A[i]);
		}
		AL.printList();
		
		LinkedList BL = new LinkedList();
		for (int i=B.length-1; i>=0; i--) {
			BL.insertFront(B[i]);
		}
		BL.printList();
		
		Node head = addNumbers(AL.getHead(), BL.getHead());
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.value + " -> ");
			curr = curr.next;
		}
		System.out.println("null");
	}
	
	public static Node addNumbers(Node A, Node B) {
		Node head = new Node(0);
		Node p1 = A;
		Node p2 = B;
		Node p3 = head;
		int carry = 0;
		
		while (p1 != null || p2 != null) {
			if (p1 != null) {
				carry += p1.value;
				p1 = p1.next;
			}
			if (p2 != null) {
				carry += p2.value;
				p2 = p2.next;
			}
			p3.next = new Node(carry%10);
			carry = carry/10;
			p3 = p3.next;
		}
		
		if (carry == 1) {
			p3.next = new Node(1);
		}
		return head.next;
	}
}
