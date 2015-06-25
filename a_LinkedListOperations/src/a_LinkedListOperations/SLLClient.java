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
		
	}
 }
