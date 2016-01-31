package i_Hash_FractionToDecimal;

import java.util.HashMap;

public class FractDecimal {
	
	public static void main(String[] args) {
		int numerator = 2, denominator = 3;
		System.out.println("numerator: " + numerator);
		System.out.println("denominator: " + denominator);
		System.out.println("decimal: " + fractionToDecimal(numerator, denominator));
	}
	
	public static String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0)
			return "0";
		if (denominator == 0)
			return "";
	 
		StringBuffer result = new StringBuffer();
	 
		// is result is negative
		if ((numerator < 0) ^ (denominator < 0)) {
			result.append("-");
		}
	 
		// convert int to long
		long num = numerator, den = denominator;
		num = Math.abs(num);
		den = Math.abs(den);
	 
		// quotient 
		long res = num / den;
		result.append(res);
	 
		// if remainder is 0, return result
		long remainder = (num % den) * 10;
		if (remainder == 0)
			return result.toString();
	 
		// right-hand side of decimal point
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		result.append(".");
		while (remainder != 0) {
			// if digits repeat
			if (map.containsKey(remainder)) {
				int beg = map.get(remainder); 
				String part1 = result.substring(0, beg);
				String part2 = result.substring(beg, result.length());
				result = new StringBuffer(part1 + "(" + part2 + ")");
				return result.toString();
			}
	 
			// continue
			map.put(remainder, result.length());
			res = remainder / den;
			result.append(res);
			remainder = (remainder % den) * 10;
		}
	 
		return result.toString();
	}

}
