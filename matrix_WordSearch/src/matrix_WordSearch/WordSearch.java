package matrix_WordSearch;

public class WordSearch {
	
	public boolean searchWord(char [][] M, String word) {
		int row = M.length;
		int col = M[0].length;
		
		boolean [][] visited = new boolean[row][col];
		StringBuffer sb = new StringBuffer();
		boolean [] flag = new boolean[1];
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
					dfs(M, i, j, visited, sb, word, flag);
			}
		}
		return flag[0];
	}
	
	private void dfs(char [][] M, int row, int col, boolean [][] visited, StringBuffer sb, String word, boolean [] flag) {
		visited[row][col] = true;
		sb.append(M[row][col]);
		if (sb.toString().equals(word)) {
			//System.out.println(word + " is present!");
			flag[0] = true;
		}
		int []rowOffset = {0, -1, 1, 0};
		int []colOffset = {-1, 0, 0, 1};
		for (int k=0; k<rowOffset.length; k++) {
			int r = row + rowOffset[k];
			int c = col + colOffset[k];
			if (r >= 0 &&  r < M.length && c >= 0 && c < M[0].length && !visited[r][c]) {
				dfs(M, r, c, visited, sb, word, flag);
			}
		}
		sb.deleteCharAt(sb.length()-1);
		visited[row][col] = false;
	}

	public static void main(String[] args) {
		WordSearch WS = new WordSearch();
		
		char [][] M = {
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}
		};
		
		String [] words = {"ABCCED", "SEE", "ABCB"};
		
		for (int i=0; i<words.length; i++) {
			System.out.println(words[i] + " is present: " + WS.searchWord(M, words[i]));
		}
	}
}
