package graph_KruskalMST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KruskalMST {

		public static void main(String[] args) {
			Graph graph = new Graph();
			graph.addEdge(0, 1, 3);
			graph.addEdge(0, 3, 1);
			graph.addEdge(1, 3, 3);
			graph.addEdge(1, 2, 1);
			graph.addEdge(2, 3, 1);
			graph.addEdge(2, 4, 5);
			graph.addEdge(2, 5, 4);
			graph.addEdge(3, 4, 6);
			graph.addEdge(4, 5, 2);
			
			graph.doKruskal();
		}
}

class Graph {
	
	private List<EdgeNode> edges;
	private DisjointSet dset;

	public Graph() {
		edges = new ArrayList<EdgeNode>();
		dset = new DisjointSet();
	}
	
	public void addEdge(int start, int end, int weight) {
		EdgeNode node = new EdgeNode(start, end, weight);
		edges.add(node);
		dset.makeSet(start);
		dset.makeSet(end);
	}
	
	public void doKruskal() {
		ArrayList<EdgeNode> mst = new ArrayList<EdgeNode>();
		Collections.sort(edges, new EdgeComparator());
		
		for (EdgeNode e: edges) {
			if (dset.union(e.start, e.end)) {
				mst.add(e);
			}
		}
		
		System.out.println("kruskal MST edges are: ");
		for (EdgeNode e: mst) {
			System.out.println(e.toString());
		}
		
	}
}

class EdgeNode {
	int start;
	int end;
	int weight;
	
	public EdgeNode(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	public String toString() {
		String st = "[start: " + this.start + "; end: " + this.end + "; weight: " + this.weight +"]";
		return st;
	}
}

class EdgeComparator implements Comparator<EdgeNode> {
	public int compare(EdgeNode e1, EdgeNode e2) {
		return e1.weight - e2.weight;
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
			for (int i = 0; i < neighbors.size(); i++) {
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
