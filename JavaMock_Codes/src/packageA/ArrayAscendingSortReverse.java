package packageA;

import java.util.Arrays;
import java.util.*;
import java.util.TreeSet;

public class ArrayAscendingSortReverse {
	
	public static void main(String[] args) {
		
		String[] a= {"Gmail", "Yahoo", "Rediff", "Google"};
			
		List<String> st=new ArrayList<String>(Arrays.asList(a));
		
		List<String> st1=new ArrayList<String>();
		
		for(String s:st) {
			
			String o="";
			
			for(int i=s.length()-1;i>=0;i--) {
				
				o=o+s.charAt(i);
			}
			
			st1.add(o);
		}
		
		Collections.sort(st1);
	
		System.out.println(st1);
		
		
	}

}
