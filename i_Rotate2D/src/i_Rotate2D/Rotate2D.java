package i_Rotate2D;

import java.util.ArrayList;

public class Rotate2D {
	public static void rotate(ArrayList<ArrayList<Integer>> a) {
		int r = a.size();
		int c = a.get(0).size();
		
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				System.out.print(a.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
		a = rotateByNinetyToRight(a, r, c);
		
		System.out.println("After 90 degree rotation: ");
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				System.out.print(a.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String [] args) {
		int [][] m = {{1,2},{3,4}};
		
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		int r = m.length;
		int c = m[0].length;
		
		for (int i=0; i<r; i++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			for (int j=0; j<c; j++) {
				row.add(m[i][j]);
			}
			a.add(row);
		}
		rotate(a);
		
	}
	
	public static ArrayList<ArrayList<Integer>> rotateByNinetyToRight(ArrayList<ArrayList<Integer>> m, int r, int c) {
        // transpose
        m = transpose(m, r, c);

        // swap columns
        for (int  j = 0; j < c/2; j++) {
            for (int i = 0; i < r ; i++) {
                int x = m.get(i).get(j);
                m.get(i).set(j, m.get(i).get(c -1 -j)); 
                m.get(i).set(c -1 -j, x);
            }
        }
        
        return m;
    }
	
	private static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> m, int r, int c) {

        for (int i = 0; i < r; i++) {
            for (int j = i; j < c; j++) {
                int x = m.get(i).get(j);
                m.get(i).set(j, m.get(j).get(i));
                m.get(j).set(i, x);
            }
        }
        
        return m;
    }
}
