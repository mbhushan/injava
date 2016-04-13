package rand_RandomNumInStream;

import java.util.Random;

public class RandomStream {

	public int [] randomSelection(int [] S, int K) {
		int [] result = new int[K];
		for (int i=0; i<K; i++) {
			result[i] = S[i];
		}
		
		Random rand = new Random();
		for (int i=K; i<S.length; i++) {
			int key = rand.nextInt(i) + 1;
			if (key <= result.length) {
				result[key-1] = S[i];
			}
		}
		return result;
	}
	public static void main(String [] args) {
		RandomStream RS = new RandomStream();
		int [] S = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		int K = 5;
		int [] result = RS.randomSelection(S, K);
		for (Integer r: result) {
			System.out.print(r + " ");
		}
		System.out.println();
	}
}
