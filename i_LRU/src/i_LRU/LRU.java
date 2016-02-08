package i_LRU;

import java.util.HashMap;

class Node {
	Node next;
	Node prev;
	
	int value;
	int key;
	
	Node (int k, int val) {
		value = val;
		key = k;
		next = null;
		prev = null;
	}
	
	public void set(int val) { value = val; }
}

public class LRU {

	
	public static void main(String[] args) {
		LRU lru = new LRU(2);
		lru.set(1, 10);
		lru.set(5, 12);
		System.out.println(lru.get(5));
		System.out.println(lru.get(1));
		System.out.println(lru.get(10));
		lru.set(6, 14);
		System.out.println(lru.get(5));
		
	}
	
	private static int N = 0;
	private static Node head;
	private static Node tail;
	private static HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	
	public LRU(int capacity) {
		N = capacity;
		map.clear();
		head = null;
		tail = null;
    }
    
    public static int get(int key) {
    	
    	if (!map.containsKey(key)) {
    		return -1;
    	} 
    	Node node = map.get(key);
    	moveNode(node);
    	return node.value;
        
    }
    
    public static void set(int key, int value) {
    	if (map.containsKey(key)) {
    		moveNode(map.get(key));
    		map.get(key).set(value);
    	} else {
    		if (N == map.size()) {
    			map.remove(head.key);
    			rmNode(head);
    		}
    		Node node = new Node(key,value);
            map.put(key, node);
            insertNode(node);
    	}
    	
        
    }
    
    
    //insert node to the tail of the linked list
    private static void insertNode(Node node) {
        if (head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
    }
    
    private static void rmNode(Node node){
        if (node.equals(head)){
            head = head.next;
            if (head != null) { head.prev = null;}
        }else{
            if (node.equals(tail)) {
                tail = tail.prev;
                tail.next = null;
            }else{
                node.next.prev = node.prev;
                node.prev.next = node.next;
            }
        }
    }
    
    // move current node to the tail of the linked list
    private static void moveNode(Node node){
        if (tail.equals(node)){
            return;
        }else{
            if (node.equals(head)){
                node.next.prev = null;
                head = node.next;
                tail.next = node;
                node.prev = tail;
                tail = tail.next;
            }else{
                node.prev.next = node.next;
                node.next.prev = node.prev;
                tail.next = node;
                node.prev = tail;
                tail=tail.next;
            }
        }
    }
}
