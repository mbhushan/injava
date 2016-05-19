
class Node {
	int value;
	Node next;
	
	Node(int value) {
		this.value = value;
		this.next = null;
	}
}


public class LinkedList {

	private Node head;
	private int N;
	
	public LinkedList() {
		head = null;
		N = 0;
	}
	
	public void insertFront(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		++N;
	}
	
	public void insertBack(int data) {
		if (head == null) {
			insertFront(data);
		}
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = new Node(data);
		++N;
	}
	
	public int listSize() {
		return N;
	}
	
	public Node getHead() {
		return this.head;
	}
	
	public void printList() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.value + " -> ");
			curr = curr.next;
		}
		System.out.println("null");
	}
}
