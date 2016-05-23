package graph_Dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

	public void dijkstraPaths(GraphNode [] gnodes, int src) {
		Distance [] distance = new Distance[gnodes.length];
		int [] parent = new int[gnodes.length];
		boolean [] visited = new boolean[gnodes.length];
		PriorityQueue<Distance> minHeap = new PriorityQueue<Distance>(10, new DistanceComparator());
		for (int i=1; i<distance.length; i++) {
			if (i == src) {
				distance[i] = new Distance(src,0);
				minHeap.add(distance[src]);
			} else {
				distance[i] = new Distance(i,Integer.MAX_VALUE);
			}
			parent[i] = -1;
		}
		
		while (!minHeap.isEmpty()) {
			Distance currDist = minHeap.poll();
			int label = currDist.label;
			int dist = currDist.distance;
			visited[label] = true;
			ArrayList<GraphNode> neighbors = gnodes[label].neighbors;
			ArrayList<Integer> weights = gnodes[label].weights;
			int size = neighbors.size();
			for (int i=0; i<size; i++) {
				if (visited[neighbors.get(i).label]) {
					continue;
				}
				if ((dist + weights.get(i)) < distance[neighbors.get(i).label].distance) {
					distance[neighbors.get(i).label].distance = dist + weights.get(i);
				}
				minHeap.add(distance[neighbors.get(i).label]);
			}
		}
		
		for(int i=1; i<distance.length; i++) {
			System.out.println("label: " + distance[i].label + ", distance: " + distance[i].distance);
		}
		
	}
	
	public static void main(String[] args) {
		Dijkstra D = new Dijkstra();
		
		GraphNode [] gnodes = new GraphNode[7];
		
		for (int i=0; i<gnodes.length; i++) {
			gnodes[i] = new GraphNode(i);
		}

		GraphNode [][] neighbors = {
				new GraphNode[]{},
				new GraphNode[]{gnodes[2], gnodes[4], gnodes[5]},
				new GraphNode[]{gnodes[1], gnodes[3]},
				new GraphNode[]{gnodes[2], gnodes[4]},
				new GraphNode[]{gnodes[1], gnodes[3], gnodes[6]},
				new GraphNode[]{gnodes[1], gnodes[6]},
				new GraphNode[]{gnodes[4], gnodes[5]},
		};
		
		for (int i=0; i<gnodes.length; i++) {
			ArrayList<GraphNode> list = new ArrayList<GraphNode>();
			Collections.addAll(list, neighbors[i]);
			gnodes[i].neighbors = list;
		}
		
		Integer [][] weights = {
			new Integer[] {},
			new Integer[] {5, 9, 2},
			new Integer[] {5, 2},
			new Integer[] {2, 3},
			new Integer[] {9, 3, 2},
			new Integer[] {2, 3},
			new Integer[] {2, 3}
		};
		
		for (int i=0; i<weights.length; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			Collections.addAll(list, weights[i]);
			gnodes[i].weights = list;
		}
		
		D.dijkstraPaths(gnodes, 1);
	}
}

class GraphNode {
	int label;
	GraphNode next;
	ArrayList<GraphNode> neighbors;
	ArrayList<Integer> weights;
	
	public GraphNode(int x) {
		this.label = x;
		this.neighbors = new ArrayList<GraphNode>();
		this.next = null;
	}
	
	public GraphNode(int x, ArrayList<GraphNode> neighbors) {
		this.label = x;
		this.neighbors = neighbors;
		this.weights = null;
		this.next = null;
	}
	
	public GraphNode(int x, ArrayList<GraphNode> neighbors, ArrayList<Integer> weights) {
		this.label = x;
		this.neighbors = neighbors;
		this.weights = weights;
		this.next = null;
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
}

class DistanceComparator implements Comparator<Distance> {
	public int compare(Distance d1, Distance d2) {
		return d1.distance - d2.distance;
	}
}
