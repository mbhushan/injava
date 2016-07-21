package graph_KruskalMST;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

	private Map<Integer, Node> hmap ;
	
	public DisjointSet() {
		hmap = new HashMap<Integer, Node>();
	}
	
	public void makeSet(int data) {
		if (hmap.containsKey(data)) {
			return;
		}
		Node node = new Node(data);
		hmap.put(data, node);
	}
	
	public boolean union(int first, int second) {
		
		Node i = findSet(first);
		Node j = findSet(second);
		
		//check if same set
		if (i.data == j.data) {
			return false;
		}
		
		if (i.rank >= j.rank) {
			i.rank = (i.rank == j.rank) ? i.rank+1 : i.rank;
			j.parent = i;
		} else {
			i.parent = j;
		}
		return true;
	}
	
	private Node findSet(int key) {
		return findSet(hmap.get(key));
	}
	
	private Node findSet(Node node) {
		if (node.equals(node.parent)) {
			return node;
		}
		return findSet(node.parent);
	}
}

class Node {
	int data;
	int rank;
	Node parent;
	
	public Node (int data) {
		this.data = data;
		this.rank = 0;
		this.parent = this;
	}
}
