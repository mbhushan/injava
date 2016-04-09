package u_DataStreamMedian;

public class StreamMedianDriver {
	public static void main(String [] args) {
		StreamMedian SM = new StreamMedian();
		
		int [] S = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
		
		for (int i=0; i<S.length; i++) {
			SM.addNumber(S[i]);
			System.out.println("median so far: " + SM.findMedian());
		}
	}
}
