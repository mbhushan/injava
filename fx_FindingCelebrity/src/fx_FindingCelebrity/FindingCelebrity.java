package fx_FindingCelebrity;

/*
The Celebrity Problem
Another classical problem.

In a party of N people, only one person is known to everyone. Such a person may be present in the party, 
if yes, (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “. 
Find the stranger (celebrity) in minimum number of questions.

We can describe the problem input as an array of numbers/characters representing persons in the party. 
We also have a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, false otherwise. 
How can we solve the problem, try yourself first.

We measure the complexity in terms of calls made to HaveAcquaintance().
 */
public class FindingCelebrity {

	public static void main(String[] args) {
		FindingCelebrity FC = new FindingCelebrity();
		System.out.println("celebrity: " + FC.findCelebrity());
	}
	
	public int findCelebrity() {
		int people = 4;
		int a = 0;
		for (int i=1; i<people-1; i++) {
			if (like(a, i)) {
				a = i;
			}
		}
		for (int i=0; i<people; i++) {
			if (i == a) {
				continue;
			}
			if (!like(i, a)) {
				return -1;
			}
		}
		return a+1;
	}
	
	public boolean like(int i, int j) {
		int [][] M = {
				{0, 0, 1, 0}, 
				{0, 0, 1, 0}, 
				{0, 0, 0, 0}, 
				{0, 0, 1, 0}
		};
		if (M[i][j] == 1) {
			return true;
		}
		return false;
	}
	
}
