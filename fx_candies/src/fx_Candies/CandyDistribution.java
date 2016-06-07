package fx_Candies;

/*
There are N children standing in a line. Each child is assigned a rating value. 
You are giving candies to these children subjected to the following requirements:

1. Each child must have at least one candy.
2. Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?
*/
public class CandyDistribution {

	public static void main(String[] args) {
		CandyDistribution cd = new CandyDistribution();
		
		int [] A =  {1, 4, 3, 3, 3, 1};
		
		System.out.println("total candies: " + cd.candyDist(A));
		
	}
	
	public int candyDist(int [] ratings) {
		if (ratings == null || ratings.length < 1) {
			return 0;
		}
		
		int result = 0;
		int [] left = new int[ratings.length];
		left[0] = 1;
		
		//from left to right;
		for (int i=1; i<left.length; i++) {
			if (ratings[i] > ratings[i-1]) {
				left[i] = left[i-1] + 1;
			} else {
				left[i] = 1;
			}
		}
		
		result = left[left.length-1];
		
		//right to left;
		for (int i=ratings.length-2; i>=0; i--) {
			int curr = 1;
			if (ratings[i] > ratings[i+1]) {
				curr = left[i+1] + 1;
			}
			curr = Math.max(curr, left[i]);
			result += curr;
			left[i] = curr;
		}
		
		for (int x:  left) {
			System.out.print(x + " ");
		}
		System.out.println();
		return result;
		
		
	}
}
