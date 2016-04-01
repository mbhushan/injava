package u_InversionCount;

public class InversionCount {

	static int [] data = {1, 20, 6, 4, 5};
	public static void main(String[] args) {

		System.out.println("inversion count: " + inversionCountNaive(data));
		System.out.println("inversion count: " + mergeSort(0, data.length-1));

	}
	
	private static int mergeSort(int low, int high) {
		int invCount = 0;
		if (low < high) {
			int mid = low + (high - low) / 2;
			invCount += mergeSort(low, mid);
			invCount += mergeSort(mid+1, high);
			invCount += merge(low, mid, high);
		}
		return invCount;
	}
	
	private static int merge(int low,int mid, int high) {
		int len1 = mid - low + 1;
		int len2 = high - mid;
		int invCount = 0;
		
		Integer [] left = new Integer[len1+1];
		Integer [] right = new Integer[len2 + 1];
		
		for (int i=0; i<len1; i++) {
			left[i] = data[low + i];
		}
		
		for (int j=0; j<len2; j++) {
			right[j] = data[mid + j + 1];
		}
		
		left[len1] = Integer.MAX_VALUE;
		right[len2] = Integer.MAX_VALUE;
		
		int i=0, j=0;
		
		for (int k=low; k<= high; k++) {
			if (left[i] <= right[j]) {
				data[k] = left[i];
				++i;
			} else {
				invCount += (mid - i);
				data[k] = right[j];
				++j;
			}
		}
		return invCount;
	}
	
	//naive method - O(n^2) complexity
	public static int inversionCountNaive(int [] A) {
		if (null == A) {
			return 0;
		}
		int len = A.length;
		int invCount = 0;
		for (int i=0; i<len-1; i++) {
			for (int j=i+1; j<len; j++) {
				if (A[i] > A[j]) {
					++invCount;
				}
			}
		}
		return invCount;
	}
	
	
}
