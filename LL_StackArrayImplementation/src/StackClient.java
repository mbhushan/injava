
public class StackClient {

	public static void main(String [] args) {
		Stack<String> stack = new Stack<String>(10);
		
		String text = "to be or not to - be - - that - - - is";
		String [] S = text.split(" ");
		for (int i=0; i<S.length; i++) {
			if (!S[i].equals("-")) {
				stack.push(S[i]);
				System.out.println("pushed: " + S[i]);
			} else {
				System.out.println("popped: " + stack.pop());
			}
		}
	}
}
