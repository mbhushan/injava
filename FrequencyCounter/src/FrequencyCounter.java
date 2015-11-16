import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class FrequencyCounter {

	private static HashMap<String, Integer> freqMap = new HashMap<String, Integer>();
	private static String TINY_TALE_FILENAME = "tinyTale.txt";
	private static int totalWords = 0;
	
	public static void main(String [] args) {
		readInput(TINY_TALE_FILENAME);
		publishMetrics();
	}
	
	public static void publishMetrics() {
		if (freqMap.size() == 0) {
			System.out.println("Map is empty! Nothing to publish.");
			return;
		}
		System.out.println("Total Words: " + totalWords);
		int totalWords = freqMap.size();
		System.out.println("Total unique words: " + totalWords);
		printMap();
	}
	
	
	public static void printMap() {
		System.out.println("printing frequency map: ");
		Iterator it = freqMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>)it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			it.remove();
		}
	}
	
	public static void readInput(String fname) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("data/" + fname));
			String line = null;
			
			while ((line = br.readLine()) != null){
				//System.out.println(line);
				String [] words = line.trim().split(" ");
				for (int i=0; i<words.length; i++) {
					int count = 1;
					if (freqMap.containsKey(words[i])) {
						count = freqMap.get(words[i]);
						++count;
					}
					freqMap.put(words[i], count);
					++totalWords;
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
