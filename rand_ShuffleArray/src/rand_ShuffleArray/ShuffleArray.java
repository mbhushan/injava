package rand_ShuffleArray;

import java.util.Random;

public class ShuffleArray {

	public void shuffle(int [] A) {
		Random rand = new Random();
		for (int i=A.length-1; i>=0; i--) {
			int r = rand.nextInt(i+1);
			int temp = A[r];
			A[r] = A[i];
			A[i] = temp;
		}
	}
	
	public static void main(String [] args) {
		int [] A = {1,2,3,4,5,6,7,8};
		ShuffleArray SA = new ShuffleArray();
		SA.shuffle(A);
		for (Integer i: A) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
