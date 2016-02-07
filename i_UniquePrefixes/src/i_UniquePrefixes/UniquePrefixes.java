package i_UniquePrefixes;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePrefixes {
	
	public static void main(String[] args) {
		String[] strs = {"zebra", "dog", "duck", "dove"};
		
		ArrayList<String> strings = new ArrayList<String>();
		for (int i=0; i<strs.length; i++) {
			strings.add(strs[i]);
		}
		
		ArrayList<String> result = prefix(strings);
		for (String st: result) {
			System.out.print(st + " ");
		}
		System.out.println();
			
	}

	public static ArrayList<String> prefix(ArrayList<String> strings) {
		int size = strings.size();
        String[] pre = new String[size];
        
         
        for(int i=0;i<pre.length;++i){
            pre[i]=Character.toString(strings.get(i).charAt(0)); 
            checkPrefix(strings, pre, pre[i], i);
        } 
        for (String st: strings) {
        	System.out.println(st + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(pre));
        
        ArrayList<String> prefixes = new ArrayList<String>( Arrays.asList(pre));
        
        return  prefixes;
	}
	
    private static void checkPrefix(ArrayList<String> strings, String[] pre, String s, int index){
        
        for(int i=index-1;i>=0;--i){
            if(s.matches(pre[i])){ 

                if(s.length()==strings.get(i).length()){
                    //System.out.println("Can't update the previous one, need to update this one");
                    pre[index] = strings.get(index).substring(0, s.length()+1);
                    checkPrefix(strings, pre, pre[index], index);
                    return;
                }
                else if(s.length() < strings.get(i).length()){ 
                    //System.out.println("Can update the previous one");
                    pre[i] = strings.get(i).substring(0, s.length()+1);
                    checkPrefix(strings, pre, pre[i], i);
                    return;
                } 
            }
        }
    }
}
