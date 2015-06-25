package a_LinkedListOperations;

public class LinkedList {

	private class Node {
		String data;
		Node next;
		public Node(String data) {
			this.data = data;
			this.next = null;
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
	
	public String removeFront() {
		if (head == null) { 
			return null;
		}
		Node node = head;
		head = head.next;
		return node.data;
	}
	
	public String removeBack() {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			String result = head.data;
			head = head.next;
			--N; 
			return result;
		} else {
			Node curr = head;
			while (curr.next.next != null) {
				curr = curr.next;
			}
			Node node = curr.next;
			curr.next = null;
			--N;
			return node.data;
		}
	}
	
	public String removePosition(int pos) {
		if (pos < 0 || pos >= N) {
			System.out.println("Invalid position!");
			return null;
		}
		if (pos == 0) {
			return removeFront();
		} else if (pos == N-1) {
			return removeBack();
		} else {
			Node curr = head;
			Node prev = head;
			int index = 0;
			while (index < pos) {
				prev = curr;
				curr = curr.next;
				++index;
			}
			Node node = curr;
			prev.next = curr.next;
			--N;
			return node.data;
		}
	}
	
	public int size() {
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
