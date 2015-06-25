package a_LinkedListOperations;

import java.util.Random;

public class SLLClient {

	
	public static void main(String [] args) {
		LinkedList list = new LinkedList();
		Random rand = new Random();
		int N = 10;
		int R = 100;
		for (int i=0; i<N; i++) {
			String data = String.valueOf(rand.nextInt(R) + 1);
			System.out.println("front insert" + data);
			list.insertFront(data);
			list.printList();
		}
		
		System.out.println();
		System.out.println("Testing remove operations.");
		for (int i=0; i<2; i++) {
			System.out.println("removing front ..");
			System.out.println("removed: " + list.removeFront());
			list.printList();
			System.out.println("removing back ..");
			System.out.println("removed: " + list.removeBack());
			list.printList();
			int pos = rand.nextInt(list.size());
			System.out.println("removing position: " + pos);
			System.out.println("removed: " + list.removePosition(pos));
			list.printList();
		}
		
	}
 }
/**
front insert23
23 -> null
front insert83
83 -> 23 -> null
front insert40
40 -> 83 -> 23 -> null
front insert42
42 -> 40 -> 83 -> 23 -> null
front insert69
69 -> 42 -> 40 -> 83 -> 23 -> null
front insert45
45 -> 69 -> 42 -> 40 -> 83 -> 23 -> null
front insert72
72 -> 45 -> 69 -> 42 -> 40 -> 83 -> 23 -> null
front insert94
94 -> 72 -> 45 -> 69 -> 42 -> 40 -> 83 -> 23 -> null
front insert14
14 -> 94 -> 72 -> 45 -> 69 -> 42 -> 40 -> 83 -> 23 -> null
front insert62
62 -> 14 -> 94 -> 72 -> 45 -> 69 -> 42 -> 40 -> 83 -> 23 -> null

Testing remove operations.
removing front ..
removed: 62
14 -> 94 -> 72 -> 45 -> 69 -> 42 -> 40 -> 83 -> 23 -> null
removing back ..
removed: 23
14 -> 94 -> 72 -> 45 -> 69 -> 42 -> 40 -> 83 -> null
removing position: 3
removed: 45
14 -> 94 -> 72 -> 69 -> 42 -> 40 -> 83 -> null
removing front ..
removed: 14
94 -> 72 -> 69 -> 42 -> 40 -> 83 -> null
removing back ..
removed: 83
94 -> 72 -> 69 -> 42 -> 40 -> null
removing position: 2
removed: 69
94 -> 72 -> 42 -> 40 -> null
*/
