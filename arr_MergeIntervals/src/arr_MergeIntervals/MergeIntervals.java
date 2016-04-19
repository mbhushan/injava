package arr_MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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

public class MergeIntervals {
	
	public static void main(String [] args) {
		Integer [] starts = {8, 1, 2, 15};
		Integer [] ends = {10, 3, 6, 18};
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		for (int i=0; i<starts.length; i++) {
			intervals.add(new Interval(starts[i], ends[i]));
		}
		MergeIntervals MI = new MergeIntervals();
		ArrayList<Interval> result = MI.mergeIntervals(intervals);
		for (Interval i: result) {
			System.out.println(i.start + ": " + i.end);
		}
	}

	public ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
		if (intervals == null || intervals.size() < 1) {
			return intervals;
		}
		
		Collections.sort(intervals, new IntervalComparator());
		
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		Interval prev = intervals.get(0);
		int size = intervals.size();
		for (int i=1; i<size; i++) {
			Interval curr = intervals.get(i);
			if (prev.end < curr.start) {
				result.add(prev);
				prev = curr;
			} else {
				//merge case
				Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
				prev = merged;
			}
		}
		result.add(prev);
		return result;
	}
}

class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
}
