package i_Intervals;

import java.util.ArrayList;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }

public class IntervalMerge {
	
	 public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		 int n = intervals.size();
		 
		 //check if empty
		 if (n == 0) {
			 intervals.add(newInterval);
			 printIntervals(intervals);
			 return intervals;
		 }
		 
		 // check if new Interval is first one
		 Interval ival = intervals.get(0);
		 if (newInterval.end < ival.start) {
			 ArrayList<Interval> result = new ArrayList<Interval>();
			 result.add(newInterval);
			 result.addAll(intervals);
			 printIntervals(result);
			 return result;
		 }
		 
		 // check if new interval is last one
		 ival = intervals.get(n-1);
		 if (newInterval.start > ival.end) {
			 intervals.add(newInterval);
			 printIntervals(intervals);
			 return intervals;
		 }

		 ArrayList<Integer> temp = new ArrayList<Integer>();
		 int first = -1;
		 int second = -1;
		 int third = -1;
		 
		 for (int i=0; i<n; i++) {
		     ival = intervals.get(i);
		     if ((newInterval.start > ival.start) && (newInterval.start < ival.end)) {
		    	 first = i;
		    	 temp.add(ival.start);
		    	 temp.add(ival.end);
		     }
		     if ((newInterval.end < ival.end) && (newInterval.end > ival.start)) {
		    	 second = i;
		    	 temp.add(ival.start);
		    	 temp.add(ival.end);
		     }
		     if (newInterval.end < ival.start) {
		    	 third=i;
		     }
		 }
		 
		 temp.add(newInterval.start);
		 temp.add(newInterval.end);
		 int min = temp.get(0);
		 int max = temp.get(0);

		 for(Integer i: temp) {
		     if(i < min) min = i;
		     if(i > max) max = i;
		 }
		 
		 ival = new Interval(min, max);
		 if ((first > -1) && (second > -1)) {
			 int k = 0;
			 ArrayList<Interval> result = new ArrayList<Interval>();
			 while (k < first) {
				 result.add(intervals.get(k));
				 ++k;
			 }
			 result.add(ival);
			 for (k=second+1; k<n; k++) {
				 result.add(intervals.get(k));
			 }
			 intervals = result;
		 } else if (first > -1) {
			 int k = 0;
			 ArrayList<Interval> result = new ArrayList<Interval>();
			 while (k < first) {
				 result.add(intervals.get(k));
				 ++k;
			 }
			 result.add(ival);
			 for (k=first+1; k<n; k++) {
				 result.add(intervals.get(k));
			 }
			 intervals = result;
			 
		 } else if (second > -1) {
			 int k = 0;
			 ArrayList<Interval> result = new ArrayList<Interval>();
			 while (k < second) {
				 result.add(intervals.get(k));
				 ++k;
			 }
			 result.add(ival);
			 for (k=second+1; k<n; k++) {
				 result.add(intervals.get(k));
			 }
			 intervals = result;
		 } else if (third > -1){
			 System.out.println("inside third..: " + third);
			 int k = 0;
			 ArrayList<Interval> result = new ArrayList<Interval>();
			 while (k < third) {
				 result.add(intervals.get(k));
				 ++k;
			 }
			 result.add(ival);
			 for (k=third; k<n; k++) {
				 result.add(intervals.get(k));
			 }
			 intervals = result;
		 } else {
			 intervals.clear() ;
			 intervals.add(newInterval);
		 }
		 printIntervals(intervals);
		 return intervals;
    }
	 
	 private static void printIntervals(ArrayList<Interval> intervals) {
		 int n = intervals.size();
		 System.out.println("printing intervals");
		 for (int i=0; i<n; i++) {
			 System.out.println(intervals.get(i).start + ":" + intervals.get(i).end);
		 }
		 System.out.println();
	 }
	 
	public static void main(String [] args) {
		int [][] A = {{3,5}, {8, 10}};
		//int [][] A = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int r = A.length;
		int c = A[0].length;
		
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		for (int i=0; i<r; i++) {
			Interval val = new Interval(A[i][0], A[i][1]);
			intervals.add(val);
		}
		Interval ival = new Interval(1, 2);
		insert(intervals, ival);
	}
}
