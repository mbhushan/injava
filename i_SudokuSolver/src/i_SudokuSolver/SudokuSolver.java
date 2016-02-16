package i_SudokuSolver;

import java.util.ArrayList;

public class SudokuSolver {

	public static void main(String[] args) {
		String [] st = {"53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
		ArrayList<ArrayList<Character>> a = new ArrayList<ArrayList<Character>>();
		for (int i=0; i<st.length; i++) {
			String s = st[i];
			ArrayList<Character> x = new ArrayList<Character>();
			char [] cArray = s.toCharArray();
			for(char c : cArray) {
			    x.add(c);
			}
			a.add(x);
			
		}
		
		solveSudoku(a);
	}
	
	public static void solveSudoku(ArrayList<ArrayList<Character>> a) {
		int rw = a.size();
		int col = a.get(0).size();
		
		char [][] grid = new char[rw][col];
		
		for (int i=0; i<rw; i++) {
			for (int j=0; j<col; j++) {
				grid[i][j] = a.get(i).get(j).charValue();
			}
		}
		
		if (grid.length == 0){
            return;
        }
        
        solved(grid);
        a.clear();
        for (int i=0; i<rw; i++) {
        	ArrayList<Character> x = new ArrayList<Character>();
			for (int j=0; j<col; j++) {
				x.add(grid[i][j]);
			}
			a.add(x);
		}
        
	}
	
	private static boolean solved(char[][] board){
	      
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j]=='.'){
                    for (char num='1'; num<='9'; num++){
                        
                        if(isValid(board, i, j, num)){
                            // no conflict
                            board[i][j]=num;
                            
                            if (solved(board)){
                                return true;
                            }
                            else{
                                board[i][j]='.';
                            }
                            
                        }
                      
                    }
                    // if no proper number found, return false
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static boolean isValid(char[][] board, int i, int j, char c){
     
        // check column
        for (int row=0; row<9; row++){
            if (board[row][j]==c){
                return false;
            }
           
             
        }
        
       // check row
        for (int col=0; col<9; col++){
            if (board[i][col]==c){
                return false;
            }
            
        }
      
        // check block
        for(int row=i/3*3; row<i/3*3+3; row++){
            for (int col=j/3*3; col<j/3*3+3; col++){
                if (board[row][col]==c){
                    return false;
                }
                
            }
        }
       
        return true;
        
    }
}
