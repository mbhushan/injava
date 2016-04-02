package hash_HashMap;

public class SequentialSearchSTClient {

	public static void main(String [] args) {
		String [] strings = {"A", "B", "C", "D", "E", "F"};
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		
		for (int i=0; i<strings.length; i++) {
			st.put(strings[i], i+1);
		}
		
		for (String s: st.keys()) {
			System.out.println(s + ": " + st.get(s));
		}
	}
}
