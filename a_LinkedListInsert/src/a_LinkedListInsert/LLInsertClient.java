package a_LinkedListInsert;

import java.util.Random;

public class LLInsertClient {

	public static void main(String [] args) {
		LinkedList list = new LinkedList();
		Random rand = new Random();
		
		int n = 3;
		for (int i=0; i<n; i++) {
			int data = rand.nextInt(99) + 1;
			System.out.println("head insert " + data);
			list.insertFront(String.valueOf(data));
			list.printList();
			data = rand.nextInt(99) + 1;
			System.out.println("tail insert " + data);
			list.insertBack(String.valueOf(data));
			list.printList();
			int pos = rand.nextInt(n);
			data = rand.nextInt(99) + 1;
			System.out.println("position " + pos + " insert " + data);
			list.insertMiddle(String.valueOf(data), pos);
			list.printList();
		}
	}
}
