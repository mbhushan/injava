package u_DataStreamMedian;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Find median in stream of numbers
 * 
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class StreamMedian {

	private PriorityQueue<Integer> minPQ;
	private PriorityQueue<Integer> maxPQ;
	
	public StreamMedian() {
		minPQ = new PriorityQueue<Integer>();
		maxPQ = new PriorityQueue<Integer>(20, Collections.reverseOrder());
	}
	
	
	public double findMedian() {
		double result = 0.0;
		
		if (minPQ.size() == maxPQ.size()) {
			result = ((double)minPQ.peek() + (double)maxPQ.peek())/2.0;
		} else {
			result = maxPQ.peek();
		}
		return result;
	}
	
	public void addNumber(int num) {
		if (maxPQ.isEmpty()) {
			maxPQ.add(num);
			return;
		}
		
		if (maxPQ.size() == minPQ.size()) {
			if (num > minPQ.peek()) {
				maxPQ.offer(minPQ.poll());
				minPQ.offer(num);
			} else {
				maxPQ.offer(num);
			}
		} else {
			int toOffer = 0;
			if (num >= maxPQ.peek()) {
				toOffer = num;
			} else {
				toOffer = maxPQ.poll();
				maxPQ.offer(num);
			}
			minPQ.offer(toOffer);
		}
	}
	
}
