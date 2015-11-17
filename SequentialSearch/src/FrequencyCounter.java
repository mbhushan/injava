import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FrequencyCounter {

	private static String TINY_TALE_FILENAME = "tale.txt";
	private static SequentialSearchST<String, Integer> freqST = new SequentialSearchST<String, Integer>();
	
	public static void main(String [] args) {
		
	}
	
	public static void readInput(String fname) {
		BufferedReader br = null;
		
		try {
                br = new BufferedReader(new FileReader("data/" + fname));
                String line = null;
                while ((line = br.readLine()) != null) {
                	String [] data = line.trim().split(" ");
                	for (int i=0; i<data.length; i++) {
                		int count = 1;
                		Integer value = freqST.get(data[i]);
                		if (null != value) {
                			count = value;
                			++count;
                		}
                		freqST.put(data[i], count);
                	}
                }

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
