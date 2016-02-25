package i_WordSearch;

import java.util.ArrayList;

public class WordSearch {
	
	public static void main(String[] args) {
		String [] S = {"ABCE","SFCS", "ADEE"};
		ArrayList<String> A = new ArrayList<String>();
		for (int i=0; i<S.length; i++) {
			A.add(S[i]);
		}
		String word = "ABCCED";
		System.out.println("exist: " + exist(A, word));
		System.out.println("exist: " + exist(A, "SEE"));
		System.out.println("exist: " + exist(A, "ABCB"));
	}

	 private static boolean exist(char [][]  board, int row, int col, String word, int pos) {
		 if (pos >= word.length()) return true;
	       if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
	       if (board[row][col] != word.charAt(pos)) return false;
	       
	       char origC = board[row][col];
	       board[row][col] = '\0';
	       
	       int offset[][] = {{-1,0}, {1, 0}, {0, 1}, {0, -1}};
	       boolean found = false;
	       for(int i =0 ; i < 4; i++) {
	           if (exist(board, row+offset[i][0], col+offset[i][1], word, pos+1)) {
	               found = true;
	               break; 
	           }
	       }

	       board[row][col] = origC;
	       return found;
	   }
	
	    public static int exist(ArrayList<String> A, String word) {
	    	int row = A.size();
	    	int col = A.get(0).length();
	    	char [][] board = new char[row][col];
	    	
	    	for (int i=0; i<row; i++) {
	    		for (int j=0; j<col; j++) {
	    			board[i][j] = A.get(i).charAt(j);
	    		}
	    	}
	       for(int i = 0; i < board.length; i++)
	          for(int j = 0; j < board[0].length; j++)
	             if (exist(board, i,j, word, 0)) return 1;
	        return 0;
	    }
}
