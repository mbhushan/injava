package i_CandyRatings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CandyRatings {
	
	public static void main(String[] args) {
		Integer [] X = {1, 2};
		ArrayList<Integer> ratings = new ArrayList<Integer>();
		
		Collections.addAll(ratings, X);
		System.out.println("total candies: " + candy(ratings));
	}

	public static int candy(ArrayList<Integer> ratings) {
		int N = ratings.size();
		Integer [] leftCandy = new Integer[N];
		Integer [] rightCandy = new Integer[N];
		Arrays.fill(leftCandy, 1);
		Arrays.fill(rightCandy, 1);
		
		int ans = 0;
		
		for (int i=1; i<N; i++) {
			if (ratings.get(i).intValue() > ratings.get(i-1).intValue()) {
				leftCandy[i] = leftCandy[i-1] + 1;
			}
		}
		
		for (int i=N-2; i>=0; i--) {
			if (ratings.get(i).intValue() > ratings.get(i+1).intValue()) {
				rightCandy[i] = rightCandy[i+1] + 1;
			}
		}
		
		for (int i=0; i<N; i++) {
			ans += Math.max(leftCandy[i], rightCandy[i]);
		}
		
		return ans;
	}
}
