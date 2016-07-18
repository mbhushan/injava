package graph_DijkstraSingleSrcShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Find single source shortest path using Dijkstra algorithm - undirected graph
*/

public class DijkstraShortestPath {
	
	public static void main(String[] args) {
		DijkstraShortestPath dsp = new DijkstraShortestPath();
		
		Graph graph = new Graph(6);
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 4, 2);
		graph.addEdge(0, 3, 9);
		graph.addEdge(1, 2, 2);
		graph.addEdge(2, 3, 3);
		graph.addEdge(3, 5, 2);
		graph.addEdge(4, 5, 3);
		
		graph.printGraph();
		graph.dijsktra(0);
	}
	
}

class Graph {
	
	private GraphNode [] gnodes;
	private int numNodes ;
	
	Graph (int numNodes) {
		this.numNodes = numNodes;
		gnodes = new GraphNode[numNodes];
		for (int i=0; i<this.numNodes; i++) {
			gnodes[i] = new GraphNode(i);
		}
	}
	
	public void dijsktra(int src) {
		PriorityQueue<Distance> minHeap = new PriorityQueue<Distance>(10, new DistanceComparator());
		int [] parent = new int[numNodes];
		Distance [] distance = new Distance[numNodes];
		boolean [] visited = new boolean[numNodes];
		
		Arrays.fill(parent, -1);
		
		for (int i=0; i<this.numNodes; i++) {
			distance[i] = new Distance(i, Integer.MAX_VALUE);
			if (i == src) {
				distance[src].distance = 0;
			}
			minHeap.add(distance[i]);
		}
		
		parent[src] = -1;
		//visited[src] = true;
		
		while (!minHeap.isEmpty()) {
			Distance dist = minHeap.remove();
			int u = dist.label;
			int d = dist.distance;
			visited[u] = true;
			int size = gnodes[u].neighbors.size();
			for (int i=0; i<size; i++) {
				GraphNode gn = gnodes[u].neighbors.get(i);
				if (visited[gn.label]) {
					continue;
				}
				int wt = gnodes[u].weights.get(i);
				if (wt+d < distance[gn.label].distance) {
					distance[gn.label].distance = wt + d;
					parent[gn.label] = u;
					minHeap.add(distance[gn.label]);
				}
			}
		}
		System.out.println("final shortest distances to each vertex:");
		for (int i=0; i<numNodes; i++) {
			System.out.println(distance[i].toString() + "; parent: " + parent[i]);
		}
	}
	
	public void addEdge(int src, int dest, int weight) {
		gnodes[src].neighbors.add(gnodes[dest]);
		gnodes[src].weights.add(weight);

		gnodes[dest].neighbors.add(gnodes[src]);
		gnodes[dest].weights.add(weight);
	}
	
	public void printGraph() {
		System.out.println("input graph: ");
		for (int index=0; index<gnodes.length; index++) {
			System.out.println(gnodes[index].toString());
		}
	}
	
}

class GraphNode {
	int label;
	List<GraphNode> neighbors;
	List<Integer> weights;
	
	public GraphNode(int label) {
		this.label = label;
		this.weights = new ArrayList<Integer>();
		this.neighbors = new ArrayList<GraphNode>();
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
	int distance;
	
	public Distance(int label, int distance) {
		this.label = label;
		this.distance = distance;
	}
	
	public String toString() {
		String str = "[label: " + this.label + "; distance: " + this.distance + "]";
		return str;
	}
}


class DistanceComparator implements Comparator<Distance>{
	public int compare(Distance d1, Distance d2) {
		return d1.distance - d2.distance;
	}
}
