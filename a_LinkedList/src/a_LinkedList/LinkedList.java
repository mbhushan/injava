package a_LinkedList;

class Node {
	String data;
	Node next;
}

public class LinkedList {
	public static Node root = null;
	
	public static void main(String [] args) {
		Node first = new Node();
		Node second = new Node();
		Node third = new Node();
		
		first.data = "A";
		second.data = "B";
		third.data = "C";
		
		first.next = second;
		second.next = third;
		third.next = null;
		
		root = first;
		printLinkedList(root);
	}
	
	public static void printLinkedList(Node node) {
		Node curr = node;
		
		while (curr != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println("null");
	}
}
