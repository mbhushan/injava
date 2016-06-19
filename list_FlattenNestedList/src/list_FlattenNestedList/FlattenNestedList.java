package list_FlattenNestedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlattenNestedList {
	
	public static void main(String[] args) {
		FlattenNestedList fn = new FlattenNestedList();
		
		List<Object> list = list(list(1, 1), list(list(2)), list(1, 1));
		ListIterator li = new ListIterator(list);
		System.out.println("after flattening the nested list: ");
		while (li.hasNext()) {
			System.out.print(li.next() + " ");
		}
		System.out.println();
		int sum = fn.nestedWeightedSum(list);
		System.out.println("weighted sum: " + sum);
	}
	
	public static List<Object> list(Object ... args) {
		return Arrays.asList(args);
	}
	
	public int nestedWeightedSum(List<Object> list) {
		return nestedWeightedSum(list, 0);
	}
	
	private int nestedWeightedSum(List<Object> list, int depth) {
		if (list == null || list.size() == 0) {
			return 0;
		}
		Integer sum = 0;
		for (Object li: list) {
			if (li instanceof Integer) {
				sum += ((Integer)li * depth);
			} else {
				sum += nestedWeightedSum((List<Object>)li, depth+1);
			}
		}
		return sum;
	}
}

class ListIterator {
	List<Object> result = new ArrayList<Object>();
	
	public ListIterator(List<Object> list) {
		List<Object> Q = new ArrayList<Object>(list);
		
		while (!Q.isEmpty()) {
			Object obj = Q.remove(0);
			if (obj instanceof List<?>) {
				Q.addAll(0, (List<?>)obj);
			} else {
				result.add(obj);
			}
		}
	}
	
	public Object next() {
		return result.remove(0);
	}
	
	public boolean hasNext() {
		return !result.isEmpty();
	}
}
