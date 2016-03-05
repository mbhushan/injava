package i_DungeonPrincess;

import java.util.ArrayList;
import java.util.Collections;

public class DungeonPrincess {
	
	public static void main(String[] args) {
		Integer [] A = {-2, -3, 3};
		Integer [] B = {-5, -10, 1};
		Integer [] C = {10, 30, -5};
		
		ArrayList<Integer> X = new ArrayList<Integer>();
		ArrayList<Integer> Y = new ArrayList<Integer>();
		ArrayList<Integer> Z = new ArrayList<Integer>();
		
		Collections.addAll(X, A);
		Collections.addAll(Y, B);
		Collections.addAll(Z, C);
		
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>> ();
		
		a.add(X); a.add(Y); a.add(Z);
		
		System.out.println("min health: " + MinimumHP(a));
				
	}

	public static int MinimumHP(ArrayList<ArrayList<Integer>> a) {
		int m = a.size();  
		int n = a.get(0).size();  
		int [][] dungeon = new int[m][n];
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				dungeon[i][j] = a.get(i).get(j);
			}
		}
		 
		if(dungeon==null || dungeon.length==0 || dungeon[0].length==0) return 1;  

		   int[] hp=new int[n];  
		   hp[n-1]=Math.max(1,1-dungeon[m-1][n-1]);  
		   for(int j=n-2;j>=0;j--){  
		     hp[j]=Math.max(1,hp[j+1]-dungeon[m-1][j]);  
		   }  
		   for(int i=m-2;i>=0;i--){  
		     hp[n-1]=Math.max(1,hp[n-1]-dungeon[i][n-1]);  
		     for(int j=n-2;j>=0;j--){  
		       hp[j]=Math.max(1,Math.min(hp[j],hp[j+1])-dungeon[i][j]);  
		     }  
		   }  
		   return hp[0];  
	}
}
