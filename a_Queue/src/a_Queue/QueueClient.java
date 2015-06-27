package a_Queue;

public class QueueClient {

	
	public static void main(String [] args) {
		String data = "ABC-DEF--XYZ-";
		int len = data.length();
		Queue<String> Q = new Queue<String>();
		
		for (int i=0; i<len; i++) {
			String key = String.valueOf(data.charAt(i));
			if (!key.equals("-")) {
                Q.enqueue(key);
                System.out.println("Enqueued: " + key);
			} else {
				System.out.println("Removed: " + Q.dequeue());
			}
		}
		System.out.println("final size: " + Q.size());
		System.out.println("Items in Queue");
		for (String s: Q) {
			System.out.print(s + " -> ");
		}
		System.out.println("null");
	}
}

/**
Enqueued: A
Enqueued: B
Enqueued: C
Removed: A
Enqueued: D
Enqueued: E
Enqueued: F
Removed: B
Removed: C
Enqueued: X
Enqueued: Y
Enqueued: Z
Removed: D
final size: 5
Items in Queue
E -> F -> X -> Y -> Z -> null
*/