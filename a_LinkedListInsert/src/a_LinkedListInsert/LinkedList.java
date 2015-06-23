package a_LinkedListInsert;

public class LinkedList {

	public class Node {
		String data;
		Node next;
		public Node(String data) {
			this.data = data;
			next = null;
		}
	}
	
	private Node head;
	private int N;
	
	public void insertFront(String data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		++N;
	}
	
	public void insertMiddle(String data, int pos) {
		if (pos < 0 || pos > N) {
			System.out.println("Invalid Index.");
			return;
		}

		if (pos == 0) {
			insertFront(data);
		} else if (pos == N) {
			insertBack(data);
		} else {
			Node curr = head;
			Node prev = head;
			int index = 0;
			while (index != pos) {
				prev = curr;
				curr = curr.next;
				++index;
			}
			Node node = new Node(data);
			node.next = curr;
			prev.next = node;
		}
	}
	
	public void insertBack(String data) {
		if (head == null) {
			insertFront(data);
		}
		
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		Node node = new Node(data);
		curr.next = node;
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