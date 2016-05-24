package graph_Prims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prims {
	
	public void prims(GraphNode [] gnodes, int src) {
		int n = gnodes.length;
		int [] parent = new int[n];
		Vertex [] vertices = new Vertex[n];
		boolean [] visited = new boolean[n];
		PriorityQueue<Vertex> minHeap = new PriorityQueue<Vertex>(10, new VertexComparator());
		
		for (int i=1; i<n; i++) {
			parent[i] = -1;
			vertices[i] = new Vertex(i, Integer.MAX_VALUE);
		}
		vertices[src].distance = 0;
		minHeap.add(vertices[src]);
		
		while(!minHeap.isEmpty()) {
			Vertex v = minHeap.poll();
			visited[v.label] = true;
			ArrayList<GraphNode> neighbors = gnodes[v.label].neighbors;
			ArrayList<Integer> weights = gnodes[v.label].weights;
			int size = neighbors.size();
			for (int i=0; i<size; i++) {
				GraphNode node = neighbors.get(i);
				if (visited[node.label]) {
					continue;
				}
				Integer w = weights.get(i);
				
				if (w < vertices[node.label].distance) {
					vertices[node.label].distance = w;
					parent[node.label] = v.label;
				}
				minHeap.add(vertices[node.label]);
			}
		}
		
		System.out.println("edges post prims run on graph: ");
		for (int i=1; i<n; i++) {
			System.out.println(i + " -> " + parent[i]);
		}
	}
	
	public static void main(String[] args) {
		GraphNode [] gnodes = new GraphNode[7];
		
		for (int i=0; i<gnodes.length; i++) {
			gnodes[i] = new GraphNode(i);
		}

		GraphNode [][] neighbors = {
				new GraphNode[]{},
				new GraphNode[]{gnodes[2], gnodes[4]},
				new GraphNode[]{gnodes[1], gnodes[3], gnodes[4]},
				new GraphNode[]{gnodes[2], gnodes[4], gnodes[5], gnodes[6]},
				new GraphNode[]{gnodes[1], gnodes[2], gnodes[3], gnodes[5]},
				new GraphNode[]{gnodes[3], gnodes[4], gnodes[6]},
				new GraphNode[]{gnodes[3], gnodes[5]},
		};
		
		for (int i=0; i<gnodes.length; i++) {
			ArrayList<GraphNode> list = new ArrayList<GraphNode>();
			Collections.addAll(list, neighbors[i]);
			gnodes[i].neighbors = list;
		}
		
		Integer [][] weights = {
			new Integer[] {},
			new Integer[] {3, 1},
			new Integer[] {3, 1, 3},
			new Integer[] {1, 1, 5, 4},
			new Integer[] {1, 3, 1, 6},
			new Integer[] {5, 6, 2},
			new Integer[] {4, 2}
		};
		
		for (int i=0; i<weights.length; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			Collections.addAll(list, weights[i]);
			gnodes[i].weights = list;
		}
		
		new Prims().prims(gnodes, 1);
	}
}

class VertexComparator implements Comparator<Vertex> {

	@Override
	public int compare(Vertex o1, Vertex o2) {
		return o1.distance - o2.distance;
	}
	
}

class Vertex {
	int label;
	int distance;
	
	Vertex(int label, int distance) {
		this.label = label;
		this.distance = distance;
	}
}

class GraphNode {
	int label;
	ArrayList<GraphNode> neighbors;
	ArrayList<Integer> weights;
	
	public GraphNode(int x) {
		this.label = x;
		this.neighbors = new ArrayList<GraphNode>();
		this.weights = new ArrayList<Integer>();
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("label: " + this.label + "\n");
		if (this.neighbors != null) {
			sb.append("neighbors: ");
			for (GraphNode gn: this.neighbors) {
				sb.append(gn.label + " ");
			}
			sb.append("\n");
		}
		if (this.weights != null) {
			sb.append("weights: ");
			for (Integer w: this.weights) {
				sb.append(w + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
