package fx_MergeSortedIntervals;

import java.util.ArrayList;

public class IntervalMerge {

	public static void main(String[] args) {
		Interval []  A = {
				new Interval(2, 4),
				new Interval(8, 10),
				new Interval(14, 18)
		};
		
		Interval [] B = {
				new Interval(5,7),
				new Interval(9,13),
				new Interval(17, 20)
		};
		ArrayList<Interval> result = new IntervalMerge().mergeIntervals(A, B);
		for (Interval i: result) {
			System.out.println(i.start +", " + i.end);
		}
	}
	
	public ArrayList<Interval> mergeIntervals(Interval [] A, Interval [] B) {
		int i = 0;
		int j = 0;
		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval aux = null;
		while (i < A.length && j < B.length) {
			if (A[i].end < B[j].start) {
				result.add(A[i]);
				++i;
			} else if (B[j].end < A[i].start) {
				result.add(B[j]);
				++j;
			} else if (overlap(A[i], B[j])) {
				aux = merge(A[i], B[j]);
				++i;
				++j;
				while (i<A.length && overlap(aux, A[i])) {
					aux = merge(aux, A[i]);
					++i;
				}
				while (j < B.length && overlap(aux, B[j])) {
					aux = merge(aux, B[j]);
					++j;
				}
				result.add(aux);
			}
		}
		return result;
	}
	
	private Interval merge(Interval x, Interval y) {
		int start = Math.min(x.start, y.start);
		int end = Math.max(x.end, y.end);
		
		return new Interval(start, end);
	}
	
	private boolean overlap(Interval x, Interval y) {
		int max = Math.max(x.start, y.start);
		int min = Math.min(x.end, y.end);
		
		return max <= min;
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
