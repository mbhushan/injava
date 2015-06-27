package a_Stack;

public class StackClient {

	public static void main(String [] args) {
		String data = "ABC-DEF--XYZ";
		Stack<String> stack = new Stack<String>();
		
		int len = data.length();
		for (int i=0; i<len; i++) {
			String key = String.valueOf(data.charAt(i));
			if (!key.equals("-")) {
				stack.push(key);
				System.out.println("pushed: " + key);
			} else {
				System.out.println("popped: " + stack.pop());
			}
		}
		System.out.println("Size of the stack: " + stack.size());
		System.out.println("final items on stack");
		for (String s: stack) {
			System.out.print(s + " -> ");
		}
		System.out.println("null");
	}
}

/**
pushed: A
pushed: B
pushed: C
popped: C
pushed: D
pushed: E
pushed: F
popped: F
popped: E
pushed: X
pushed: Y
pushed: Z
Size of the stack: 6
final items on stack
Z -> Y -> X -> D -> B -> A -> null 
*/