package i_NthNodeRemove;

public class SingleLinkedList {

	public class ListNode {
		Integer data;
		ListNode next;
		public ListNode(Integer data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private ListNode head;
	
	public ListNode getHeadNode() {
		return head;
	}
	public void insertFront(Integer data) {
		ListNode node = new ListNode(data);
		node.next = head;
		head = node;
	}
	
	public void printList() {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println("null");
	}
}
