package designpat_Singleton;


//Eager Mode
public class CEO {

	private static final CEO ceo  = new CEO();
	
	private CEO() {}
	
	public static CEO getCEO() {
		return ceo;
	}
}
