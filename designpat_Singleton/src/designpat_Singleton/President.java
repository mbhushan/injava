package designpat_Singleton;

/*
 * http://www.programcreek.com/2011/07/java-design-pattern-singleton/
 */

//lazy mode
public class President {

	private static  President president;
	
	private President() {}
	
	public synchronized static President getPresident() {
		if (president == null) {
			president = new President();
		}
		return president;
	}
}
