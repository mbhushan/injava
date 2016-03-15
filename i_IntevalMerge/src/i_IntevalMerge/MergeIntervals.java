package i_IntevalMerge;


import java.util.ArrayList;


class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
 }
public class MergeIntervals {
	
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
		ArrayList<Interval> result = insert(intervals, ival);
		for (Interval val: result) {
			System.out.println(val.start + " " + val.end);
		}
		
	}

	 public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	     ArrayList<Interval> result=new ArrayList<Interval>();
	        
	        if (newInterval==null){
	            
	            return intervals;
	        }
	        
	        if (intervals==null||intervals.size()==0){
	            result.add(newInterval);
	            return result;
	        }
	        
	      
	        
	        for (Interval temp: intervals){
	            if (temp.end<newInterval.start){
	                result.add(temp);
	                
	            }
	            else if (temp.start>newInterval.end){
	                result.add(newInterval);
	                newInterval=temp;
	            }
	            else{
	                
	                newInterval.start=Math.min(newInterval.start, temp.start);
	                newInterval.end=Math.max(newInterval.end, temp.end);
	            }
	        }
	        
	        result.add(newInterval);
	        
	        
	        return result;

	    }
}
