package i_AllPossibleSum;

import java.util.ArrayList;

public class PossibleSum {

	public static void main(String[] args) {
		
		int [] A = {1,4,7,13};
		f(A, 0, 0, new ArrayList<Integer>());
	}
	
	public static void f(int[] numbers, int index, int sum, ArrayList<Integer> output)
	{
		if (index == numbers.length)
		{
			System.out.println(output + " => " + sum);
			return;
		}

		// include numbers[index]
		output.add(numbers[index]);
		f(numbers, index + 1, sum + numbers[index], output);

		// exclude numbers[index]
		//output.remove(numbers[index]);
		output.remove(output.size()-1);
		f(numbers, index + 1, sum, output);
	}
}
