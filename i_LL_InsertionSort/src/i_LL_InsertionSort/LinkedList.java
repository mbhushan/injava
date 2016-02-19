package i_LL_InsertionSort;

 class ListNode {
	Integer val;
	ListNode next;
	public ListNode(Integer data) {
		this.val = data;
		next = null;
	}
}

public class LinkedList {

	
	private ListNode head;
	private int N;
	
	public ListNode getHeadNode() {
		return head;
	}
	public void insertFront(Integer data) {
		ListNode node = new ListNode(data);
		node.next = head;
		head = node;
		++N;
	}
	
	
	public int listSize() {
		return N;
	}
	
	public void printList() {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + " -> ");
			curr = curr.next;
		}
		System.out.println("null");
	}
}

