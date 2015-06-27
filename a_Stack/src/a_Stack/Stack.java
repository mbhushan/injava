package a_Stack;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	
	private  Node first; // top of the stack ie most recently added items.
	private int N; // number of items.

	private class Node {
		Item item;
		Node next;
	}

	public Stack() {
	}
	
	public void push(Item item) {
		Node node = new Node();
		node.item = item;
		node.next = first;
		first = node;
		++N;
	}
	
	public Item pop() {
		return null;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
		
	}

	@Override
	public Iterator<Item> iterator() {
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Item> {
		
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {}
		
	}

}
