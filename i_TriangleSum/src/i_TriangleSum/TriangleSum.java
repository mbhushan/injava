package i_TriangleSum;

import java.util.ArrayList;

import javax.swing.text.html.MinimalHTMLWriter;

public class TriangleSum {

	public static void main(String[] args) {
		int [][] T = {{2},
			    {3,4},
			    {6,5,7},
			   {4,1,8,3}};
		
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<T.length; i++) {
			ArrayList<Integer> A = new ArrayList<Integer>();
			for (int j=0; j<T[i].length; j++) {
				A.add(T[i][j]);
			}
			triangle.add(A);
		}
		System.out.println("minimum sum in a triangle: " + minimumTotal(triangle));
	}
	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int[] total = new int[triangle.size()];
		int l = triangle.size() - 1;
	 
		for (int i = 0; i < triangle.get(l).size(); i++) {
			total[i] = triangle.get(l).get(i);
		}
	 
		// iterate from last second row
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
				total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
			}
		}
	 
		return total[0];
	}
}
