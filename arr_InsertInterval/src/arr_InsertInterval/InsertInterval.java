package arr_InsertInterval;

import java.util.ArrayList;

/*
 * Given a set of non-overlapping & sorted intervals, insert a new interval into the intervals (merge if necessary).
 */

class Interval {
	int start;
	int end;
	
	Interval() {
		start = 0;
		end = 0;
	}
	
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class InsertInterval {
	
	public static void main(String [] args) {
		Integer [] starts = {1, 3, 6, 8, 12};
		Integer [] ends = {2, 5, 7, 10, 16};
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		for (int i=0; i<starts.length; i++) {
			intervals.add(new Interval(starts[i], ends[i]));
		}
		InsertInterval II = new InsertInterval();
		ArrayList<Interval> result = II.insertInterval(intervals, new Interval(4, 9));
		for (Interval i: result) {
			System.out.println(i.start + ":" + i.end);
		}
	}

	public ArrayList<Interval> insertInterval(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		for (Interval interval: intervals) {
			if (interval.end < newInterval.start) {
				result.add(interval);
			} else if (interval.start > newInterval.end) {
				result.add(newInterval);
				newInterval = interval;
			} else if (interval.end >= newInterval.start || interval.start <= newInterval.end) {
				newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
			}
		}
		result.add(newInterval);
		return result;
	}
}
