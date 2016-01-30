package i_SolveNQueens;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
	
	public static void main(String[] args) {
		int n = 4;
		ArrayList<ArrayList<String>> result = solveNQueens(n);
		for (ArrayList<String> R: result) {
			System.out.println(R);
		}
	}

	public static ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		if (n < 1) {
			return result;
		}

		ArrayList<String> rows = new ArrayList<String>();
		for (int i=0; i<n; i++) {
			rows.add("");
		}

		int row = 0;

		solutions(row, n, rows, result);

		return result;
	}
	
	private static void solutions(int stRow, int n, ArrayList<String> rows, ArrayList<ArrayList<String>> result ){
        if (stRow>=n){
            result.add(rows);
            return;
        }
        
        for(int col=0; col<n; col++){
            if (!isValid(col, stRow,  rows)){
                continue;
                
            }
            
            char[] chars=new char[n];
            Arrays.fill(chars, '.');
            chars[col]='Q';
            
            
            rows.set(stRow, String.copyValueOf(chars));
            solutions(stRow+1, n, rows, result);
            
        }
        
    }
	
	private static boolean isValid(int col,int stRow,  ArrayList<String> rows){
        // checkColumn
        for (int i=0; i<stRow; i++){
            int qCol=rows.indexOf("Q");
            
            if (qCol==col){
                return false;
            }
            
            int rowDistance=Math.abs(stRow-i);
            int colDistance=Math.abs(col-qCol);
            
            if (rowDistance==colDistance){
                return false;
            }
            
        }
        
        return true;
        
    }
}
