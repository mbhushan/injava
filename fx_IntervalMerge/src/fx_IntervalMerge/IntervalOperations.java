package fx_IntervalMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
Now create a function that takes a group of unsorted, unorganized intervals, 
merge any intervals that intersect and sort them. 
The result should be a group of sorted, non-intersecting intervals.
 */
public class IntervalOperations {
	
	public static void main(String[] args) {
		Interval [] intervals1 = {
				new Interval(1,3), 
				new Interval(2,4), 
				new Interval(5,7), 
				new Interval(6,8)
		};
		
		Interval [] intervals = {
				new Interval(1,3),
				new Interval(2,6),
				new Interval(8,10),
				new Interval(15,18),
		};
		
		IntervalOperations IO = new IntervalOperations();
		ArrayList<Interval> result = IO.mergeIntervals(intervals);
		
		System.out.println("after merging overlapping intervals:");
		for (Interval in: result) {
			System.out.println(in.start + ", " + in.end);
		}
	}
	
	public ArrayList<Interval> mergeIntervals(Interval [] intervals) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		if (intervals == null || intervals.length <= 1) {
			return result;
		}

		Arrays.sort(intervals, new IntervalComparator());
		Interval prev = intervals[0];
		
		for (int i=1; i<intervals.length; i++) {
			if (overlap(prev, intervals[i])) {
				prev = merge(prev, intervals[i]);
			} else {
				result.add(prev);
				prev = intervals[i];
			}
		}
		result.add(prev);
		
		return result;
	}
	
	private Interval merge(Interval A, Interval B) {
		return new Interval(Math.min(A.start, B.start), Math.max(A.end, B.end));
	}
	
	private boolean overlap(Interval A, Interval B) {
		int max = Math.max(A.start, B.start);
		int min = Math.min(A.end, B.end);
		
		return max <= min;
	}

}

class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
}
		
class Interval {
	int start;
	int end;
	
	public Interval(int s, int e) {
		this.start = s;
		this.end = e;
	}
}
