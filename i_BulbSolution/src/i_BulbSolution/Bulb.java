package i_BulbSolution;

import java.util.ArrayList;

public class Bulb {
	
	public static void main(String[] args) {
		int [] X = {0, 1, 0, 1};
		ArrayList<Integer> A = new ArrayList<Integer>();
		
		for (int i=0; i<X.length; i++) {
			A.add(X[i]);
		}
		
		System.out.println("bulbs: " + bulbs(A));
	}

	 public static int bulbs(ArrayList<Integer> a) {
		 int state= 0, ans = 0;
		 int N = a.size();
		    for (int i = 0; i < N;i++) {
		        if (a.get(i).intValue() == state) {
		            ans++;
		            state = 1 - state;
		        }
		    }
		     
		    return ans;
	 }
}
