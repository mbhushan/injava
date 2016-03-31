package u_NutsBolts;

/*
 Nuts & Bolts Problem (Lock & Key problem)
Given a set of n nuts of different sizes and n bolts of different sizes. 
There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently.
SOLUTION:
This algorithm first performs a partition by picking last element of bolts array as pivot, 
rearrange the array of nuts and returns the partition index ‘i’ such that all nuts smaller 
than nuts[i] are on the left side and all nuts greater than nuts[i] are on the right side. 
Next using the nuts[i] we can partition the array of bolts. Partitioning operations can easily 
be implemented in O(n). This operation also makes nuts and bolts array nicely partitioned. 
Now we apply this partitioning recursively on the left and right sub-array of nuts and bolts.
 */

public class NutsBolts {

	public static void main(String [] args) {
		// Nuts and bolts are represented as array of characters
        char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};
        
        matchPairs(nuts, bolts, 0, nuts.length-1);
        printArray(nuts);
        printArray(bolts);
	}
	
	 // Similar to standard partition method. Here we pass the pivot element
    // too instead of choosing it inside the method.
	private static int partition(char [] A, int low, int high, int pivot) {
		
		int j = low;
		for (int i=low; i<high; i++) {
			
			if (A[i] < pivot) {
				char ch = A[i];
				A[i] = A[j];
				A[j] = ch;
				++j;
			} else if (A[i]  == pivot) {
				char ch = A[i];
				A[i] = A[high];
				A[high] = ch;
				--i;
			}
		}
		char ch = A[j];
		A[j] = A[high];
		A[high] = ch;
		
		return j;
	}
	
	public static void matchPairs(char [] nuts, char []bolts, int low, int high) {
		if (low < high) {
			int pivot = partition(nuts, low, high, bolts[high]);
			partition(bolts, low, high, nuts[pivot]);
			
			matchPairs(nuts, bolts, low, pivot-1);
			matchPairs(nuts, bolts, pivot+1, high);
		}
	}
	
	public static void printArray(char [] arr) {
		for (char ch: arr) {
			System.out.print(ch + " ");
		}
		System.out.println();
	}
}
