package ss_FindKClosest;

public class FindKClosest {

	public int findCrossOver(int[] A, int low, int high, int x) {
		if (x < A[low]) {
			return low;
		}
		if (x >= A[high]) {
			return high;
		}

		int mid = low + (high - low) / 2;

		if (A[mid] <= x && A[mid + 1] > x) {
			return mid;
		}

		if (A[mid] < x) {
			return findCrossOver(A, mid + 1, high, x);
		}
		return findCrossOver(A, low, mid - 1, x);
	}

	void printKclosest(int arr[], int x, int k, int n) {
		// Find the crossover point
		int l = findCrossOver(arr, 0, n - 1, x);
		int r = l + 1; // Right index to search
		int count = 0; // To keep track of count of elements
						// already printed

		// If x is present in arr[], then reduce left index
		// Assumption: all elements in arr[] are distinct
		if (arr[l] == x)
			l--;

		// Compare elements on left and right of crossover
		// point to find the k closest elements
		while (l >= 0 && r < n && count < k) {
			if (x - arr[l] < arr[r] - x)
				System.out.print(arr[l--] + " ");
			else
				System.out.print(arr[r++] + " ");
			count++;
		}

		// If there are no more elements on right side, then
		// print left elements
		while (count < k && l >= 0) {
			System.out.print(arr[l--] + " ");
			count++;
		}

		// If there are no more elements on left side, then
		// print right elements
		while (count < k && r < n) {
			System.out.print(arr[r++] + " ");
			count++;
		}
	}

	public static void main(String[] args) {
		FindKClosest FK = new FindKClosest();
		
		int A[] = {12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56
               };
		int x = 35;
		int k = 4;
		
		FK.printKclosest(A, x, k, A.length);

	}
}
