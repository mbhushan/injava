package I_LinkedListAddNum;

class ListNode {
	Integer val;
	ListNode next;
	
	public ListNode(Integer data) {
		this.val = data;
		next = null;
	}
}

public class SingleLinkedList {

	
	
	private ListNode head;
	
	public ListNode getHeadNode() {
		return this.head;
	}
	
	public void insertFront(int val) {
		ListNode node = new ListNode(val);
		node.next = head;
		head = node;
	}
	
	public void printSLL() {
		ListNode curr = this.head;
		while (curr != null) {
			System.out.print(curr.val + " -> ");
			curr = curr.next;
		}
		System.out.println("null");
	}
}