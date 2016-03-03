package i_RemoveDups;

import java.util.HashSet;

public class RemoveDups {

	
	public static void main(String[] args) {
		String [] S = {"mani", "archana", "mani", "archana", "shreyansh"};
		
		HashSet<String> hset = new HashSet<String>();
		
		for (String s: S) {
			hset.add(s);
		}
		int size = hset.size();
		S = new String[size];
		
		hset.toArray(S);
		
		for (String st: S) {
			System.out.println(st);
		}

	}
}
