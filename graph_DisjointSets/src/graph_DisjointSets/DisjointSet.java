package graph_DisjointSets;

import java.util.HashMap;

public class DisjointSet {

	private HashMap<Integer, Node> hmap = new HashMap<Integer, Node>();
	
	public void makeSet(int data) {
		Node node = new Node(data);
		hmap.put(data, node);
	}
	
	public boolean union(int first, int second) {
		Node n1 = hmap.get(first);
		Node n2 = hmap.get(second);
		
		Node parent1 = findSet(n1);
		Node parent2 = findSet(n2);
		
		//check if part of the same set.
		if (parent1.data == parent2.data) {
			return false;
		}
		
		if (parent1.rank >= parent2.rank) {
			//increment rank only if both ranks are same.
			parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank+1 : parent1.rank; 
			
			parent2.parent = parent1;
		} else {
			parent1.parent = parent2;
		}
		
		return true;
	}
	
	public int findSet(int data) {
		return findSet(hmap.get(data)).data;
	}
	
	private Node findSet(Node node) {
		if (node.equals(node.parent)) {
			return node.parent;
		}
		node.parent = findSet(node.parent);
		return node.parent;
	}
}

class Node {
	int data;
	int rank;
	Node parent;
	
	public Node(int data) {
		this.data = data;
		this.rank = 0;
		this.parent = this;
	}
}
