package i_MergingIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].
*/

class Interval {
	int start;
	int end;
	
	public Interval() {
		start = 0;
		end = 0;
	}
	
	public Interval(int s, int e) {
		start = s;
		end = e;
	}
	
	
}

public class MergeIntervals {
	public static void main(String[] args) {
		int [] starts = {1, 2, 8, 15};
		int [] ends = {3, 6, 10, 18};
		
		int len = starts.length;
		Interval [] intervals = new Interval[len];
		
		for (int i=0; i<len; i++) {
			intervals[i] = new Interval(starts[i], ends[i]);
		}
		ArrayList<Interval> I = new ArrayList<Interval>();
		Collections.addAll(I, intervals);
		ArrayList<Interval> result = merge(I);
		for (Interval r: result) {
			System.out.println(r.start + ": " + r.end);
		}
	}
	
	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1) { 
			return intervals;
		}
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		Collections.sort(intervals, new IntervalComparator());
		
		Interval prev = intervals.get(0);
		int size = intervals.size();
		for (int i=1; i<size; i++) {
			Interval curr = intervals.get(i);
			if (prev.end >= curr.start) {
				Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
				prev = merged;
			} else {
				result.add(prev);
				prev = curr;
			}
		}
		result.add(prev);
		return result;
	}
}

class IntervalComparator implements Comparator<Interval> {
	@Override
	public int compare(Interval o1, Interval o2) {
		return o1.start - o2.start;
	}
}
