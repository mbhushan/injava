package arr_CandyAssignment;

/*
 There are N children standing in a line. Each child is assigned a rating value. 
 You are giving candies to these children subjected to the following requirements:

1. Each child must have at least one candy.
2. Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?
 */
public class CandyAssignment {

	public int assignCandies(int [] ratings) {
		if (ratings == null || ratings.length < 1) {
			return 0;
		}
		int len = ratings.length;
		int [] candies = new int[len];
		
		candies[0] = 1;
		//scan from left to right;
		for (int i=1; i<len; i++) {
			if (ratings[i] > ratings[i-1]) {
				candies[i] = candies[i-1] + 1;
			} else {
				candies[i] = 1; //if not ascending then assign 1.
			}
		}
		int result = 0; 
		for (int i=len-2; i>=0; i--) {
			int current = 1;
			if (ratings[i] > ratings[i+1]) {
				current = candies[i+1] + 1;
			}
			result += Math.max(current, candies[i]);
			candies[i] = current;
		}
		System.out.println("candies assignments are: ");
		for (Integer a: candies) {
			System.out.print(a+ " ");
		}
		System.out.println();
		
		return result;
	}
	
	public static void main(String [] args) {
		int [] ratings = {1, 4, 3, 3, 3, 1};
		CandyAssignment CA = new CandyAssignment();
		System.out.println("min candies required: " + CA.assignCandies(ratings));
	}
}
