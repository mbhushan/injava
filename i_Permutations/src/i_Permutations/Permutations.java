package i_Permutations;

public class Permutations {

	public static void main(String[] args) {
		String st = "ABC";
		permute(st.toCharArray());
	}

	public static void permute(char[] string) {
		permute(string, 0, string.length - 1);
	}

	private static void permute(char[] S, int left, int right) {
		int i;
		if (left == right) {
			System.out.println(new String(S));
		} else {
			for (i = left; i <= right; i++) {
				//swap((a + l), (a + i));
				char ch = S[left];
				S[left] = S[i];
				S[i] = ch;
				permute(S, left + 1, right);
				//swap((a + l), (a + i)); // backtrack
				ch = S[left];
				S[left] = S[i];
				S[i] = ch;
			}
		}
	}
}
