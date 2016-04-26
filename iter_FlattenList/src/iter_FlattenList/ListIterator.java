package iter_FlattenList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListIterator {
	
	List<Object> result = new ArrayList<Object>();

	ListIterator(List<Object> list) {
		LinkedList<Object> Q = new LinkedList<Object>(list);
		
		while (Q.size() > 0) {
			Object obj = Q.remove();
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
