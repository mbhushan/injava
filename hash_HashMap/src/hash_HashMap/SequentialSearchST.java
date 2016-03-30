package hash_HashMap;

import java.util.LinkedList;
import java.util.Queue;

public class SequentialSearchST<Key, Value> {
	
	private int N = 0; //number of key, value pairs.
	private Node first = null; //the linkedlist of key-value pairs.
	
	private class Node {
		private Key key;
		private Value value;
		private Node next;
		
		Node(Key k, Value v, Node n) {
			key = k;
			value = v;
			next = n;
		}
	}
	
	public SequentialSearchST () {}
	
	public int size() { return N; }
	
	public boolean isEmpty() { return size() == 0; }
	
	public boolean containsKey(Key key) {
		if (key == null) {
			throw new NullPointerException("arguments to containsKey method is null");
		}
		return get(key) != null;
	}
	
	public Value get(Key key) {
		if (key == null) {
			throw new NullPointerException("arguments to get method is null");
		}
		for (Node x=first; x!=null; x=x.next) {
			if (key.equals(x.key)) {
				return x.value;
			}
		}
		return null;
	}

	public void put(Key key, Value value) {
		if (key == null) {
			throw new NullPointerException("argument to put is null");
		}
		if (value == null) {
			delete(key);
			return;
		}
		
		for (Node x=first; x != null; x=x.next) {
			if (key.equals(x.key)) {
				x.value = value;
			}
		}
		first = new Node(key, value, first);
		++N;
	}
	
	public void delete(Key key) {
		if (key == null) {
			throw new NullPointerException(" argument to delete method is null");
		}
		first = delete(first, key);
	}
	
	private Node delete(Node node, Key key) {
		if (node == null) {
			return node;
		}
		if (key.equals(node.key)) {
			--N;
			return node.next;
		}
		node.next = delete(node.next, key);
		return node;
	}
	
	public Iterable<Key> keys() {
		Queue<Key> Q = new LinkedList<Key>();	
		for (Node x=first; x!=null; x=x.next) {
			Q.add(x.key);
		}
		return Q;
	}
}
