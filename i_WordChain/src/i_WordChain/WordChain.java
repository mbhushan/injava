package i_WordChain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class QItem {
	String value;
	int count;
	
	public QItem(String val, int cnt) {
		// TODO Auto-generated constructor stub
		value = val;
		count = cnt;
	}
}
public class WordChain {

	private static String [] Dictionary = {"POON", "PLEE", "SAME", "POIE", "PLEA", "PLIE", "POIN"};
	private static HashSet<String> hset = new HashSet<String>();
	
	public static void main(String[] args) {
		for (int i=0; i<Dictionary.length; i++) {
			hset.add(Dictionary[i].toLowerCase());
		}
		
		String start = "toon";
	    String target = "plea";
	    System.out.println("shortest chain: " + shortestChain(start, target));
	}
	
	public static int shortestChain(String start, String end) {
		Queue<QItem> Q = new LinkedList<QItem>();
		
		QItem item = new QItem(start, 1);
		Q.add(item);
		
		while (!Q.isEmpty()) {
			QItem curr = Q.poll();
			
			ArrayList<String> list= new ArrayList<String>();
			// Go through all words of dictionary
			for (String str: hset) {
				if (isAdjacent(curr.value, str)) {
					QItem node = new QItem(str, curr.count+1);
					Q.add(node);
					
					// Remove from dictionary so that this word is not
	                // processed again.  This is like marking visited
					list.add(str);
					
					//hset.remove(str);
					if (str.equals(end)) {
						return node.count;
					}
				}
			}
//			for (String s: list) {
//				hset.remove(s);
			//}
		}
		return 0;
	}
	
	private static boolean isAdjacent(String x, String y) {
		int count = 0;
		int n = x.length();
		
		for (int i=0; i<n; i++) {
			if (x.charAt(i) != y.charAt(i)) {
				count++;
			}
			if (count > 1) {
				return false;
			}
		}
		return count == 1 ? true: false;
	}
}
