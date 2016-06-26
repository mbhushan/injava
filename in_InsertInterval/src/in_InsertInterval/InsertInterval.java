package in_InsertInterval;

import java.util.ArrayList;

/*
Given a collection of pair representing intervals write a function which inserts new interval into collection and merges overlapping intervals. 
Example: 
[-10, -1], [0,2], [4,10] 
insert [-5, 1] 
output: [-10, 2], [4, 10]
*/
public class InsertInterval {

	public static void main(String[] args) {
		InsertInterval ii = new InsertInterval();
		
		int [] starts = {-10, 0, 4};
		int [] ends = {-1, 2, 10};
		
		Interval [] intervals = new Interval[starts.length];
		for (int i=0; i<starts.length; i++) {
			intervals[i] = new Interval(starts[i], ends[i]);
		}
		
		Interval newInterval = new Interval(-5, 1);
		
		ArrayList<Interval> result = ii.insertInterval(intervals, newInterval);
		System.out.println("after merging: ");
		for (Interval x: result) {
			System.out.println(x.start + ", " + x.end);
		}
	}
	
	public ArrayList<Interval> insertInterval(Interval [] intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		if (intervals == null || intervals.length < 1) {
			return result;
		}
		
		for (int i=0; i<intervals.length; i++) {
			if (isOverlapping(intervals[i], newInterval)) {
				newInterval = merge(intervals[i], newInterval);
			} else if (intervals[i].end < newInterval.start) {
				result.add(intervals[i]);
			} else if (newInterval.end < intervals[i].start) {
				result.add(newInterval);
				newInterval = intervals[i];
			}
		}
		result.add(newInterval);
		return result;
	}
	
	private Interval merge(Interval x, Interval y) {
		int start = Math.min(x.start, y.start);
		int end = Math.max(x.end, y.end);
		
		return new Interval(start, end);
	}
	
	private boolean isOverlapping(Interval x, Interval y) {
		int max = Math.max(x.start, y.start);
		int min = Math.min(x.end, y.end);
		
		return max <= min;
	}
}

class Interval {
	int start;
	int end;
	
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
