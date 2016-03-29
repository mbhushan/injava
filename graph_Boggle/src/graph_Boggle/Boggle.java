package graph_Boggle;

public class Boggle {

	private static String [] DICT = {"GEEKS", "FOR", "QUIZ", "GO"};
	public static void main(String[] args) {
		char [][] board = {{'G','I','Z'},
                {'U','E','K'},
                {'Q','S','E'}};
		
		findWords(board);

	}
	
	public static void findWords(char [][] board) {
		int row = board.length;
		int col = board[0].length;
		boolean [][] visited = new boolean[row][col];
		
		StringBuffer sb = new StringBuffer();
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				findWordsUtil(board, visited, i, j, sb);
			}
		}
	}
	
	private static void findWordsUtil(char [][] board, boolean [][] visited, int i, int j, StringBuffer sb) {
		//mark current cell as visited and append the current char to string buffer.
		visited[i][j] = true;
		sb.append(board[i][j]);
		if (isValidWord(sb.toString())) {
			System.out.println(sb.toString());
		}
		//traverse 8 adjacent characters in the board;
		for (int r=i-1; r <= i+1 && r < board.length; r++) {
			for (int c=j-1; c <= j+1 && c < board[0].length; c++) {
				if (r >= 0 && c >= 0 && !visited[r][c]) {
					findWordsUtil(board, visited, r, c, sb);
				}
			}
		}
		// Erase current character from string and mark visited
	    // of current cell as false
		sb.deleteCharAt(sb.length() - 1);
		visited[i][j] = false;
	}
	
	private static boolean isValidWord(String word) {
		int len = DICT.length;
		for (int i=0; i<len; i++) {
			if (word.compareTo(DICT[i]) == 0) {
				return true;
			}
		}
		return false;
	}
	
}
