package rand_Rand7Rand5;

import java.util.HashMap;
import java.util.Random;

public class Rand7Rand5 {

	public static void main(String [] args) {
		Rand7Rand5 RR = new Rand7Rand5();
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for (int i=0; i<700000000; i++) {
			int r = RR.rand7();
			int count = 1;
			if (hmap.containsKey(r)) {
				count += hmap.get(r); 
			}
			hmap.put(r, count);
		}
		
		System.out.println("printing random values with rand7() and their freuquency.");
		for (Integer r: hmap.keySet()) {
			System.out.println(r + ": " + hmap.get(r));
		}
	}
	
	public int rand7() {
		int [][]vals = {
		        { 1, 2, 3, 4, 5 },
		        { 6, 7, 1, 2, 3 },
		        { 4, 5, 6, 7, 1 },
		        { 2, 3, 4, 5, 6 },
		        { 7, 0, 0, 0, 0 }
		    };
		int result = 0;
		Random rand = new Random();
		while (result == 0) {
			int i = rand.nextInt(5)+1;
			int j = rand.nextInt(5)+1;
			result = vals[i-1][j-1];
		}
		return result;
	}
}
