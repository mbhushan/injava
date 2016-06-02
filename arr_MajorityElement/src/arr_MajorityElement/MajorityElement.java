package arr_MajorityElement;

public class MajorityElement {

	public static void main(String[] args) {
		MajorityElement ME = new MajorityElement();
		int [][] A = {
					{2, 2, 3, 5, 2, 2, 6},
					{1, 2, 2, 3, 3, 4, 4}
				};
		for (int i=0; i<A.length; i++) {
				int index = ME.majorityElement(A[i]);
				if (index != -1) {
					System.out.println("majority element: " + A[i][index]);
				} else {
					System.out.println("no majority element found!");
				}
		}
	}
	
	public int majorityElement(int [] A) {
		int maj_index = 0;
		int count = 1;
		
		for (int i=1; i<A.length; i++) {
			if (A[maj_index] == A[i]) {
				++count;
			} else {
				--count;
			}
			if (count == 0) {
				maj_index = i;
				count = 1;
			}
		}
		count = 0;
		for (int i=0; i<A.length; i++) {
			if (A[maj_index] == A[i]) {
				++count;
			}
			if (count > (A.length/2)) {
				return maj_index;
			}
		}
		return -1;
	}
}
