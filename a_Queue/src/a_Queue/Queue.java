package a_Queue;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	
	private class Node {
		Item item;
		Node next;
	}
	
	private Node front;
	private Node back;
	private int N = 0;
	
	public void enqueue(Item item) {
		Node node = new Node();
		node.item = item;
		node.next = null;
		if (isEmpty()) {
			front = node;
			back = front;
		} else {
			back.next = node;
			back = back.next;
		}
		++N;
	}
	
	public Item dequeue() {
		if (isEmpty()) {
			return null;
		}
		Item item = front.item;
		front = front.next;
		if (front == null) {
			back = null;
		}
		--N;
		return item;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item> {
		Node current = front;

		public boolean hasNext() {
			return current != null;
		}
		
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
		public void remove() {}
	}
}
