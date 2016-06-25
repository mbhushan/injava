package dp_CountDerangements;
/*
Count Derangements (Permutation such that no element appears in its original position)
A Derangement is a permutation of n elements, such that no element appears in its original position. 
For example, a derangement of {0, 1, 2, 3} is {2, 3, 1, 0}.

Given a number n, find total number of Derangements of a set of n elements.
Input: n = 2
Output: 1
For two elements say {0, 1}, there is only one 
possible derangement {1, 0}

Input: n = 3
Output: 2
For three elements say {0, 1, 2}, there are two 
possible derangements {2, 0, 1} and {1, 2, 0}

Input: n = 4
Output: 9
For four elements say {0, 1, 2, 3}, there are 9
possible derangements {1, 0, 3, 2} {1, 2, 3, 0}
{1, 3, 0, 2}, {2, 3, 0, 1}, {2, 0, 3, 1}, {2, 3,
1, 0}, {3, 0, 1, 2}, {3, 2, 0, 1} and {3, 2, 1, 0}
*/
public class CountDerangements {

	public static void main(String[] args) {
		CountDerangements cd = new CountDerangements();
		
		int n = 5;
		for (int i=0; i<=n; i++) {
			System.out.println("derangements for " + i + " keys: " + cd.countDerangements(i));
		}
	}
	
	public int countDerangements(int n) {
		if (n == 0 || n == 1) {
			return 0;
		}
		if (n == 2 || n == 3) {
			return n-1;
		}
		return (n-1) + (n-1)*countDerangements(n-1);
	}
}
