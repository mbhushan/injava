package i_PrettyJSON;

import java.util.ArrayList;

public class PrettyJSON {

	public static ArrayList<String> prettyJSON(String str) {
		ArrayList<String> result = new ArrayList<String>();
	    if (str.length() == 0) 
	        return result;
	 
	    str = str.trim();
	    String indent = "";
	    StringBuffer curr = new StringBuffer();
	    int i = 0, len = str.length();
	     
	    while (i < len)
	    {
	        curr.append(str.charAt(i));
	        switch(str.charAt(i))
	        {
	            case ',':
	                result.add(curr.toString());
	                curr.setLength(0);
	                curr.append(indent);
	                i++;
	                break;
	 
	            case ':':
	                i++;
	                if (str.charAt(i) == '{' || str.charAt(i) == '[')
	                {
	                    result.add(curr.toString());
	                    curr.setLength(0);
	                    curr.append(indent);
	                }
	                break;
	 
	            case '{':
	            case '[':
	 
	                i++;
	                result.add(curr.toString());
	                if (i < len && (str.charAt(i) != '}' || str.charAt(i) != ']'))
	                {
	                    indent += ('\t');
	                }
	                curr.setLength(0);
	                curr.append(indent);
	                break;
	 
	            case '}':
	            case ']':
	                i++;
	                if (i < len && str.charAt(i) == ',') break;
	                result.add(curr.toString());
	                if (i < len && (str.charAt(i) == '}' || str.charAt(i) == ']'))
	                {
	                    if (!indent.isEmpty()) indent = indent.substring(1, indent.length());
	                }
	                curr.setLength(0);
	                curr.append(indent);
	                break;
	 
	            default : 
	                i++;
	                if (i < len && (str.charAt(i) == '}' || str.charAt(i) == ']'))
	                {
	                    result.add(curr.toString());
	                    if (!indent.isEmpty()) indent = indent.substring(1, indent.length());
	                    curr.setLength(0);
		                curr.append(indent);
	                }
	        }
	    }
	    return result;
	}
	public static void main(String[] args) {
		String a =  "{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}";
		ArrayList<String> res = prettyJSON(a);
		
		for (int i=0; i<res.size(); i++) {
			System.out.println(res.get(i));
		}
		
				
	}
}
