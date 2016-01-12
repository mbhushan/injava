package i_ConvertString;

public class ConvertString {

	public static String convert(String a, int b) {
		int nRows = b;

		if (nRows == 1)
			return a;

		StringBuilder ss = new StringBuilder();
		int n = nRows + nRows - 2;
		// rest rows
		for (int i = 0; i < nRows; ++i) {
			int cur = i;
			while (cur < a.length()) {
				ss.append(a.charAt(cur));
				cur += n;
				if (i > 0 && i < nRows - 1 && (cur - i - i) < a.length()) {
					ss.append(a.charAt(cur - i - i));
				}
			}
		}
		return ss.toString();
	}
	
	public static void main(String[] args) {
		String st = "PAYPALISHIRING";
		int b = 3;
		System.out.println("converted: " + convert(st, b));
	}
}
