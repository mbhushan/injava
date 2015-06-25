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
	
	public void printList() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println("null");
	}
}
