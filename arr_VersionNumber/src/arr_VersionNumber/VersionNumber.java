package arr_VersionNumber;

public class VersionNumber {

	public boolean compareVersionNumber(String v1, String v2) {
		if (v1 == null || v2 == null) {
			return false;
		}
		Integer i1 = Integer.parseInt(v1.replaceAll("[.]", ""));
		Integer i2 = Integer.parseInt(v2.replaceAll("[.]", ""));
		
		return (i1 - i2) > 0;
	}
	
	public static void main(String[] args) {
		VersionNumber VN = new VersionNumber();
		
		String v1 = "13.37.01";
		String v2 = "13.07.12";
		
		System.out.println("comparing versions: " + VN.compareVersionNumber(v1, v2));
		System.out.println("comparing versions: " + VN.compareVersionNumber(v2, v1));
	}
}
