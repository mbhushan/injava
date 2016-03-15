package gfg_SunFacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
An array of buildings is facing the sun. The heights of the building is given in an array. 
You have to tell which all buildings will see the sunset.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the number of buildings.
The second line of each test case contains N input H[i],height of building.

Output:

Print the total number of buildings which will see the sunset.

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 500
1 ≤ H[i] ≤ 1000

Example:

Input:
2
5
7 4 8 2 9
4
2 3 4 5

Output:
3
4
*/
public class SunFacing {
	
	public static void main(String[] args) {
		int [] A = {7, 4, 8, 2, 9};
		//System.out.println("total sun facing: " + getSunFacing(A));
		
		int [] B = {2, 3, 4, 5};
		//System.out.println("total sun facing: " + getSunFacing(B));
		readInput();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<Integer>();
		try {
			String in = br.readLine().trim();
			int tc = Integer.parseInt(in);
			while (tc > 0) {
				int n = Integer.parseInt(br.readLine().trim());
					String [] sArr = br.readLine().split(" ");
					int [] buildings = new int[n];
					for (int i=0; i<n; i++) {
						buildings[i] = Integer.parseInt(sArr[i].trim());
					}
					int ans = getSunFacing(buildings);
					list.add(ans);
				--tc;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i: list) {
			System.out.println(i);
		}
		
	}
	
	public static int getSunFacing(int [] buildings) {
		int size = buildings.length;
		if (size <= 1) {
			return size;
		}
		
		int last = buildings[0];
		int count = 1;
		for (int i=1; i<size; i++) {
			if (buildings[i] > last) {
				++count;
				last = buildings[i];
			}
			
		}
		
		return count;
	}

}
