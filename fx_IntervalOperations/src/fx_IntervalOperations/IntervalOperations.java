package fx_IntervalOperations;

public class IntervalOperations {

	public static void main(String[] args) {
		Interval [] A = {
				new Interval(3, 7),
				new Interval(1, 3),
				new Interval(9, 11),
				new Interval(1, 2),
				new Interval(1, 5),
				new Interval(5, 8),
				new Interval(4, 6)
		};
		IntervalOperations IO = new IntervalOperations();
		Interval first = A[0];
		for (int i=1; i<A.length; i++) {
			boolean overlap = IO.intersect(first, A[i]);
			System.out.println(first.start + ", " + first.end +" and " + A[i].start + ", " + A[i].end + "=> " + overlap);
			if (IO.intersect(first, A[i])) {
				Interval merged = IO.merge(first, A[i]);
				System.out.println("merged: " + merged.start + ", " + merged.end);
			}
			//System.out.println(IO.intersecting(first, A[i]));
			System.out.println();
		}
	}
	
	private Interval merge(Interval A, Interval B) {
		int start = Math.min(A.start, B.start);
		int end = Math.max(A.end, B.end);
		
		return new Interval(start, end);
	}
	
	public boolean intersecting(Interval A, Interval B) {
		int max = Math.max(A.start, B.start);
		int min = Math.min(A.end, B.end);
		
		return max <= min;
	}
	
	public boolean intersect(Interval A, Interval B) {
		Interval first = A.start < B.start ? A: B;
		Interval second = A.start < B.start ? B: A;
		
		// here we are sure that first.start <= second.start;
		if (first.start == second.start) {
			return true;
		}
		if (first.end < second.start) {
			return false;
		}
		if (second.end <= first.start) {
			return true;
		}
		if (first.end >= second.start) {
			return true;
		}
		
		return false;
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