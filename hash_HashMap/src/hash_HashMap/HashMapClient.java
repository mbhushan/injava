package hash_HashMap;

public class HashMapClient {

	public static void main(String[] args) {
		String [] strings = {"X", "Y", "Z", "A", "B", "C", "D", "E", "F"};
		HashMapST<String, Integer> hmap = new HashMapST<String, Integer>();
		
		for (int i=0; i<strings.length; i++) {
			hmap.put(strings[i], i+1);
		}
		
		for (String s: hmap.keys()) {
			System.out.println(s + ": " + hmap.get(s));
		}
	}
}
