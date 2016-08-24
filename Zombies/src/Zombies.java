import javax.swing.text.ZoneView;


public class Zombies {
	
	public static void main(String[] args) {
		
	}

	static int zombieCluster(String[] zombies) {
		if (zombies == null || zombies.length < 1) {
			return 0;
		}
		
		int r = zombies.length;
		int c = zombies[0].length();
		
		int [][] M = new int[r][c];
		for (int i=0; i<r; i++) {
			char [] in = zombies[i].toCharArray();
			for (int j=0; j<c; j++) {
				M[i][j] = Character.getNumericValue(in[j]);
			}
		}
		
		boolean [] visited = new boolean[r];
		int cluster = 0;
		for (int i=0; i<r; i++) {
			if (!visited[i]) {
				dfs(i, M, visited);
				++cluster;
			}
		}
		return cluster;

    }
	
	static void dfs(int u, int [][] M, boolean [] visited) {
		visited[u] = true;
		
		for (int i=0; i<M[u].length; i++) {
			
			int val = M[u][i];
			if (val > 0) {
				if (!visited[i]) {
					dfs(i, M, visited);
				}
			}
		}
	}
}
