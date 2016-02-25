package i_graph_BlackStruct;

import java.util.ArrayList;

public class BlackStruct {
	
	public static void main(String[] args) {
		String [] S = {"OOOXOOO", "OOXXOXO", "OXOOOXO"};
		ArrayList<String> A = new ArrayList<String>();
		for (int i=0; i<S.length; i++) {
			A.add(S[i]);
		}
		
		System.out.println("ans: " + black(A));
	}

	public static int black(ArrayList<String> a) {
        if (a.size() == 0) return 0;
        int[][] arr = new int[a.size()][a.get(0).length()];
         
        int i = 0;
        for (String str: a) {
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = 0;
                if (str.charAt(j) == 'X') arr[i][j] = 1;
            }
            i++;
        }
         
        return _sol(arr, a.size(), a.get(0).length());
    }
     
    public static int _sol(int [][]arr, int r, int c) {
        boolean[][] visited = new boolean[r][c];
         
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                //System.out.print(arr[i][j]);
                if (arr[i][j] == 1 && !visited[i][j]) {
                    dfs(arr, i, j, visited, r, c);
                    count++;
                }
            }
            //System.out.println();
        }
         
        return count;
    }
     
    public static void dfs(int[][] arr, int i, int j, boolean[][] visited, int r, int c) {
        if (i < 0 || i > r-1) return;
         
        if (j <0 || j > c-1) return;
         
        if (arr[i][j] == 0 || visited[i][j]) {
            return;
        }
         
        visited[i][j] = true;
        dfs(arr, i+1, j, visited, r, c);
        dfs(arr, i-1, j, visited, r, c);
        dfs(arr, i, j+1, visited, r, c);
        dfs(arr, i, j-1, visited, r, c);
    }
}
