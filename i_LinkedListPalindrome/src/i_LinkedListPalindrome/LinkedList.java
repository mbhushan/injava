package i_LinkedListPalindrome;


public class LinkedList {

	public class Node {
		Integer data;
		Node next;
		public Node(Integer data) {
			this.data = data;
			next = null;
		}
	}
	
	private Node head;
	private int N;
	
	public Node getHeadNode() {
		return head;
	}
	public void insertFront(Integer data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		++N;
	}
	
	
	public int listSize() {
		return N;
	}
	
	public void printList() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println("null");
	}
}
