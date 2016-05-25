package fx_IntervalOps;

import java.util.ArrayList;

/*
Now create a function to merge a new interval into a group of sorted, 
non-intersecting intervals. After the merge, all intervals should remain non-intersecting. You are given the function definition below.
*/
public class IntervalOps {

	public static void main(String[] args) {
		Interval [] intervals1 = {
				new Interval(1,5),
				new Interval(6, 15),
				new Interval(20, 21),
				new Interval(23, 26),
				new Interval(27, 30),
				new Interval(35, 40) 
		};
		
		Interval [] intervals = {
				new Interval(1,4),
				new Interval(6,10), 
				new Interval(14, 19)
		};
		Interval newInterval = new Interval(14, 33);
		
		IntervalOps IO = new IntervalOps();
		
		ArrayList<Interval> result = IO.mergeInterval(intervals, newInterval);
		System.out.println("final intervals are: ");
		for (Interval i: result) {
			System.out.println(i.start + ", " + i.end);
		}
			
	}
	
	public ArrayList<Interval> mergeInterval(Interval [] intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		if (intervals == null || intervals.length <= 1) {
			return result;
		}
		
		for (Interval interval: intervals) {
			if (isOverlap(interval, newInterval)) {
				newInterval = merge(interval, newInterval);
			} else if (interval.end < newInterval.start) {
				result.add(interval);
			} else if (interval.start > newInterval.end) {
				result.add(newInterval);
				newInterval = interval;
			}
		}
		result.add(newInterval);
		
		return result;
	}
	
	private Interval merge(Interval A, Interval B) {
		int start = Math.min(A.start, B.start);
		int end = Math.max(A.end, B.end);
		
		return new Interval(start, end);
	}
	private boolean isOverlap(Interval A, Interval B) {
		int max = Math.max(A.start, B.start);
		int min = Math.min(A.end, B.end);
		
		return max <= min;
	}
}

class Interval {
	int start;
	int end;
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
