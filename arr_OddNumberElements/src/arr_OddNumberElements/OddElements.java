package arr_OddNumberElements;

public class OddElements {

	public static void main(String[] args) {
		OddElements OE = new OddElements();
		 int A [] = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
		 System.out.println("odd element: " + OE.oddElement(A));
	}
	
	public int oddElement(int [] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		
		int result = 0;
		for (int i=0; i<A.length; i++) {
			result = result ^ A[i];
		}
		return result;
	}
}
