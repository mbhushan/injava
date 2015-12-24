package i_Spiral2;

import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Integer>> generateMatrix(int a) {
		int i, k = 0, l = 0;
		ArrayList<ArrayList<Integer>>  matrix = new ArrayList<ArrayList<Integer>> ();
		int [][] R = new int[a][a];
		 
		int m = a;
		int n = a;
		int num = 1;
	 
	    while (k < m && l < n) {
	        for (i = l; i < n; ++i) {
	            R[k][i] = num++;
	        }
	        k++;
	 
	        for (i = k; i < m; ++i) {
	            R[i][n-1] = num++;
	        }
	        n--;
	 
	        if ( k < m) {
	            for (i = n-1; i >= l; --i)
	            {
	               R[m-1][i] = num++;
	            }
	            m--;
	        }
	 
	        if (l < n) {
	            for (i = m-1; i >= k; --i)
	            {
	                R[i][l] = num++;
	            }
	            l++;    
	        }        
	    }
	    
	    for (i = 0; i < a; i++) {
	    	ArrayList<Integer> row = new ArrayList<Integer>();
	        for (int j = 0; j < a; j++) {
	            System.out.print(R[i][j] + " ");
	            row.add(R[i][j]);
	        }
	        matrix.add(row);
	        System.out.print("\n");
	    }
	    
	    return matrix;
	}
	
	public static void main(String [] args) {
		int n = 80;
		generateMatrix(n);
	}
}
