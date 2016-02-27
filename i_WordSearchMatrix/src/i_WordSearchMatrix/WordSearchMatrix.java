package i_WordSearchMatrix;

import java.util.ArrayList;

public class WordSearchMatrix {

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
	   static boolean helper(char [][] board, String word, int i, int j, int k)
	    {
	        //if all char in the word has been found in the board
	        if (k == word.length())
	            return true;
	        //if not the correct way    
	        else if (i <0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || word.charAt(k) != board[i][j])
	            return false;
	        else 
	        {
	            char tmp = board[i][j];
	            board[i][j] = '#';
	            //if andy of all its neighbors matches, we found a solution
	            if (helper(board, word, i +1, j, k+1) ||
	                helper(board, word, i, j+1, k+1) ||
	                helper(board, word, i-1, j, k+1) ||
	                helper(board, word, i, j-1, k+1))
	                return true;
	            //otherwise, backtrack
	            board[i][j] = tmp;
	            
	            return false;            
	        }
	    }
	   
	    static int exist(ArrayList<String> A, String word) {
	    	int row = A.size();
	    	int col = A.get(0).length();
	    	char [][] board = new char[row][col];
	    	
	    	for (int i=0; i<row; i++) {
	    		for (int j=0; j<col; j++) {
	    			board[i][j] = A.get(i).charAt(j);
	    		}
	    	}
	    	
	        for(int i=0; i<row; i++)
	        {
	            for(int j=0; j<col; j++)
	            {
	                //find a char in the board match the first char of the word
	                if (board[i][j] == word.charAt(0))
	                {
	                    if (helper(board, word, i, j, 0))
	                        return 1;
	                }
	            }
	        }
	        
	        return 0;
	    }
}
