package fx_ConflictingAppointments;

import java.util.Arrays;
import java.util.Comparator;

public class Appointments {

	public static void main(String[] args) {
		Appointments ap = new Appointments();
		
		int [] start = {2, 4, 10, 22, 29};
		int [] end = {5, 7, 11, 36, 34};
		
		ap.checkOverlap(start, end);
	}
	
	
	public void checkOverlap(int [] start, int [] end) {
		if (start == null || end == null) {
			return;
		}
		
		if (start.length != end.length) {
			return ;
		}
		
		if (start.length < 2) {
			return;
		}
		
		int len = start.length;
		Interval [] intervals = new Interval[len];
		for (int i=0; i<len; i++) {
			intervals[i] = new Interval(start[i], end[i], i+1);
		}
		
		Arrays.sort(intervals, new IntervalComparator());
		
		System.out.println("overlapping events: ");
		for(int i=0; i<len-1; i++) {
			if (overlap(intervals[i], intervals[i+1])) {
				System.out.println(intervals[i].index + " and " + intervals[i+1].index);
			}
		}
	}
	
	private boolean overlap(Interval x, Interval y) {
		int max = Math.max(x.start, y.start);
		int min = Math.min(x.end, y.end);
		
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
	int index;
	
	public Interval(int start, int end, int index) {
		this.start = start;
		this.end = end;
		this.index = index;
	}
}
