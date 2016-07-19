package graph_PrimsMST;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsMST {
	
	public static void main(String[] args) {
		PrimsMST mst = new PrimsMST();
		
		Graph graph  =  new Graph(6);
		graph.addEdge(0, 1, 3);
		graph.addEdge(0, 3, 1);
		graph.addEdge(1, 3, 3);
		graph.addEdge(1, 2, 1);
		graph.addEdge(2, 3, 1);
		graph.addEdge(2, 4, 5);
		graph.addEdge(2, 5, 4);
		graph.addEdge(3, 4, 6);
		graph.addEdge(4, 5, 2);
		
		graph.printGraph();
		graph.primMST(0);
	}
}

class Graph {
	GraphNode [] gnodes;
	int vertices;
	
	public Graph(int vertices) {
		this.vertices = vertices;
		gnodes = new GraphNode[this.vertices];
		for (int i=0; i<this.vertices; i++) {
			gnodes[i] = new GraphNode(i);
		}
	}
	
	public void primMST(int src) {
		boolean [] visited = new boolean[this.vertices];
		Distance [] distances = new Distance[this.vertices];
		PriorityQueue<Distance> minHeap = new PriorityQueue<Distance>(10, new DistanceComparator());
		
		for (int i=0; i<this.vertices; i++) {
			distances[i] = new Distance(i, -1, Integer.MAX_VALUE);
			if (i == src) {
				distances[i].dist = 0;
			}
			minHeap.add(distances[i]);
		}
		
		while(!minHeap.isEmpty()) {
			Distance dis = minHeap.remove();
			int u = dis.label;
			int d = dis.dist;
			visited[u] = true;
			int size = gnodes[u].neighbors.size();
			for (int i=0; i<size; i++) {
				GraphNode gn = gnodes[u].neighbors.get(i);
				if (visited[gn.label]) {
					continue;
				}
				int wt = gnodes[u].weights.get(i);
				if (wt < distances[gn.label].dist) {
					distances[gn.label].dist = wt;
					distances[gn.label].parent = u;
					minHeap.add(distances[gn.label]);
				}
			}
		}
		System.out.println("prim mst edges: ");
		for (int i=0; i<this.vertices; i++) {
			System.out.println(distances[i].toString());
		}
	}
	
	public void addEdge(int u, int v, int wt) {
		gnodes[u].neighbors.add(gnodes[v]);
		gnodes[u].weights.add(wt);
		
		gnodes[v].neighbors.add(gnodes[u]);
		gnodes[v].weights.add(wt);
	}
	
	public void printGraph() {
		System.out.println("input graph: ");
		for (int i=0; i<vertices; i++) {
			System.out.println(gnodes[i].toString());
		}
	}
}

class GraphNode {
	int label;
	List<GraphNode> neighbors;
	List<Integer> weights;
	
	public GraphNode(int label) {
		this.label = label;
		this.neighbors = new ArrayList<GraphNode>();
		this.weights = new ArrayList<Integer>();
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("label: " + this.label + "\n");
		if (this.neighbors != null) {
			sb.append("neighbors(lable;weight): ");
			for (int i=0; i<neighbors.size(); i++) {
				GraphNode gn = neighbors.get(i);
				int wt = weights.get(i);
				if (gn != null) {
					sb.append(gn.label + ";" + wt + " ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}

class Distance {
	int label;
	int parent;
	int dist;
	
	public Distance(int label, int parent, int dist) {
		this.label = label;
		this.parent = parent;
		this.dist = dist;
	}
	
	public String toString() {
		String str = "[label: " + this.label + "; distance: " + this.dist + "; parent: " + this.parent + "]";
		return str;
	}
}

class DistanceComparator implements Comparator<Distance> {
	
	public int compare(Distance d1, Distance d2) {
		return d1.dist - d2.dist;
	}
}