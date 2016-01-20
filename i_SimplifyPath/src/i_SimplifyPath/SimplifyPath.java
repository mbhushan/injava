package i_SimplifyPath;

import java.util.Stack;

public class SimplifyPath {
	
	public static void main(String[] args) {
		String st = "/a/./b/../../c/";
		System.out.println("path: " + st);
		System.out.println("simplified path: " + simplifyPath(st));
	}

	public static String simplifyPath(String path) {
		if (path == null || path.charAt(0) != '/') return null;  
		   
		   // split by "/"  
		   String[] splits = path.split("/");  
		   
		   // simplify  
		   Stack stack = new Stack();  
		   for (String split : splits) {  
		     if (split.equals("..") && !stack.isEmpty()) stack.pop();  
		     else if (!split.equals(".") && !split.equals("..") && !split.isEmpty()) {  
		       stack.push(split);  
		     }  
		   }  
		   
		   // print new path  
		   if (stack.isEmpty()) return "/";  
		   StringBuilder sb = new StringBuilder();  
		   while (!stack.isEmpty()) {  
		     sb.insert(0, "/" + stack.pop());  
		   }  
		   return sb.toString();
	}
}
