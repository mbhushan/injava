import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

	PriorityQueue<Integer> maxHeap;// = new PriorityQueue<Integer>(); // lower
																	// half.
	PriorityQueue<Integer> minHeap; //= new PriorityQueue<Integer>(); // higher
																	// half.

	public MedianFinder() {
		maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
		//maxHeap = new PriorityQueue<Integer>(); 
		minHeap = new PriorityQueue<Integer>();
	}

	public void addNum(int num) {
		maxHeap.add(num);
		minHeap.add(maxHeap.poll());
		if (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			return (double) (maxHeap.peek() + (minHeap.peek())) / 2;
		} else {
			return maxHeap.peek();
		}
	}

	public static void main(String[] args) {
		MedianFinder MF = new MedianFinder();
		int[] A = { 2, 3, 9, 8, 7, 6, 5, 1, 4 };
		
		for (int i=0; i<A.length; i++) {
			MF.addNum(A[i]);
			System.out.println("median so far: " + MF.findMedian());
		}
	}
}
