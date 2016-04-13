package rand_Rand7Rand5;

import java.util.HashMap;
import java.util.Random;

public class RandomSelectionPopulation {
	
	public int getRandSelection(int [] A) {
		int [] runningSum = new int[A.length];
		runningSum[0] = A[0];
		int N = A[0];
		for (int i=1; i<A.length; i++) {
			runningSum[i] = runningSum[i-1] + A[i];
			N += A[i];
		}
		Random rand = new Random();
		int rnum = rand.nextInt(N) + 1;
		int low = 0;
		int high = A.length - 1;
		int mid = low + (high-low)/2;
		
		while (true) {
			if (runningSum[mid] >= rnum && (mid-1 == -1 || runningSum[mid-1] < rnum)) {
				break;
			}
			if (runningSum[mid] > rnum) {
				high = mid-1;
			} else {
				low = mid+1;
			}
			 mid = low + (high-low)/2;
		}
		return A[mid];
 	}

	public static void main(String [] args) {
		RandomSelectionPopulation RSP = new RandomSelectionPopulation();
		int [] A = {5, 5, 5, 2, 2, 7, 1, 1, 1, 1};

		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for (int i=0; i<10000000; i++) {
			int key = RSP.getRandSelection(A);
			int count = 1;
			if (hmap.containsKey(key)) {
				count += hmap.get(key);
			}
			hmap.put(key, count);
		}
		
		for (Integer key: hmap.keySet()) {
			System.out.println(key + ": " + hmap.get(key));
		}
	}
}
