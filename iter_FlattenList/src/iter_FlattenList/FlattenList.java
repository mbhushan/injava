package iter_FlattenList;

import java.util.Arrays;
import java.util.List;

public class FlattenList {

	public static void main(String [] args) {
		List<Object> list = list(1, 3, 5, list(6, 7), 8, 9, 10, list(11, 13, 15, list(16, 17, list(18, 19))), 20);

		ListIterator LI = new ListIterator(list);
		while (LI.hasNext()) {
			System.out.print(LI.next() + " ");
		}
		System.out.println();
	}
	
	public  static List<Object> list(Object... args) {
	    return Arrays.asList(args);
	}
}
