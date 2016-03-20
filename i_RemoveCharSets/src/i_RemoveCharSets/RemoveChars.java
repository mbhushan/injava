package i_RemoveCharSets;

public class RemoveChars {

	public static void main(String[] args) {
		String [] st = {"aababc", "acbac", "aaac", "ababac", "bbbbd"};
		for (int i=0; i<st.length; i++) {
			char [] string = st[i].toCharArray();
			removeChars(string);
		}
	}
	
	public static void removeChars(char [] string) {
		if (string == null) {
			return;
		}
		int len = string.length;
		
		if (len < 1) {
			return ;
		}
		
		int j = -1;
		int i = 0;
		while (i<len) {
			if (string[i] != 'a' && string[i] != 'b') {
				string[++j] = string[i++];
			} else if ((i+1 < len) && (string[i] == 'a' && (string[i+1] != 'c'))) {
				string[++j] = string[i];
				if (string[i+1] != 'b') {
					string[++j] = string[++i];
				}
					++i;
			} else if ((i+1 < len) && (string[i] == 'a' && (string[i+1] == 'c'))) {
				++i;
			} else if (string[i] == 'b'){
				++i;
			}
		}
		if (j > -1) {
			for (int x=0; x<=j; x++) {
				System.out.print(string[x]);
			}
		}
		System.out.println();
	}
}
