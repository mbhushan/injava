package i_LCSSubStrings;

import java.util.ArrayList;

public class LCSStrings {

	public static ArrayList<Integer> maxLCS(String input) {
		if (input == null || input.length() == 0)
			return null;

		int maxjIndex = -1;
		int maxMatchLen = 0;

		int currMatchLen = 0;

		char[] charArr = input.toCharArray();

		int end = input.length() - 1;

		for (int i = 0; i < input.length() - 1; i++) {
			if (i > end)
				continue;

			if (charArr[i] == charArr[end]) {
				currMatchLen++;
				end--;
				if (end > (input.length()) - (1 + i))
					continue;

			}
			if (currMatchLen >= maxMatchLen) {
				maxMatchLen = currMatchLen;
				maxjIndex = i + 1;
			}
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(maxjIndex);
		result.add(maxMatchLen);

		return result;

	}

	public static void main(String[] args) {
		String s = "abba";
		//s = "abc";

		ArrayList<Integer> A = maxLCS(s);
		for (Integer i: A) {
			System.out.print(i+ " ");
		}
		System.out.println();
	}
}
