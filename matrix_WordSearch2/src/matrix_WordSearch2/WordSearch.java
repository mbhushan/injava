package matrix_WordSearch2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class WordSearch {
	
	private String [] dict = {"oath","pea","eat","rain"};
	private HashSet<String> hset = new HashSet<String>();
	
	public WordSearch() {
		Collections.addAll(hset, dict);
	}
	
	public HashSet<String> findWords(char [][] M) {
		int row = M.length;
		int col = M[0].length;
		
		boolean[][] visited = new boolean[row][col];
		HashSet<String>  result = new HashSet<String> ();
		StringBuffer sb = new StringBuffer();
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				dfs(M, i, j, visited, sb, result);
			}
		}
		return result;
	}
	
	
	private void dfs(char [][] M, int row, int col, boolean [][] visited, StringBuffer sb, HashSet<String>  result) {
		visited[row][col] = true;
		sb.append(M[row][col]);
		
		if (hset.contains(sb.toString())) {
			result.add(sb.toString());
		}
		
		for (int i=row-1; i<=row+1 && i<M.length; i++) {
			for (int j=col-1; j<=col+1 && j<M[0].length; j++) {
				if (i >=0 && j >=0 && !visited[i][j]) {
					dfs(M, i, j, visited, sb, result);
				}
			}
		}
		sb.deleteCharAt(sb.length()-1);
		visited[row][col] = false;
	}
	

	public static void main(String[] args) {
		WordSearch WS = new WordSearch();
		
		char [][] M = {
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
				};
		HashSet<String> result = WS.findWords(M);
		System.out.println("valid words in the grid: ");
		for (String word: result) {
			System.out.println(word);
		}
		
	}
}
