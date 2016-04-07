package u_LRUCache;

import java.util.HashMap;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.

APPROACH:
The LRU cache is a hash table of keys and double linked nodes. 
The hash table makes the time of get() to be O(1). The list of double linked 
nodes make the nodes adding/removal operations O(1).
*/

class Node<K, V> {
	K key;
	V value;
	Node<K, V> prev;
	Node<K, V> next;
	
	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public void set(V value) {
		this.value = value;
	}
}

public class LRUCache<K, V> {
	private int capacity;
	private HashMap<K, Node<K, V>> hmap = new HashMap<K, Node<K, V>>();
	private Node<K, V> head = null;
	private Node<K, V> tail = null;
	//private static int N = 0;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public void set(K key, V value) {
		if (hmap.containsKey(key)) {
			moveNode(hmap.get(key));
			hmap.get(key).set(value);
		} else {
			if (hmap.size() >= capacity) {
				hmap.remove(head.key);
				removeNode(head);
			} 
			Node<K, V> node = new Node<K, V>(key, value);
			hmap.put(key, node);
			insertNode(node);
		}
	}
	
	private void removeNode(Node<K, V> node) {
		if (node.equals(head)) {
			head = head.next;
			if (head != null) {
				head.prev = null;
			}
		} else if (node.equals(tail)) {
			tail = tail.prev;
			tail.next.prev = null;
			tail.next = null;
		} else {
			node.next.prev = node.prev;
			node.prev.next = node.next;
		}
	}
	
	private void insertNode(Node<K, V> node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = tail.next;
		}
	}
	
	public V get(K key) {
		if (!hmap.containsKey(key)) {
			return null;
		}
		Node<K,V> node = hmap.get(key);
		moveNode(node); //move the node to the end of the doubly linked list.
		return node.value;
	}
	
	//move nodes at the end of tail (most recently used items)
	private void moveNode(Node<K, V> node) {
		if (tail.equals(node)) {
			return;
		} else if (node.equals(head))   {
				node.next.prev = null;
				head = node.next;
				tail.next = node;
				node.prev = tail;
				tail = tail.next;
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			tail.next = node;
			node.prev = tail;
			tail = tail.next;
		}
	}
}
