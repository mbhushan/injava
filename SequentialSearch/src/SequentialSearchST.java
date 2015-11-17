
public class SequentialSearchST<Key, Value> {

	private class Node {
		Key key;
		Value value;
		Node next;
		
		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	//first node of the linkedlist
	private Node first;
	private int size;
	
	public Value get(Key key) {
		for (Node node = first; node != null; node = node.next) {
			if (key.equals(node.key)) {
				return node.value;
			}
		}
		return null;
	}
	
	public void put(Key key, Value value) {
		for (Node node=first; node != null; node = node.next) {
			if (key.equals(node.key)) {
				node.value = value;
				return;
			}
		}
		// search miss, add this node to the front
		first = new Node(key, value, first);
		++size;
	}
	
	public int size() {
		return this.size;
	}
	
	public Object [] keys() {
		Key [] keyArr = (Key []) new Object[size()];
		
		int index = 0;
		for (Node node=first; node!= null; node=node.next) {
			keyArr[index] = node.key;
			++index;
		}
		
		return keyArr;
	}
	
	
}
