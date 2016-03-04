package i_SeatArrangement;

import java.util.ArrayList;

public class SeatArrangement {

	public static int seats(String A) {
		
		A = A.toLowerCase();
		int N = A.length();
		ArrayList<Integer> positions = new ArrayList<Integer>();
		
		for (int i=0; i<N; i++) {
			if (A.charAt(i) == 'x') {
				positions.add(i);
			}
		}
		
		int size = positions.size();
		int mid = -1;
		int emid1 = -1, emid2 = -1;
		if (size%2 == 1) {
			mid = (size - 1)/2;
		} else {
			
		}
				
		
	}
}
