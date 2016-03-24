package graph_UndirectedCycle;

public class UGraphClient {


	public static void main(String[] args) {
		UGraph g = new UGraph(4);
		
		 g.addEdge(0, 1);
		 g.addEdge(1, 2);
		 //g.addEdge(0, 2);
		 g.addEdge(2, 3);
		// g.addEdge(3, 0);
		 
		 boolean hascycle = g.hasCycle();
		 System.out.println("graph has cycle: " + hascycle);
	}
}
