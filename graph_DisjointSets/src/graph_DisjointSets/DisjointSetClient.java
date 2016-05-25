package graph_DisjointSets;

public class DisjointSetClient {

	public static void main(String[] args) {
		DisjointSet ds = new DisjointSet();
		int n = 7;
		for (int i=1; i<=n; i++) {
			ds.makeSet(i);
		}
		
		ds.union(1, 2);
       	System.out.println("check set for " + 1 + ": " + ds.findSet(1));
       	System.out.println("check set for " + 2 + ": " + ds.findSet(2));
        ds.union(2, 3);
       	System.out.println("check set for " + 2 + ": " + ds.findSet(2));
       	System.out.println("check set for " + 3 + ": " + ds.findSet(3));
        ds.union(4, 5);
       	System.out.println("check set for " + 4 + ": " + ds.findSet(4));
       	System.out.println("check set for " + 5 + ": " + ds.findSet(5));
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);
        
        for (int i=1; i<=n; i++) {
        	System.out.println("set for " + i + ": " + ds.findSet(i));
		}
	}
}
