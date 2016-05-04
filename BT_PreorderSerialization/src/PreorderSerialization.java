import java.util.Stack;

public class PreorderSerialization {

	public static void main(String[] args) {
		String str = "9,3,4,#,#,1,#,#,2,#,6,#,#";

		PreorderSerialization PS = new PreorderSerialization();
		System.out
				.println("valid serialization: " + PS.validSerialization(str));
	}

	public boolean validSerialization(String str) {
		Stack<String> stack = new Stack<String>();
		String[] arr = str.trim().split(",");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			stack.push(arr[i]);

			while (stack.size() >= 3 && stack.get(stack.size() - 1).equals("#")
					&& stack.get(stack.size() - 2).equals("#")
					&& !stack.get(stack.size() - 3).equals("#")) {
				stack.pop();
				stack.pop();
				stack.pop();

				stack.push("#");
			}
		}
		System.out.println();

		if (stack.size() == 1 && stack.get(0).equals("#")) {
			return true;
		}
		return false;
	}

}
