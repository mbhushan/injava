package graph_CheckBipartite;

public class GraphDriver {
	
	public static void main(String[] args) {
		Graph g = new Graph(4);
		
		 g.addEdge(0, 1);
		 g.addEdge(0, 3);
		 g.addEdge(1, 2);
		 g.addEdge(1, 0);
		 g.addEdge(2, 1);
		 g.addEdge(2, 3);
		 g.addEdge(3, 0);
		 g.addEdge(3, 2);
		 
		 System.out.println("is graph bipartite: " + g.isBipartite());
	}
}
