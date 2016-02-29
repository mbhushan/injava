package i_SurroundingCapture;

import java.util.ArrayList;

public class Surrounding {

	public static void main(String[] args) {
		
		String [] S = {"XXXX", "XOOX", "XXOX","XOXX"};
		ArrayList<ArrayList<Character>> A = new ArrayList<ArrayList<Character>>();
		for (int i=0; i<S.length; i++) {
			char [] chArr = S[i].toCharArray();
			ArrayList<Character> C = new ArrayList<Character>();
			for (char ch: chArr) {
				C.add(ch);
			}
			A.add(C);
		}
		
		solve(A);
		for (ArrayList<Character> r: A) {
			System.out.println(r);
		}
		
	}
	
	public static void solve(ArrayList<ArrayList<Character>> board) {
		int m = board.size();
		int n = board.get(0).size();
//		char [][] board = new char[m][n];
		
		 for(int i=0;i<m;i++){
		        if(board.get(i).get(0).charValue() == 'O'){
		            merge(board, i, 0);
		        }
		 
		        if(board.get(i).get(n-1).charValue() == 'O'){
		            merge(board, i,n-1);
		        }
		    }
		 
		    //merge O's on top & bottom boarder
		    for(int j=0; j<n; j++){
		         if(board.get(0).get(j).charValue() == 'O'){
		            merge(board, 0,j);
		        }
		 
		        if(board.get(m-1).get(j).charValue() == 'O'){
		            merge(board, m-1,j);
		        }
		    }
		 
		    //process the board
		    for(int i=0;i<m;i++){
		        for(int j=0; j<n; j++){
		            if(board.get(i).get(j).charValue()  == 'O'){
		            	board.get(i).set(j, 'X');
		            }else if(board.get(i).get(j).charValue()  == '#'){
		            	board.get(i).set(j, 'O');
		            }
		        }
		    }
	}
	
	public static void merge(ArrayList<ArrayList<Character>>  board, int i, int j){
	    if(i<0 || i>=board.size() || j<0 || j>=board.get(0).size()) 
	        return;
	 
	    if(board.get(i).get(j).charValue() != 'O')
	        return;
	 
	    //board[i][j] = '#';
	    board.get(i).set(j, '#');
	 
	    merge(board, i-1, j);
	    merge(board, i+1, j);
	    merge(board, i, j-1);
	    merge(board, i, j+1);
	}
}
