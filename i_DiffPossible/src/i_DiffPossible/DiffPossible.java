package i_DiffPossible;

import java.util.ArrayList;
import java.util.Collections;

public class DiffPossible {
	public static int diffPossible(ArrayList<Integer> a, int b) {
		int ans = 0;
		int size = a.size();
        int i = 0, j = 1;
 
        // Search for a pair
        while (i < size && j < size) {
            if (i != j && a.get(j)-a.get(i) == b) {
                System.out.println("Pair Found: "+ "( "+a.get(i)+", "+ a.get(j)+" )");
                ans = 1;
                break;
            }
            else if (a.get(j) - a.get(i) < b) {
                j++;
            } else {
                i++;
            }
        }
        return ans;
	}
	
	public static void main(String[] args) {
		//int [] A = {5, 20, 3, 2, 50, 80};
		int [] A = {90, 70, 20, 80, 50};

		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		Collections.sort(X);
		int b = 78;
		System.out.println("diff possible: " + diffPossible(X, b));
	}
}
