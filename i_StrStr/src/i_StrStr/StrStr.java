package i_StrStr;

public class StrStr {

	public static int strStr(final String haystack, final String needle) {
		if(haystack==null || needle==null) {
	        return -1;
		}
	 
	    if(needle.isEmpty() || haystack.isEmpty()) {
	        return -1;
	    }
	 
	    for(int i=0; i<haystack.length(); i++){
	        if(i + needle.length() > haystack.length())
	            return -1;
	 
	        int m = i;
	        for(int j=0; j<needle.length(); j++){
	            if(needle.charAt(j)==haystack.charAt(m)){
	                if(j==needle.length()-1)
	                    return i;
	                m++;
	            }else{
	                break;
	            }
	 
	        }    
	    }   
	 
	    return -1;
	}
	
	public static void main(String [] args) {
		String haystack = "manibhushan";
		String needle = "bhush";
		
		System.out.println("index: " + strStr(haystack, needle));
	}
}
