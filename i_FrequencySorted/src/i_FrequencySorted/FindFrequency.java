package i_FrequencySorted;

public class FindFrequency {

	
	public static void main(String[] args) {
	    int[] A = new int[] { 1 ,2, 4, 4, 4, 4, 4, 7, 8, 9 };
	    
	    int K = 4;
	    int start = 0;
	    int end = A.length-1;
	    boolean firstIndex = true;
	    int startPos = findFrequency(A, K, start, end, firstIndex);
	    System.out.println("first position: " + startPos);
	    int endPos = findFrequency(A, K, startPos, end, false);	
	    System.out.println("end position: " + endPos);
	    System.out.println("total items: " + (endPos - startPos + 1));
	}
	
	public static int findFrequency(int []A, int K, int start, int end, boolean firstIndex) {
		int position = -1;
		
		while (start <= end) {
			int mid = start + (end - start)/2;
			
			if (A[mid] == K) {
				position = mid;
				if (firstIndex) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (A[mid] > K) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return position;
	}
}
