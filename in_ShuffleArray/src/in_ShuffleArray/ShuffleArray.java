package in_ShuffleArray;

import java.util.Random;

/*
Shuffle a given array such that each position is equally likely.

The basic idea of the fisher yates is this:


|1 2 3 4 5
Do a swap of 1 and random(1,2,3,4 5) = 3
3|2 1 4 5
Do a swap of 2 ad random(1, 2, 4, 5) = 4
3 4 | 1 2 5
Notice how after something it swapped, it is no longer available for swap. 
Therefore on the first pass there was a 1/n chance of any one element being picked to swap. 
And on the second we never look at that element again so there is a 1/(n-1) chance of picking any single element on the second pass.
so on the n'th pass there is a 1/1 chance of picking that element.
Therefore each permutation has the probabily of 1/(n!) which is perfectly "random".
*/

public class ShuffleArray {

	public static void main(String[] args) {
		ShuffleArray sa = new ShuffleArray();
		
		int [] A = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		sa.shuffle(A);
	}
	
	public void shuffle(int [] A) {
		int len = A.length;
		
		Random rand = new Random();
		
		for (int i=0; i<len; i++) {
			int r = rand.nextInt(len-i) + i;
			int temp = A[r];
			A[r] = A[i];
			A[i] = temp;
		}
		
		System.out.println("after shuffle:");
		for (int x: A) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
