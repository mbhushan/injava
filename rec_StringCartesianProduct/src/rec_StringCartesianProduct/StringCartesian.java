package rec_StringCartesianProduct;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given a list of list of Strings. Print cartesian product of lists.
 * input -> {"Hello", "World"} , {"Game"}, {"Go","Home"}
 * output ->
 * Hello Game Go
 * Hello Game Home
 * World Game Go
 * World Game Home
 */

public class StringCartesian {

	public static void main(String[] args) {
		StringCartesian sc = new StringCartesian();
		ArrayList<ArrayList<String>> slist = new ArrayList<ArrayList<String>>();

		ArrayList<String> A = new ArrayList<String>(Arrays.asList("Hello", "World"));
		ArrayList<String> B = new ArrayList<String>(Arrays.asList("Game"));
		ArrayList<String> C = new ArrayList<String>(Arrays.asList("Go", "Home"));

		slist.add(A);
		slist.add(B);
		slist.add(C);

		sc.cartesianProduct(slist);
	}

	public void cartesianProduct(ArrayList<ArrayList<String>> slist) {

		ArrayList<String> buff = new ArrayList<String>();
		int index = 0;
		cartesianProduct(slist, index, buff);
	}

	private void cartesianProduct(ArrayList<ArrayList<String>> slist, int index, ArrayList<String> buff) {
		if (index == slist.size()) {
			System.out.println(buff.toString());
			return;
		}

		for (int i = 0; i < slist.get(index).size(); i++) {
			buff.add(slist.get(index).get(i));
			cartesianProduct(slist, index+1, buff);
			buff.remove(buff.size()-1);
			
		}
	}
}
