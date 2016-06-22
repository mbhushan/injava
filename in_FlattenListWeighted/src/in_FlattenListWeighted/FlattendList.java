package in_FlattenListWeighted;
/** 
* Given a nested list of integers, returns the sum of all integers in the list weighted by their depth 
* For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1) 
* Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3) 
*/ 
import java.util.Arrays;
import java.util.List;

public class FlattendList {

	public static void main(String[] args) {
		FlattendList fl = new FlattendList();
		List<?> list = list( list(1, 1), 2, list(1, 1));
		System.out.println("sum is: " + fl.calcSum(list, 1));
		
		List<?> nlist = list ( 1, list (4, list(6)));
		System.out.println("sum is: " + fl.calcSum(nlist, 1));
	}
	
	public int calcSum(List<?> list, int depth) {
		if (list == null || list.size() < 1) {
			return 0;
		}
		int sum = 0;
		for (Object li: list) {
			if (li instanceof Integer) {
				sum += (Integer)li * depth;
			} else {
				sum += calcSum((List<?>)li, depth+1);
			}
		}
		
		return sum;
	}
	
	public static List<?> list(Object ... args) {
		return Arrays.asList(args);
	}
}
