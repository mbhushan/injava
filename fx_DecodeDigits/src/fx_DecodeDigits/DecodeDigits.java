package fx_DecodeDigits;

public class DecodeDigits {

	public static void main(String[] args) {
		DecodeDigits dd = new DecodeDigits();
		
		int [] digits = {1,1,1,1};
		int result = dd.ways(digits);
		System.out.println("result :" + result );
	}

	public int ways(int[] digits) {
		if (digits == null || digits.length < 1) {
			return 0;
		}
		return ways(digits, 0);

	}

	private  int ways(int[] digits, int index) {
		if (index == digits.length) {
			return 1;
		}
		int count = 0;
		count += ways(digits, index + 1);
		if (index < digits.length - 1) {
			int x = digits[index];

			int y = digits[index + 1];
			int num = x * 10 + y;
			if (10 <= num && num <= 25) {
				count += ways(digits, index + 2);
			}
		}

		return count;
	}

}
