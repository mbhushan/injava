package in_Hashcode;

public class HashCode {

		public static void main(String[] args) {
			HashCode hc = new HashCode();
			
			String input = "programming";
			System.out.println("hash code of " + input + ": " + hc.hashCode());
		}
		
		public int hashCode(String input) {
			if (input == null || input.length() < 1) {
				return 0;
			}
			
			int hash = 0;
			int len = input.length();
			for (int i=0; i<len; i++) {
				hash = input.charAt(i) + 31*hash;
			}
			return hash;
		}
}
