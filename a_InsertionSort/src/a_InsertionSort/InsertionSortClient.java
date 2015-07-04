package a_InsertionSort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class InsertionSortClient {

	private static Logger log = Logger.getLogger(InsertionSortClient.class.getName());
	private static final String LOG_PROPERTIES_FILE = "resource/log4j.properties";
	
	public static void main(String [] args) {
		
		String [] inputs = readInput();
		InsertionSort.sort(inputs);
		log.info("After sorting the input, we have: ");
		InsertionSort.printData(inputs);
	}
	
	public static void initLogger() {
		Properties logProperties = new Properties();
		try
	    {
	      // load our log4j properties / configuration file
	      logProperties.load(new FileInputStream(LOG_PROPERTIES_FILE));
	      PropertyConfigurator.configure(logProperties);
	      log.info("Logging initialized.");
	    } catch(IOException e) {
	      throw new RuntimeException("Unable to load logging property " + LOG_PROPERTIES_FILE);
	    }
	}
	
	public static String [] readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] inputs = null;
		try {
			inputs = br.readLine().trim().split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputs;
	}
}
