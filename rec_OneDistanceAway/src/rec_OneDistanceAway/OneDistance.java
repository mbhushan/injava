package rec_OneDistanceAway;

/*
 * Given two strings S and T, determine if they are both one edit distance apart.
 * Time complexity O(n)
 * Space complexity O(1)
 *
 * https://leetcode.com/problems/one-edit-distance/
 */
public class OneDistance {

	public static void main(String[] args) {
		OneDistance od = new OneDistance();
		
		String s1 = "mani";
		String s2 = "manimani";
		
		System.out.println("is one distance away: " + od.isOneDistance(s1, s2));
		 System.out.println(od.isOneDistance("cat", "dog"));
	        System.out.println(od.isOneDistance("cat", "cats"));
	        System.out.println(od.isOneDistance("cat", "cut"));
	        System.out.println(od.isOneDistance("cats", "casts"));
	        System.out.println(od.isOneDistance("catsts", "casts"));
	}
	
	public boolean isOneDistance(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		
		int dist = isOneDistance(s1.toCharArray(), 0, s2.toCharArray(), 0) ;
		System.out.println("distance: " + dist);
		return dist == 1;
	}
	
	public int isOneDistance(char [] A, int i, char [] B, int j) {
		
		if (i == A.length) {
			return B.length - j;
		} else if (j == B.length) {
			return A.length - i;
		}
		
		if (A[i] == B[j]) {
			return isOneDistance(A, i+1, B, j+1);
		} else {
			return 1 + Math.min(Math.min(isOneDistance(A, i+1, B, j), isOneDistance(A, i, B, j+1)), isOneDistance(A, i+1, B, j+1));  
			//return 1 + Math.min(isOneDistance(A, i+1, B, j), isOneDistance(A, i, B, j+1));  
		}
	}
	
}
