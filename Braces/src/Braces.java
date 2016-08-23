import java.util.Stack;


public class Braces {
	
	public static void main(String[] args) {
		String [] values = {"[][](){}", "{[}]()", "([]{()})"};
		
		String [] result = braces(values);
		
		for (String st: result) {
			System.out.println(st);
		}
	}

	static String[] braces(String[] values) {
		if (values == null || values.length < 1) {
			return null;
		}
		
		String [] result = new String[values.length];
		
		for (int i=0; i<values.length; i++) {
			String st = values[i];
			char [] in = st.toCharArray();
			boolean flag = true;
			Stack<Character> stack = new Stack<Character>();
			for (int j=0; j<in.length; j++) {
				char ch = in[j];
				if (isopen(ch)) {
					stack.push(ch);
				} else {
					if (stack.isEmpty()) {
						flag = false;
						result[i] = "NO";
						break;
					} else {
						char curr = matching(ch);
						char last = stack.peek().charValue();
						if (curr != last) {
							flag = false;
							result[i] = "NO";
							break;
						} else {
							stack.pop();
						}
					}
				}
			}
			if (flag) {
				if (stack.isEmpty()) {
					result[i] = "YES";
				} else {
					result[i] = "NO";
				}
			}
		}
		return result;
    }
	
	static boolean isopen(char ch) {
		if (ch == '(' || ch == '[' || ch == '{') {
			return true;
		}
		return false;
	}
	
	static char matching(char ch) {
		if (ch == ')') {
			return '(';
		} else if (ch == ']') {
			return '[';
		} else if (ch == '}') {
			return '{';
		}
		return '-';
	}

}
